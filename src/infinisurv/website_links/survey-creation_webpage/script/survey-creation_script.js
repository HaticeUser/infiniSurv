export class SurveryCreation {
  constructor() {
    this.createdInput_Container = document.getElementById("createdInput-Container");
    this.theme_Input = document.getElementById("themeInput");

    this.input = document.createElement("input");
    this.deleteButton = document.createElement("input");
    this.opinionInput_Container = document.createElement("div");

    this.createdInput = 0; // Brauchen wir
    this.opinionInput_Array = [];  // Brauchen wir
    this.deleteButtons = []; // Brauchen wir
    this.input_Data = []; // Brauchen wir
    this.inputs = [];
    //  Vielleicht von meiner Datenbank den größten stant des innhalts holen übergebn, hier plus rechnen und dann weiter übergeben

  }

  handleHTMLCreation() {
    try {
      this.createInputs();
      this.createDeleteButtons();

    } catch (error) {
      console.error("Problems with HTML Components Creation (function Calling): ", error);
    }
    
  }

  createInputs(){
    try {
      if (this.createdInput < 5) {
        this.createdInput++;
        this.input = document.createElement("input");
        this.opinionInput_Container = document.createElement("div");
        this.opinionInput_Container.classList.add("OpinionInput-Container");
        this.deleteButton.classList.add("deleteInput-btn");
        this.input.type = "text";
        this.input.placeholder = "Answer";
        this.input.size = 40;
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

  createDeleteButtons(){
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
     
    
                this.inputs.splice(this.inputs[this.createdInput], 1);
        
                this.createdInput--;
                event.target.parentElement.remove();
                // Bug gefunden, mit dem einzelnden löschen der inputs, inputs werden dennoch anerkannt beim publishen.
            
            });
          });
        } catch (error) {
          console.error("Problems with Deleting-Inputs: ", error);
        }}
    } catch (error) {
      console.error("Problems with Creating-DeleteButtons: ", error);
    }}


}