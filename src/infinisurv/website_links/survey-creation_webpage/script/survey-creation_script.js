export class SurveryCreation {
  constructor() {
    this.createdInput_Container = document.getElementById(
      "createdInput-Container"
    );
    this.theme_Input = document.getElementById("themeInput");
    this.theme_Input_ID = 0; // wird nicht gehen

    this.input = document.createElement("input");
    this.deleteButton = document.createElement("input");
    this.opinionInput_Container = document.createElement("div");

    this.createdInput = 0;
    this.generated_ObjectID = 111.1; // wird nicht gehen
    this.inputID = 1; // wird nicht gehen
    this.likes = 0;
    this.savings = 0;

    this.user_storings_disabled = true;
    this.likes_disabled = false;

    this.opinionInput_Array = []; 
    this.deleteButtons = [];
    this.inputs = []; // wird nicht gehen
    this.inputIDs = [];  // wird nicht gehen
    this.input_Data = [];

    //  Vielleicht von meiner Datenbank den größten stant des innhalts holen übergebn, hier plus rechnen und dann weiter übergeben

  }

  handleHTMLCreation() {
    if (this.createdInput < 4) {
      this.createdInput++;
      this.input = document.createElement("input");
      this.deleteButton = document.createElement("input");
      this.deleteButton.setAttribute("type", "button");
      this.deleteButton.setAttribute("value", "X");
      this.opinionInput_Container = document.createElement("div");
      this.opinionInput_Container.classList.add("OpinionInput-Container");
      this.deleteButton.classList.add("deleteInput-btn");
      this.input.type = "text";
      this.input.placeholder = "Answer";
      this.input.size = 40;
      this.input.classList.add("opinionInput");
      this.input.id = this.inputID++;
      this.inputIDs.push(this.input.id);
      this.createdInput_Container.appendChild(this.opinionInput_Container);
      this.opinionInput_Container.append(this.input);
      this.opinionInput_Container.appendChild(this.deleteButton);
      this.inputs.push(this.input);
      this.opinionInput_Array.push(this.opinionInput_Container);

      this.deleteButtons.push(this.deleteButton);

      this.deleteButtons.forEach((delBtn) => {
        delBtn.addEventListener("click", (event) => {
          try {
            this.inputIDs.splice(this.inputIDs[this.inputID], 1);
            this.inputs.splice(this.inputs[this.createdInput], 1);
            this.input.id = this.inputID--;
            this.createdInput--;
            event.target.parentElement.remove();
            // Bug gefunden, mit dem einzelnden löschen der inputs, inputs werden dennoch anerkannt beim publishen.
          } catch (e) {
            alert("problem " + e + "occured");
          }
        });
      });
    }
  }

  saveData() {
    let objIdToString = this.generated_ObjectID.toString();
    let returnObjIDNumbers = objIdToString.substring(0, 5);

    let inputData = {
      input_Theme_Value: this.theme_Input.value,
      input_Theme_ID: this.theme_Input_ID,  // wird nicht gehen
      input_Values: [],
      likes: this.likes,
      likes_disabled: this.likes_disabled,
      user_storings: this.savings,
      user_storings_disabled: this.user_storings_disabled,
      object_ID: returnObjIDNumbers,
    };

    for (let i = 0; i < this.createdInput; i++) {
      let object = {
        inputValue: this.inputs[i].value,
        inputID: this.inputIDs[i],
      };

      inputData.input.input_ValueID.push(object);
    }

    this.input_Data.push(inputData);
    this.theme_Input_ID++; // wird nicht gehen
    this.generated_ObjectID += 111.1; // wird nicht gehen
    console.log(inputData);
    // this.sendDataToBackend(inputData);
  }
  handlePublication() {
    if (this.input.value == "" || this.theme_Input.value == "") {
    } else {
      try {
        this.saveData();
        this.handleReset();
        // setTimeout(handleLocationID(0.12),5000);
      } catch (e) {
        throw "Fehler:" + e;
      }
    }
  }

  handleReset() {
    this.createdInput = 0;
    this.theme_Input.value = "";
    this.inputs.forEach((input) => {
      input.removeEventListener("keydown", this.handleInputKeyDown);
      input.value = "";
    });

    // removen der divs kümmern

    this.opinionInput_Array.forEach((opInp_Container) => {
      opInp_Container.remove();
    });

    this.input_Data = [];
    this.inputs = [];
    this.inputValues = [];
    this.opinionInput_Array = [];
  }

}
