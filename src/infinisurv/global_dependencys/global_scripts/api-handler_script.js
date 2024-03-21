export class ApiInterfaceHandler{

    constructor(){

    }

    async signUpApiHandler(signUpData){
        try{
           const response = await fetch("http://localhost:8080/signup",{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(signUpData)
           
        });
        
        if(!response.ok){
            throw new Error("Fehler beim senden der Daten");
        }
        const responseData= await response.text();
        console.log(signUpData);
        console.log("Antwort vom Server: " + responseData);
    
        }catch(err){
            console.error("A problem occured: " + err)
        }
        
       
    }

    async loginApiHandler(loginData){
        try{
             const response = await fetch("http://localhost:8080/login",{
                method:'POST',
                headers:{
                    'Content-Type':'application/json'
                },
                body: JSON.stringify(loginData)

             });

             if(!response.ok){
                throw new Error("Fehler beim senden der Daten");
             }

            const responseData = await response.text(); //test
            console.log("Der server antwortet mit" + responseData)
            return responseData;

        }catch(err){
            console.error("A problem occured: " + err)
        }

    }

    async postsApiHandler(postData){
        try{
            const response = await fetch("http://localhost:8080/surveycreation",{
               method:'POST',
               headers:{
                   'Content-Type':'application/json'
               },
               body: JSON.stringify(postData)

            });

            if(!response.ok){
               throw new Error("Fehler beim senden der Daten");
            }

           const responseData = await response.text(); //test
           console.log("Der server antwortet mit" + responseData)
           return responseData;

       }catch(err){
           console.error("A problem occured: " + err)
       }


    }}