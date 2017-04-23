angular.
  module('phonecatApp').
  config(['$locationProvider' ,'$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/phones', {
          template: '<phone-list></phone-list>'
        }).
        when('/phones/create', {
          template: '<phone-add></phone-add>'
        }).
        when('/phones/:phoneId', {
          template: '<phone-detail></phone-detail>'
        }).

        otherwise('/phones');
    }
  ]);