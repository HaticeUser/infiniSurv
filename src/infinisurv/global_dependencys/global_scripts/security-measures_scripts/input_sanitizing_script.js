export class InputSanitizing {
  constructor() {
    this.authorizedInput = false;
 

    //ansatt so, sollen die entsrechend seiten ihre variabeln selber geben damit ihc nicht bie
    //jedem hier auch nochmla den documetnhtml holen muss und eine variabel erstellen muss, dann werden nur die inputs verarbeitet von der entsprechenden seite und nciht von allen
  }

  processData(ArrayData){
    this.readSignUpInput(ArrayData);
 

  }

  readSignUpInput(ArrayData) {
    const specialCharacter = /[&<>|+;:,]/gi; //fixes wie z.b SQL injections  /[&<>|+;:,]select/gi

    try {
      for (let index = 0; index < ArrayData.length; index++) {
        let Arraystandpunkt = ArrayData[index].toLowerCase();
        let Sanatized = Arraystandpunkt.replace(specialCharacter, "");
        //alert("Did Work:" + "try: " + index + "sanatized: " + Sanatized );

        // ArrayData[index] != Arraystandpunkt &&
        if(index >= ArrayData.length - 1){
          console.log("true")
          return true;
        }
      }

      
    } catch (error) {
      console.error("Problems with sanatizing: ", error);
      throw "Oh you hacked me, here your data: Too dumb to hack :)";
    }
  }


}
