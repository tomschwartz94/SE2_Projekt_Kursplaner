import React, { useContext } from 'react'
import ConflictProvider from "../Contexts/ConflictDisplayContext";
import ConflictDisplayCard from "./ConflictDisplayCard"

const ConflictDisplay = () => {

    const { conflictOptions } = useContext(ConflictProvider);
    
    return (
        <div id="FehlerAnzeige" style={{ marginLeft: "50px" }}>
            <h4>Kurs Konflikte:</h4>
            { conflictOptions !== undefined && (
                <div>
                    { 
                    conflictOptions.map(ele  => {
                        return <ConflictDisplayCard option={ele}/>;
                }) 
                    }
                </div> 
          )}
        </div>
    );
  };
  
  export default ConflictDisplay;
  