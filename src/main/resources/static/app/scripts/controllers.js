 (function(angular) {

 var TeamController =function ($scope, Team) {
$scope.teams = Team.query();
}
TeamController.$inject = ['$scope', 'Team'];
angular.module("myApp.controllers").controller("TeamController", TeamController);

 var MatchController =function ($scope, Match) {
$scope.matches = Match.query();
}
MatchController.$inject = ['$scope', 'Match'];
angular.module("myApp.controllers").controller("MatchController", MatchController);

}(angular));