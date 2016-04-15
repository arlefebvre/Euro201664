(function(angular) {
//angular.module('teamServices', ['ngResource'])
//.factory('Team', function($resource){
//    return $resource('/teams', {}, {
//        queryAll: {method:'GET', isArray:true}
//    });
//});

var TeamFactory = function($resource) {
    return $resource('/uefa/teams', {}, {
                    'query': {method:'GET', isArray:true}
             });
         //return $resource('/teams/:teamId', {teamId:'@id'});
  };

TeamFactory.$inject = ['$resource'];
angular.module("myApp.services").factory("Team", TeamFactory);


var MatchFactory = function($resource) {
    return $resource('/euro2016/matches', {}, {
                    'query': {method:'GET', isArray:true}
             });
};
MatchFactory.$inject = ['$resource'];
angular.module("myApp.services").factory("Match", MatchFactory);

}(angular));