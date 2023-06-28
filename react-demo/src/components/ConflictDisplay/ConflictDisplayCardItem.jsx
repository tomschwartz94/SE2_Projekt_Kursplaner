import React from "react";
import Table from 'react-bootstrap/Table';
import moment from 'moment';

const ConflictDisplayCard = ({ option }) => {

    return (
        
        <Table striped bordered hover>
            <thead>
                <tr>
                <th>Modul</th>
                <th>Start</th>
                <th>Ende</th>
                <th>Modul</th>
                <th>Start</th>
                <th>Ende</th>
                </tr>
            </thead>
            {option.map(element => {
                return(
                    <thead>
                        <tr>
                        <th>{element.termin_a.modul.name}</th>
                        <th>{moment(new Date( element.termin_a.start )).format("MMMM Do YYYY, h:mm a")}</th>
                        <th>{moment(new Date( element.termin_a.ende )).format("MMMM Do YYYY, h:mm a")}</th>
                        <th>{element.termin_b.modul.name}</th>
                        <th>{moment(new Date( element.termin_b.start )).format("MMMM Do YYYY, h:mm a")}</th>
                        <th>{moment(new Date( element.termin_b.ende )).format("MMMM Do YYYY, h:mm a")}</th>
                        </tr>
                    </thead>
                )
            })}
        </Table>
    );
};

export default ConflictDisplayCard;