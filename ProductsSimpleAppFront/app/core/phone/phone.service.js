angular.
  module('core.phone').
  factory('Phone', ['$resource',
    function ($resource) {  
      return $resource('//localhost:8080/phones/:phoneId', {}, {
        query: { method: 'GET', isArray: true },
        save: { method: 'POST', params: {'phoneId': 'create'} }
      });
    }
  ])
  