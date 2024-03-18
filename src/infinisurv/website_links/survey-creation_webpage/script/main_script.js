import { SurveryCreation } from "./survey-creation_script.js";

const surveyCreation = new SurveryCreation

export function handleInputCreationRequest(){
    surveyCreation.handleHTMLCreation();

}

export function handleResetRequest(){
    surveyCreation.handleReset();

}

export function handlePublicationRequest(){
    surveyCreation.handlePublication();

}

