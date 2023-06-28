package com.se2.kursplaner.event;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.data.UnfoldingReader;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;

import org.javatuples.Pair;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.se2.kursplaner.model.Modul;
import com.se2.kursplaner.model.ModulRepository;
import com.se2.kursplaner.model.Studiengang;
import com.se2.kursplaner.model.StudiengangRepository;
import com.se2.kursplaner.model.Termin;
import com.se2.kursplaner.model.TerminRepository;


@Component
public class DateiLoader implements CommandLineRunner{

    @Autowired
    private StudiengangRepository studiengangRepository;
    @Autowired
    private ModulRepository modulRepository;
    @Autowired
    private TerminRepository terminRepository;


    @Override
    public void run(String... args) throws Exception {
        JSONParser jsonParser = new JSONParser();
        System.out.print("LOAD START");
        
        try (FileReader reader = new FileReader("./config.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject data = (JSONObject) obj;
            JSONArray studiangangList = (JSONArray) data.get("data");

            for (Object studiengangObject : studiangangList) {

                JSONObject studiengang = (JSONObject) studiengangObject;
                String studiengangName = (String) studiengang.get("StudingangName");
                Studiengang studiengangData = studiengangRepository.findByName(studiengangName);
                String studiengangKuerzel = (String) studiengang.get("StudiengangKuerzel");
                int studiengangSemesteranzahl = ((Long) studiengang.get("StudiengangSemesteranzahl")).intValue();

                //Studingang erstellen wenn nicht vorhanden
                if(studiengangData == null){
                    studiengangData = new Studiengang(studiengangName, studiengangKuerzel, studiengangSemesteranzahl);
                    studiengangRepository.save(studiengangData);
                }

                
                JSONArray modulList = (JSONArray) studiengang.get("module");

                for (Object modulObject : modulList) {
                    
                    JSONObject modul = (JSONObject) modulObject;

                    String load = (String) modul.get("load");
                    String modulName = (String) modul.get("modulName");
                    String path = (String) modul.get("terminFile");
                    Long number = (Long) modul.get("semester");
                    int semester = number.intValue();
                    String modulKuerzel = (String) modul.get("modulKuerzel");

                    Modul modulData = modulRepository.findByNameAndStudiengang(modulName, studiengangData);

                    if(load.equals("once") && modulData == null){

                        modulData = new Modul(modulName, modulKuerzel, studiengangData, semester);
                        modulRepository.save(modulData);
                        List<Pair<Date, Date>> terminListe = DateiLoader.extraktKalenderDaten(path);
                        DateiLoader.addTermine(terminListe, modulData, terminRepository);
                        modulRepository.save(modulData);
                    }
                    else if(load.equals("always")) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("LOAD END");
    }

    private static void addTermine(List<Pair<Date, Date>> termineListel, Modul modul, TerminRepository terminRepository){
        Termin termin;

        for (Pair<Date,Date> pair : termineListel) {
            Date start = (Date) pair.getValue(0);
            Date ende = (Date) pair.getValue(1);
            termin = new Termin(start, ende, modul);
            terminRepository.save(termin);
        }
    }

    private static List<Pair<Date, Date>> extraktKalenderDaten(String path) throws FileNotFoundException, IOException, ParserException{
        List<Pair<Date, Date>> terminList = new LinkedList<>();

        try {
            CalendarBuilder builder = new CalendarBuilder();
            Calendar calendar = builder.build(new UnfoldingReader(new FileReader(path), true));

            for (final Object o : calendar.getComponents()) {
                net.fortuna.ical4j.model.Component component = (net.fortuna.ical4j.model.Component)o;
                
                if (component.getName().equals("VEVENT")) {
                    DtStart start = (DtStart) component.getProperty(DtStart.DTSTART);
                    DtEnd ende = (DtEnd) component.getProperty(DtEnd.DTEND);
                    Pair<Date, Date> termin = new Pair<Date, Date>(start.getDate(), ende.getDate());
                    terminList.add(termin);
                }
            }

            return terminList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        

        
    }
}
