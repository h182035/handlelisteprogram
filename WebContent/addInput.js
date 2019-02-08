"use strict";

//document.addEventListener("keypress", addField);
//
//
//function addField(){
//    let container = document.getElementById("varer");
//
//    let input = document.createElement("input");
//    input.type = "text";
//    input.name = "navn";
//    container.get
//    container.appendChild(input);
//    container.appendChild(document.createElement("br"));
//}

add.addEventListener("click", addField);
console.log("Hei");
function addField(){
	let container = document.getElementById("varer");
	    let i = 0;
	    for(i=0; i < 4; i++){
	    	
	    	
		    let input = document.createElement("input");
		    input.type = "text";
		    input.name = "navn";
		    input.id = "forslag"
	    	
	    	container.appendChild(input);
		    container.appendChild(document.createElement("br"));
	    }
	    
	
}
