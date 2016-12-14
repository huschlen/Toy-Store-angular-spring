angular.
	module('ngInventory').
	factory('ngInventoryFactory',function($http) {
		function getToys() {
			return $http.get('data/data.json');
		}

		return {getToys:getToys}
});