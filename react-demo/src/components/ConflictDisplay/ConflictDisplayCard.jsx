import React, { useState } from "react";
import { Collapse } from 'react-bootstrap'
import ConflictDisplayCardItem from "./ConflictDisplayCardItem"

const ConflictDisplayCard = ({ option }) => {
    const [isVisible, initHs] = useState(false);

    function handleClick() {
        return initHs(!isVisible);
    }

    return (
        <div class="card">
            <div class="card-header" id="headingOne">
                <h5 class="mb-0">
                    <div onClick={() => handleClick()}>
                        {option.name}
                    </div>
                </h5>
            </div>
            <Collapse  in={isVisible}>
                <div id="collapseOne">
                    <div class="card-body">
                        <ConflictDisplayCardItem option={option.value} />
                    </div>
                </div>
            </Collapse>
        </div>
    );
};

export default ConflictDisplayCard;
