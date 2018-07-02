function submit(){

  var URL = "http://localhost:8080/identity/users";


  console.log("Button Clicked");
  ajaxFunction(URL, "json");

  console.log("Data retreived");



}

function ajaxFunction( URL, dataType){

var settings = {
  "async": true,
  "crossDomain": true,
  "url": URL,
  "contentType" : "application/json",
  "dataType" : dataType,
  "data" : {},
  //"dataType" : "application/json",

  "method": "GET",
  "headers": {
    "Authorization": "Basic " +  btoa('kermit' + ':' + 'kermit'),
    "Access-Control-Allow-Headers" : true,
    "cache-control": "no-cache",
  }
}


$.ajax(settings).done(function (response) {
  
  console.log(response);
  
});

}


$(document).ready (function(){

var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/test/World",
  "contentType" : "application/json",
  "dataType" : "text",
  "data" : {},
  //"dataType" : "application/json",

  "method": "GET",
  "headers": {
    "Authorization": "Basic " +  btoa('kermit' + ':' + 'kermit'),
    "Access-Control-Allow-Headers" : true,
    "cache-control": "no-cache",
  }
}

console.log("1");

$.ajax(settings).done(function (response) {
  console.log("2.1");
  console.log(response);
  console.log("2.2");
});


console.log("3");

});