

export class PasswordGuidelines{
    constructor(){
        this.password = document.getElementById("password");

    }

    passwordguidlines(){
        console.log("")
        let alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        let number = "1234567890";
        let specialCharacter = "-_.,!#$%&*+?=()[]{}|"
        let IncludesInPassword = [];
        
        let userPassword = "My_Password.56"

        while(userPassword.length < 8){
            for (let index = 0; index < userPassword.length; index++) {
                while(userPassword.charAt(index).includes(number.charAt(index))){
                    number = true;
    
                } 
            }
        }
    }

    showTrueChanges(){
       let passwordV = this.password.value
        console.log(passwordV);

    }
}