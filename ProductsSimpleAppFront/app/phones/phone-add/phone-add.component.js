// Register phoneAdd component, along with its associated controller and template
angular.
  module('phoneAdd').
  component('phoneAdd', {
    templateUrl: 'phones/phone-add/phone-add.template.html',
    controller: ['$routeParams', 'Phone', '$scope',
      function PhoneAddController($routeParams, Phone, $scope) {
        $scope.addSubmit = function() {
            var newPhone = new Phone();
            newPhone.name = $scope.phone.name;
            newPhone.snippet = $scope.phone.snippet;
            newPhone.$save(function(phone, putResponseHeaders) {
                $scope.phone = phone;
            });
        };
      }
    ]
  });
