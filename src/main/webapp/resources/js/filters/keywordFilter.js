angular
	.module('ngInventory')
	.filter('ngKeywordFilter', function() {
		return function(listings, searchKeyword) {
			var keywordFiltered = [];
			var keyword = new RegExp(searchKeyword, 'i');
			angular.forEach(listings, function(listing) {
				if(keyword.test(listing.name)) {			
					keywordFiltered.push(listing);
				}
			});
			return keywordFiltered;
		}
	});