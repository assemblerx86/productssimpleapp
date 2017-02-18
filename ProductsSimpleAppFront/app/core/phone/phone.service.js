angular.
  module('core.phone').
  factory('Phone', ['$resource',
    function($resource) {
      return $resource('//localhost:8080/phones/:phoneId.json', {}, {
        query: { method: 'GET', params: {phoneId: 'all'}, isArray: true }
      });
    }
  ]);