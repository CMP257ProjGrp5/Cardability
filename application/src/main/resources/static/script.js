/*document.getElementById("add-btn").onclick = function() {
    var container = document.getElementById("card-container");
    var card = document.getElementById("card");
    container.appendChild(card.cloneNode(true));
}*/

// total indx
var idx = 0;

// current selected indx
var current_idx = -1;

// add a card button
document.getElementById("add-btn").onclick = function () {
  const newCard = document.createElement("div");
  newCard.innerHTML += `<div class="card w-full max-w-sm overflow-hidden bg-white rounded-lg shadow-lg dark:bg-gray-800" id="card" onclick="setID(this.parentElement.id)"">
        <div class="w-full h-56 place-content-center icon-container" id="card-icon-container">
            <!-- Figure out how to adjust the icon! -->
            <i class="fi fi-br-heart"></i>
        </div>
        <div class="px-6 py-4 bg-gray-900">
            <h1 class="text-xl text-gray-800 dark:text-white raleway-900" id="card-name">Name of your card!</h1>

            <p class="py-2 text-gray-700 dark:text-gray-400 raleway-500" id="card-desc">Add a Short Description!</p>
        </div>
    </div>`;
  idx++;
  newCard.setAttribute("id", idx);
  $("#card-container").append(newCard);
};

// various popups
var cardNameInp = document.getElementById("card-name-input");
var cardColorInp = document.getElementById("card-color-input");
var cardDescInp = document.getElementById("card-desc-input");

// Hides popups
function hidePopups() {
  cardNameInp.style.display = "none";
  cardColorInp.style.display = "none";
  cardDescInp.style.display = "none";
  uncheckRadio();
}

// card name pop up
document.getElementById("name-btn").onclick = function () {
  // open text box popup
  // input name
  if (cardNameInp.style.display == "none") {
    hidePopups();
    cardNameInp.style.display = "block";
  } else {
    cardNameInp.value = "";
    hidePopups();
  }
};

// Edit card name
document
  .getElementById("card-name-input")
  .addEventListener("keypress", function (e) {
    if (e.key == "Enter") {
      if (current_idx != -1) {
        var card = document.getElementById(current_idx);
        var name = card.querySelector("#card-name");
        name.textContent = this.value;
      }
    }
  });

// card color pop up
document.getElementById("color-btn").onclick = function () {
  // open text box popup
  // choose color
  if (cardColorInp.style.display == "none") {
    hidePopups();
    cardColorInp.style.display = "block";
  } else {
    hidePopups();
  }
};

let color1 = document.getElementById("color-1");
let color2 = document.getElementById("color-2");
let color3 = document.getElementById("color-3");
let color4 = document.getElementById("color-4");
let color5 = document.getElementById("color-5");

// edit color
color1.onclick = function () {
  var color = "#FF595E";
  if (current_idx != -1) {
    var card = document.getElementById(current_idx);
    var bg_color = card.querySelector("#card-icon-container");
    bg_color.style.backgroundColor = color;
  }
};

// edit color
color2.onclick = function () {
  var color = "#FFCA3A";
  if (current_idx != -1) {
    var card = document.getElementById(current_idx);
    var bg_color = card.querySelector("#card-icon-container");
    bg_color.style.backgroundColor = color;
  }
};

// edit color
color3.onclick = function () {
  var color = "#8AC926";
  if (current_idx != -1) {
    var card = document.getElementById(current_idx);
    var bg_color = card.querySelector("#card-icon-container");
    bg_color.style.backgroundColor = color;
  }
};

// edit color
color4.onclick = function () {
  var color = "#1982C4";
  if (current_idx != -1) {
    var card = document.getElementById(current_idx);
    var bg_color = card.querySelector("#card-icon-container");
    bg_color.style.backgroundColor = color;
  }
};

// edit color
color5.onclick = function () {
  var color = "#6A4C93";
  if (current_idx != -1) {
    var card = document.getElementById(current_idx);
    var bg_color = card.querySelector("#card-icon-container");
    bg_color.style.backgroundColor = color;
  }
};

// unchecks radio buttons after user has closed the popup
function uncheckRadio() {
  color1.checked = false;
  color2.checked = false;
  color3.checked = false;
  color4.checked = false;
  color5.checked = false;
}

// card description popup
document.getElementById("desc-btn").onclick = function () {
  // open text box popup
  // input desc
  if (cardDescInp.style.display == "none") {
    cardDescInp.value = "";
    hidePopups();
    cardDescInp.style.display = "block";
  } else {
    cardDescInp.value = "";
    hidePopups();
  }
};

// edit card description
document
  .getElementById("card-desc-input")
  .addEventListener("keypress", function (e) {
    if (e.key == "Enter") {
      if (current_idx != -1) {
        var card = document.getElementById(current_idx);
        var desc = card.querySelector("#card-desc");
        desc.textContent = this.value;
      }
    }
  });

// edit card icon: TODO
document.getElementById("icon-btn").onclick = function () {
  // open text box popup
  // input name
};

// delete element button
document.getElementById("del-btn").onclick = function () {
  if (current_idx != -1) {
    const element = document.getElementById(current_idx);
    element.remove();
    //if(idx >= 0) {

    //}
    current_idx = -1;
  }
};

// sets ID of selected card
function setID(id) {
  if (current_idx != id) {
    // then we select the card and change border
    // deselect previous card
    if (current_idx != -1) {
      var card = document.getElementById(current_idx).querySelector("#card");
      card.style.border = "";
      card.style.borderStyle = "none";
    }

    // select
    current_idx = id;
    var card = document.getElementById(current_idx).querySelector("#card");
    card.style.border = "black";
    card.style.borderStyle = "solid";
  } else {
    // we clicked on the same card, deselect it
    var card = document.getElementById(current_idx).querySelector("#card");
    card.style.border = "";
    card.style.borderStyle = "none";
    current_idx = -1;
  }
}

function registerUser (event) {

    event.preventDefault(); // Prevent the default form submission
    
    // Gather form data
    const username = document.getElementById('Email').value;
    const password = document.getElementById('Password').value;
    
    // add if we have time!
    const passwordconf = document.getElementById('PasswordConfirmation').value;

    // Create the data object
    const data = {
        username: username,
        password: password

    };


    // Create an AJAX request
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/register', true); // Adjust the URL as needed
    xhr.setRequestHeader('Content-Type', 'application/json');


    // Set up a callback function to handle the response
    xhr.onload = function() {

        if (xhr.status === 200) {

            document.getElementById('responseMessage').innerText = 'Registration successful!';

        } else {

            document.getElementById('responseMessage').innerText = 'Registration failed: ' + xhr.responseText;

        }

    };

    // Send the request with the JSON data
    xhr.send(JSON.stringify(data));
}
