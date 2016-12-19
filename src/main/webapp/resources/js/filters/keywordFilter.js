angular
	.module('ngInventory')
	.filter('ngKeywordFilter', function() {
		return function(listings, keywordSearch) {
			console.log("keyword: "+keywordSearch.text);
			var keywordFiltered = [];
			var searchFor = keywordSearch.text;
			//console.log("keyword: "+searchFor);
			var keyword = new RegExp(searchFor, 'i');
			angular.forEach(listings, function(listing) {
				if(keyword.test(listing.name) || keyword.test(listing.category) || keyword.test(listing.description)) {			
					keywordFiltered.push(listing);
				}
			});
			return keywordFiltered;
		}
	});