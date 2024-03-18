"use strict"

export class LocationsHandler{
    constructor() {
}

    fetchLocationData(locationID){
        fetch("../../resources/json/locations_data.json")
        .then((res) => {
            if (!res.ok) {
                throw new Error
                    (`HTTP error! Status: ${res.status}`);
            }
            return res.json();
        })
        .then((locationData) => 
              this.locationHandler(locationData,locationID)
              )
        .catch((error) => console.error("Unable to fetch data:", error));
    }

    locationHandler(locationData,locationID){

        for(let i = 0 ; i <= locationData.length; i++){
            try{
                if(locationID == locationData[i].LocID ){
                location.href = locationData[i].urlLink;
                break;
            }
            }catch(err){
                throw "Dieser link wurde nicht gefunden" + err;
            }

        }
    }
}

