import { ApiInterfaceHandler } from "../../../global_dependencys/global_scripts/api-handler_script.js";

export class SurveryCreation {
  constructor() {
    this.apiInterfaceHandler = new ApiInterfaceHandler();
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
    this.inputs = [];

    this.user_storings_disabled = true;
    this.user_storings = 0;
    this.likes_disabled = true;
    this.likes = 0;
    this.user_storings = 0;
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

  saveData() {
    try {
      let createdPostData = {
        question: this.theme_Input.value,
        answerBox_0: {
          value: "",
          id: 0,
          votes: 0,
        },
        answerBox_1: {
          value: "",
          id: 1,
          votes: 0,
        },
        answerBox_2: {
          value: "",
          id: 2,
          votes: 0,
        },
        answerBox_3: {
          value: "",
          id: 3,
          votes: 0,
        },
        likes: this.likes,
        likes_disabled: this.likes_disabled,
        opinionlength: this.inputs.length,
        user_storings: this.user_storings,
        user_storings_disabled: this.user_storings_disabled,
      };
      for (let index = 0; index < this.inputs.length; index++) {
        let answerBox = createdPostData[`answerBox_${index}`];
        answerBox.value = this.inputs[index].value; 
        console.log( answerBox.value = this.inputs[index].value)
      }


      console.log(createdPostData);
      return createdPostData;
    } catch (error) {
      throw new Error(
        "Problem with calling savingData() function, a Problem occured here:" +
          error
      );
    }
  }

  handlePublication() {
    if (this.input.value != "" && this.theme_Input.value != "") {
      try {
      
        let dataSaved =  this.saveData();
        setTimeout(this.apiInterfaceHandler.postsApiHandler(dataSaved),1000);
        setTimeout(this.handleReset(), 3000);
        // setTimeout(handleLocationID(0.12),5000);
      } catch (error) {
        throw new Error(
          "Problem with calling handlePublication, couldnt call saveData() and handleReset():" +
            error
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
        input.value = "";
      });

      this.opinionInput_Array.forEach((opInp_Container) => {
        opInp_Container.remove();
      });

      this.inputs = [];
      this.opinionInput_Array = [];
    } catch (error) {
      throw new Error("Problem with the handleReset() function:" + error);
    }
  }
}


      