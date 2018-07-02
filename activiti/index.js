function submit(){

var taskId = document.getElementById('taskId').value;
var URL = "http://localhost:8080/runtime/tasks/" + taskId;
  console.log("Submit button Clicked. URL : " + URL);
  
	var selectVal = $('#selectOption').val();
	console.log(selectVal);


  	console.log("Data retreived");

  	PostCall(URL, selectVal);

}


function PostCall(URL, status){
console.log("Inside Post Call. URL : " + URL + " Status Response : " + status);

	var settings = {
  "async": true,
  "crossDomain": true,
  "url": URL,
  "method": "POST",
  "headers": {
    "authorization": "Basic a2VybWl0Omtlcm1pdA==",
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "9b643de2-003d-1387-b404-fbb1aa45e9f7"
  },
  "processData": false,
  "data": "{ \"action\":\"complete\",\"variables\" :[{\"name\" : \"status\",\"value\" : \"" + status+ "\"}]}"
}

$.ajax(settings).done(function (response) {
  console.log(response);
});
}


$(document).ready (function(){
	var URL = "http://localhost:8080/identity/users";
	var obj = new Array();
	obj = ajaxFunction(URL, "json");
	console.log( obj);

});

 function ajaxFunction( URL, dataType){
var obj = new Object();
var settings = {
  "async": false,
  "crossDomain": true,
  "url": URL,
  "contentType" : "application/json",
  "dataType" : dataType,
  "data" : {},
  "method": "GET",
  "headers": {
    "Authorization": "Basic " +  btoa('kermit' + ':' + 'kermit'),
    "Access-Control-Allow-Headers" : true,
    "cache-control": "no-cache",
  }
}

		var data = new Array();
		$.ajax(settings).done(function (response) {
		  
		  obj = response;
		  
		  data = obj.data;
		  
		});
		//console.log(data);
		return data;

}


