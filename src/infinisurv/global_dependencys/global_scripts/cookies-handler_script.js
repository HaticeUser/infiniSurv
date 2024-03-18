

export class CookieHandler{

    constructor(){

    }

    setCookie(name, value , hours){
        const date = new Date();
        date.setTime(date.getTime() + (hours*60*60*1000));
        let expires = "expires=" + date.toUTCString();
        document.cookie = name + "=" + value + ";" + expires + ";path=/";


    }

    getCookie(cookie){
        const cookieValue = cookie + "=";
        let decodedCookie = decodeURIComponent(document.cookie);
        let splittedCookie = decodedCookie.split(';');
        for(let i = 0; i < splittedCookie.length; i++){
            let charV = splittedCookie[i];
            while(charV.charAt(i) == " "){
                charV = charV.substring(1);
            }
            if(charV.indexOf(cookieValue) == 0){
                return charV.substring(cookieValue.length, charV.length)

            }

        }

        return "";

    }

    
}