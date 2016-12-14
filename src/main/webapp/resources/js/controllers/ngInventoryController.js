angular.
	module('ngInventory').
	controller('ngInventoryController',function($scope,ngInventoryFactory) {
	$scope.toys;
	$scope.stockInfo = {
		min: 0,
		max: 1000
	}

	$scope.searchKeyword = {};

	$scope.newToy = {};
	$scope.addNewToy = function(newToy) {
		$scope.toys.push(newToy);
		$scope.newToy = {};
	}

	$scope.editToy = function(toy) {
		$scope.updateToy = true;
		$scope.existingToy = toy;
	}

	$scope.saveUpdatedToy = function() {
		$scope.existingToy = {};
		$scope.updateToy = false;
	}

	$scope.deleteToy = function(deletingToy) {
		var index = $scope.toys.indexOf(deletingToy);
		$scope.toys.splice(index,1);
		$scope.existingToy = {};
		$scope.updateToy = false;
	}

	ngInventoryFactory.getToys().success(function(data) {
		$scope.toys = data;
	}).error(function(error) {
		console.log(error);
	});

});