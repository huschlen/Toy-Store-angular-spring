angular
	.module('ngInventory')
	.filter('keywordFilter', function() {

		return function(listings, searchKeyword) {

			var filtered = [];


			angular.forEach(listings, function(searchKeyword) {
				if(searchKeyword.lindexOf(isting.name) > -1) {			
					filtered.push(listing);
				}
			});
				return filtered;
		}
	});