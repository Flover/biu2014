'use strict';

/* Controllers */
var myApp = angular.module('myApp.controllers', []);

myApp.controller('kursyCtrl', function ($scope, $http) {
  $http.get('feed/kurs.json').success(function(data) {
    $scope.kursy = data;
  });

  // $scope.orderProp = 'age';
});

// angular.module('myApp.controllers', [])
// 	.controller('kursyCtrl', ['$scope', '$http', function($scope, $http) {
//   	$http.get('feed/kurs.json').success(function(data) {
//   		$scope.kursy = data;
//   	});
//   }])
