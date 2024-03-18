import { LocationsHandler } from "./location-handler_script.js";
import { LoginHandler } from "./regristration_scripts/login-handler_script.js";
import { SignUpHandler } from "./regristration_scripts/sign-up-handler_script.js";
import { PasswordGuidelines } from "./security-measures_scripts/password-guidelines_script.js";
import { InputSanitizing } from "./security-measures_scripts/input_sanitizing_script.js";

const loginhandler = new LoginHandler();
const signUpHandler = new SignUpHandler();
const locationHandler = new LocationsHandler();
const passwordGuidelinesHandler = new PasswordGuidelines();
const sanitizeInputHandler = new InputSanitizing();

export function forwardingLocationID(locationID){
    locationHandler.fetchLocationData(locationID);
}

export function forwardingSignUpData(event){
    event.preventDefault();
    
    if(sanitizeInputHandler.readSignUpInput()){
        signUpHandler.processSignUpData();
    }

}

export function forwardingLoginData(event){
    event.preventDefault();
    
    if(sanatizeInputHandler.readSignUpInput()){
        loginhandler.processLoginData();
    }


}

export function callLoginHandler(event){
    event.preventDefault();
    loginhandler.checkLoginCookies();
}

export function forwardingChangeOnInput(event){
    event.preventDefault();
    passwordGuidelinesHandler.showTrueChanges();

    // Sanatizing auf hier ?

    // sanatizeInputHandler.readSignUpInput(sanatized);
    // if(sanatized){
    //    passwordGuidelinesHandler.showTrueChanges();;
    // }

    
    

}
