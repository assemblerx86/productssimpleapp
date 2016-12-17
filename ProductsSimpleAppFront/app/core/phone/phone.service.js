
angular.
  module('core.phone').
  factory('Phone', ['$resource',
    function($resource) {
      return $resource('//localhost:8080/phones/:itemId.json', {}, {
        query: {
          method: 'GET',
          params: {itemId: 'all'},
          isArray: true
        }
      });
    }
  ]);