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

var PlayerController =function ($scope, Player) {
$scope.players = Player.query();
}
PlayerController.$inject = ['$scope', 'Player'];
angular.module("myApp.controllers").controller("PlayerController", PlayerController);

}(angular));