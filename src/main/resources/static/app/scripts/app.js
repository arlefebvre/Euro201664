(function(angular) {
//angular.module('team', ['teamServices']);

angular.module("myApp.controllers", []);
angular.module("myApp.services", []);
angular.module("myApp", ["ngResource", "myApp.controllers", "myApp.services"]);
}(angular));