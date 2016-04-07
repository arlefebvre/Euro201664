 (function(angular) {
 var TeamController =function TeamCtrl($scope, Team) {
$scope.teams = Team.query();

//$scope.select = function(team) {
//    $scope.editedPhone = phone;
//};
}
TeamController.$inject = ['$scope', 'Team'];
angular.module("myApp.controllers").controller("TeamController", TeamController);
}(angular));