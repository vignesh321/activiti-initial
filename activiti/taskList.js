

$(document).ready (function(){

//var URL = "http://localhost:8080/runtime/tasks/"

	$("#tableBody").detach();

	console.log("in")
	//var URL = "http://localhost:8080/identity/users";
	var URL = "http://localhost:8080/runtime/tasks/";
	var data = new Array();
	data = ajaxFunction(URL, "json");
	console.log( data);
			
				  
			
				  var temp = "<tbody id=\"tableBody\">";
				  originalData = data;
			    for (var i = 0; i < data.length; i++) {

			        //temp = temp + "<tr id='row" + i + " '> <th class='pt-3-half' contenteditable='false' id='customer_name" + i + "'>" + data[i].customer_name +"</th> <th class='pt-3-half' contenteditable='false' id='customer_phone" + i + "'>" + data[i].customer_phone +  "</th> <th class='pt-3-half' contenteditable='false' id='order_id" + i + "'>" + data[i].order_id +  "</th> <th class='pt-3-half' contenteditable='false' id='totalCost" + i + "'>" + data[i].totalCost +  "</th>  <th class='pt-3-half' contenteditable='false' id='delivery" + i + "'>" + data[i].delivered +  "</th> </tr>";
			        temp = temp + "<tr id='row" + i + " '> <th class='pt-3-half' id='customer_name" + i + "'>" + data[i].id +"</th> <th class='pt-3-half' id='customer_phone" + i + "'>" + data[i].assignee +  "</th> <th class='pt-3-half' id='order_id" + i + "'>" + data[i].taskDefinitionKey +  "</th> <th class='pt-3-half' id='totalCost" + i + "'>" + data[i].processInstanceId +  "</th>  <th class='pt-3-half' id='delivery" + i + "'>" + data[i].processDefinitionId +  "  </th>  <th class='pt-3-half' contenteditable='false' id='delivery" + i + "'>" + data[i].createTime +  "  </th> </tr>";
			    }

			    temp = temp + "</tbody>";
			    $('#table').append(temp);

	//document.getElementById("Button"); btn.disabled

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
/*function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    return [year, month, day].join('-');
}*/


/*<div class="input-group date" data-provide="datepicker" id="datepicker"> <input type="text" class="form-control" id="date">  <div class="input-group-addon"> <span class="glyphicon glyphicon-th"></span> </div> </div>*/