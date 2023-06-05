import React from "react";
import { Form } from "react-bootstrap";

import "../dropdownns/css/textarea.css";

function ConflictsDisplayerBoard() {
  return (
    <Form>
      <Form.Group>
        <Form.Control
          disabled
          as="textarea"
          id="w3review"
          name="w3review"
          rows={4}
          cols={50}
          defaultValue="This is just to display conflicts, don't worry it's gonna look better. I'm just too busy to fix it now!"
          className="disabled-textarea"
        />
      </Form.Group>
    </Form>
  );
}

export default ConflictsDisplayerBoard;
