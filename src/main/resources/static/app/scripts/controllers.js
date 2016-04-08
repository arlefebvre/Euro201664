 (function(angular) {
 //var TeamController =function ($scope) {
 var TeamController =function ($scope, Team) {
 //console.log(Team.query());
$scope.teams = Team.query();
//$scope.teams = [{ "name" : "France" }, { "name" : "Brazil" }];

//$scope.select = function(team) {
//    $scope.editedPhone = phone;
//};
}
//TeamController.$inject = ['$scope'];
TeamController.$inject = ['$scope', 'Team'];
angular.module("myApp.controllers").controller("TeamController", TeamController);
}(angular));