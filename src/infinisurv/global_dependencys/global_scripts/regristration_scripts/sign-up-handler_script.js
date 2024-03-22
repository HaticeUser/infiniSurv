// import moment from "../../../../../node_modules/moment/moment.js";
import {ApiInterfaceHandler} from "../api-handler_script.js"
import { InputSanitizing } from "../security-measures_scripts/input-sanitizing_script.js";

export class SignUpHandler{

    constructor(){
        this.firstname = document.getElementById("firstname");
        this.lastname = document.getElementById("lastname");
        this.birthday = document.getElementById("birthday");
        this.username = document.getElementById("username");
        this.email = document.getElementById("email");
        this.password = document.getElementById("password");
        this.login_Inputs = document.getElementsByClassName("login-input");

        this.HTMLvar = [];

        this.apiInterfaceHandler = new ApiInterfaceHandler();
        this.sanitizeInputHandler = new InputSanitizing();
    }

    
    processSignUpData(){
        // this.HTMLvar.push(this.firstname.value,
        //     this.lastname.value,
        //     this.username.value,
        //     this.email.value,
        //     this.password.value);

        // let authorized = this.sanitizeInputHandler.processData(this.HTMLvar);
        // console.log(authorized) // bug
        // if(authorized === true){
            console.log("Aufruf") // bug
            this.calculateAge(); // bug

        // }
       
    }
    
    calculateAge(){
        //Age rechner ausbessern
        console.log("Aufruf2")
        let year = new Date().getFullYear();
        let month = new Date().getMonth();
        let day = new Date().getDay();
        let birthYear = year - Number(this.birthday.value.slice(0,4));
        let birthMonth = Number(this.birthday.value.slice(5,7));
        (birthMonth < month ) ?   this.signUpDataTransfer(birthYear) :  this.signUpDataTransfer(--birthYear); 
    }

    signUpDataTransfer(age){
        console.log("Aufruf 3")
        const signUpData = {
            firstname:this.firstname.value,
            lastname:this.lastname.value,
            age:age,
            birthday:this.birthday.value,
            username:this.username.value,
            email:this.email.value,
            password:this.password.value,
        }
        

        this.apiInterfaceHandler.signUpApiHandler(signUpData);
        for (let index = 0; index < this.login_Inputs.length; index++) {
            this.login_Inputs[index].value = "";
            
        }
    
    }

}




