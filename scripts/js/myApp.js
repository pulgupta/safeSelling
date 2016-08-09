//Defining my app
/*
 * We are defining a module to prevent the artifacts defined here
 * to go into the global namespace and interfer with other 
 * artifacts. In this way we can have artifacts with same name
 * but existing in different scope*/

/*
 * Route in the below line injects the external module which is 
 * injected in the user defined module.
 * Once this is done we can use the route module inside our own module.
 * We will also need to import the js file of route in the web page 
 * in which we are using the controller*/
var myApp = angular.module('myApp', ['ngRoute']);

//creating controller
/*This is the controller which we will use inside a <div> where we need to use angular js
 * The '$scope here is used to preserve its meaning in case of minification'*/
myApp.controller('myController', ['$scope', function($scope){
	console.log($scope);
}]);

myApp.controller('getUserName', ['$scope', '$http' , function ($scope, $http) {
    /*http service is used to call rest service
     * We can use other methods as well in calling the service
     * Once the service is call based on the result javascipt will call
     * either the success or the error methods*/
	$http.get('http://localhost:8080/safeSelling/loggedInUser').
        success(function(data) {
            //data will contain the JSON returned by the get service
        	$scope.user = data;
            if($scope.user.userName=="anonymousUser")
            	$scope.showProfile=false;
            else
            	$scope.showProfile=true;
            console.log($scope);
        })
        .error(function() {
        	console.log($scope);
        })
}]);
