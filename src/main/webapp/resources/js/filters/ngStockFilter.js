angular
	.module('ngInventory')
	.filter('ngStockFilter', function() {
		return function(listings, stockInfo) {
			var filtered = [];
			var min = stockInfo.min;
			var max = stockInfo.max;
			angular.forEach(listings, function(listing) {
				if(listing.stock >= min && listing.stock <= max) {		
					filtered.push(listing);
				}
			});
			return filtered;
		}
	});