// Register editorBar component, along with its associated controller and template
angular.
  module('editorBar').
  component('editorBar', {
    templateUrl: 'phones/editor-bar/editor-bar.template.html',
    controller: ['$routeParams', 'Phone',
      function EditorBarController($routeParams, Phone) {

      }
    ]
  });