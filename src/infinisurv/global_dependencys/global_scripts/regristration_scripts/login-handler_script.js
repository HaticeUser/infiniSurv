import {ApiInterfaceHandler} from "../api-handler_script.js"
import { CookieHandler } from "../cookies-handler_script.js";


export class LoginHandler {

    constructor(){
        this.loggedIn_display = document.getElementById("loggedIn-display");
        this.login_Container_Visibility = document.getElementById("login-Container-Visbility");
        this.email = document.getElementById("login-email");
        this.password = document.getElementById("login-password");
        this.apiInterfaceHandler = new ApiInterfaceHandler();
        this.cookieHandler = new CookieHandler;
    }


    processLoginData(){
        const loginData = {
            email:this.email.value,
            password:this.password.value,
        }

    this.apiInterfaceHandler.loginApiHandler(loginData).then(succesfullLogin =>  this.accountExistsCheck(succesfullLogin));
       
    }

    checkLoginCookies(){
        let loginBool = this.cookieHandler.getCookie("loggedIn")
        if(loginBool === "true"){
            this.login_Container_Visibility.style.display ="none";
            document.body.style.pointerEvents = "auto";
           
        }else{
            this.loggedIn_display.classList.add("loggedIn-false");
            document.body.style.pointerEvents = "none";
        }
    }

    accountExistsCheck(succesfullLogin){
        if(succesfullLogin === "true"){
            this.loggedIn_display.classList.add("loggedIn-true");
            this.cookieHandler.setCookie("loggedIn", "true" , 3);
            setTimeout(() => {
                this.login_Container_Visibility.style.display ="none";
            }, 1000);
        }else{
            alert("Sie haben noch kein Konto, melden Sie sich an");
        }
    }







}






