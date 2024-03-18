
export class InputSanitizing {

    constructor(){
        this.authorizedInput = false;
        this.firstname = document.getElementById("firstname");

    }

    readSignUpInput(){
      let b =  this.firstname.value
      console.log(b)
    }

    readLoginInput(){

    }


    sanatizeInput(){

    }
}