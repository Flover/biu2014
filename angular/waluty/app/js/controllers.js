'use strict';

/* Controllers */
var myApp = angular.module('myApp.controllers', []);

myApp.controller('kursyCtrl', function ($scope, $http) {
  setInterval(function() {
    $http.get('feed/kurs.json').success(function(data) {
      $scope.kursy = data;
      console.log('refresh');
    });
  },1000);
});
