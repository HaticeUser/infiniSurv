import { ApiInterfaceHandler } from "../../../global_dependencys/global_scripts/api-handler_script.js";

export class SurveryCreation {
  constructor() {
    this.apiInterfaceHandler = new ApiInterfaceHandler;
    this.createdInput_Container = document.getElementById(
      "createdInput-Container"
    );
    this.theme_Input = document.getElementById("themeInput");

    this.input = document.createElement("input");
    this.deleteButton = document.createElement("input");
    this.opinionInput_Container = document.createElement("div");

    this.createdInput = 0; 
    this.opinionInput_Array = []; 
    this.deleteButtons = []; 
    this.input_Data = []; 
    this.inputs = [];
    
  }

  handleHTMLCreation() {
    try {
      this.createInputs();
      this.createDeleteButtons();
    } catch (error) {
      console.error(
        "Problems with HTML Components Creation (function Calling): ",
        error
      );
    }
  }

  createInputs() {
    try {
      if (this.createdInput < 4) {
        this.createdInput++;
        this.input = document.createElement("input");
        this.opinionInput_Container = document.createElement("div");
        this.opinionInput_Container.classList.add("OpinionInput-Container");

        this.input.type = "text";
        this.input.placeholder = "Answer";
        this.input.size = 40;
        this.input.required = true;

        this.input.classList.add("opinionInput");
        this.createdInput_Container.appendChild(this.opinionInput_Container);
        this.opinionInput_Container.append(this.input);
        this.inputs.push(this.input);
        this.opinionInput_Array.push(this.opinionInput_Container);
      }
    } catch (error) {
      console.error("Problems with Creating-Inputs: ", error);
    }
  }

  createDeleteButtons() {
    try {
      if (this.createdInput < 5) {
        this.deleteButton = document.createElement("input");
        this.deleteButton.setAttribute("type", "button");
        this.deleteButton.setAttribute("value", "X");
        this.deleteButton.classList.add("deleteInput-btn");
        this.opinionInput_Container.appendChild(this.deleteButton);
        this.opinionInput_Array.push(this.opinionInput_Container);

        this.deleteButtons.push(this.deleteButton);

        try {
          this.deleteButtons.forEach((delBtn) => {
            delBtn.addEventListener("click", (event) => {
              // logik ausbessern
              this.inputs.splice(this.inputs[this.createdInput], 1);
              this.createdInput--;
              event.target.parentElement.remove();
              // Bug gefunden, mit dem einzelnden löschen der inputs, inputs werden dennoch anerkannt beim publishen.
            });
          });
        } catch (error) {
          console.error("Problems with Deleting-Inputs: ", error);
        }
      }
    } catch (error) {
      console.error("Problems with Creating-DeleteButtons: ", error);
    }
  }

  //Beim answerbox nohc die auswertungen mit reinschbeichern und dementsprechend z.b Man hat Zwei ANtworten im Fronmtened im post
  // "Katze oder hund?"
  // input 1 hat "katze"
  // input 2 hat "hund"
  // Und ein User wählt jetzt z.b Hund, dann muss der input entsprechend eine id haben damit man weiß ok, welches gehört jetzt welchem input?
  //Also wo muss der vote jetzt daszugehören ?? zu welchem input und woher weiß ioch das dann?
  // Hund hätte ja jetzt 1 vote wie lasse ich es im backend darstellen?



  saveData() {

    try {
      let inputData = {
        question: this.theme_Input.value,
        answers: {
          answerOne:"",
          answerTwo:"",
          answerThree:"",
          answerFour:"",
        },
        likes: this.likes,
        likes_disabled: this.likes_disabled,
        user_storings: this.savings,
        user_storings_disabled: this.user_storings_disabled, 
      };

      // Geht auch einfacher, finde weg wie und was ist mit leeren inputs z.b?? wie wird das üpberprüft?
      inputData.answers.answerOne = this.inputs[0].value;
      inputData.answers.answerTwo = this.inputs[1].value;
  
      // for (let i = 0; i < this.createdInput; i++) {
      //  inputData.answers.push();
      
      // }
      console.log(inputData);
      return inputData;
    } catch (error) {
      throw new Error(
        "Problem with calling handlePublication, couldnt call saveData() and handleReset():" + error
      );
    }
   
   
  }

  handlePublication() {
    if (this.input.value != "" && this.theme_Input.value != "") {
      try {
        let dataSaved = this.saveData();
        // setTimeout(this.apiInterfaceHandler.postsApiHandler(dataSaved),1000);
        setTimeout(this.handleReset(),3000);
        // setTimeout(handleLocationID(0.12),5000);
      } catch (error) {
        throw new Error(
          "Problem with calling handlePublication, couldnt call saveData() and handleReset():" + error
        );
      }
    } else {
      console.log("Input needs to have something written");
    }
  }


  handleReset() {

    try {
      this.createdInput = 0;
      this.theme_Input.value = "";
      this.inputs.forEach((input) => {
        input.removeEventListener("keydown", this.handleInputKeyDown);
        input.value = "";
      });
  
  
      this.opinionInput_Array.forEach((opInp_Container) => {
        opInp_Container.remove();
      });
  
      this.input_Data = [];
      this.inputs = [];
      this.inputValues = [];
      this.opinionInput_Array = [];
    } catch (error) {
      throw new Error(
        "Problem with calling handlePublication, couldnt call saveData() and handleReset():" + error
      );
    }
   
  }




}
