// Register `phoneList` component, along with its associated controller and template

  angular.
  module('phoneList').
  component('phoneList', {
    templateUrl: 'phone-list/phone-list.template.html',
    controller: ['Phone',
      function PhoneListController(Phone) {
        var that = this;
        Phone.query().$promise.then(function(phones) {
            that.phones = phones;
        });
        this.orderProp = 'age';
      }
    ]
  });