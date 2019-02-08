"use strict";

document.addEventListener("keypress", function (e) {
    var key = e.which || e.keyCode;
    if (key === 72) { // 13 is enter
        // Container <div> where dynamic content will be placed
        var container = document.getElementById("leggtil2");
    	  container.appendChild(document.createTextNode("Vare "));
          // Create an <input> element, set its type and name attributes
          var input = document.createElement("input");
          input.type = "text";
          input.name = "uvare" + i;
          container.appendChild(input);
          // Append a line break 
          container.appendChild(document.createElement("br"));
    }
});