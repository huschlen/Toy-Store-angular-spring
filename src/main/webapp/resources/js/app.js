var app = angular.module('ngInventory',['ui.bootstrap','ngResource']);

app.factory('Toy', ['$resource', function ($resource) {
	return $resource('http://localhost:8080/angular-spring-1/toys/:toyId', {toyId: '@tid'},
		{
			updateToy: {method: 'PUT'}
		}
    );
}]);

app.controller('ToyController', ['$scope', '$window', 'Toy', function($scope, $window, Toy) {
    var ob = this;
    ob.toys=[];
    ob.toy = new Toy();
    $scope.keywordSearch = {
    	text: ""
    };
    $scope.stockInfo = {
    	min: 0,
        max: 1000
    };
    ob.fetchAllToys = function(){    	
        ob.toys = Toy.query();   
    };
    ob.fetchAllToys();
    ob.clearKeywordFilter = function() {
    	$scope.keywordSearch = {
    		text: ""
    	}
    };
    ob.clearStockFilter = function() {
    	$scope.stockInfo = {
    	    min: 0,
    	    max: 1000
    	}
    };
    ob.addToy = function(){
		console.log('Inside save');
		if($scope.toyForm.$valid && ob.toy.stock >= 0 && ob.toy.stock <=30) {
			ob.toy.$save(function(toy) {
		    console.log(toy); 
		    ob.flag = 'created';
		    $scope.addToy = false;
		    ob.reset();	
		    ob.fetchAllToys();
		    },
    		function(err) {
    			console.log(err.status);
    		    ob.flag='failed';
    		});
        }
    }; 
    ob.editToy = function(id) {
    	$scope.editToy = true;
	    console.log('Inside edit');
        ob.toy = Toy.get({ toyId:id }, function() {
        	ob.flag = 'edit';
        	$window.scrollTo(0, 0);
        });
        
    };    
    ob.updateToyDetail = function() {
    	console.log('Inside update');		
    	if($scope.toyForm.$valid  && ob.toy.stock >= 0 && ob.toy.stock <=30) {
		ob.toy.$updateToy(function(toy) {
        	console.log(toy); 
    		ob.updatedId = toy.tid;
    		ob.reset();
    		ob.flag = 'updated';
    		$scope.editToy = false;
    		ob.fetchAllToys();
           });
	    }
    };	
    ob.deleteToy = function(id){
	    console.log('Inside delete');
	    ob.toy = Toy.delete({ toyId:id }, function() {
    		ob.reset();  
    		ob.flag = 'deleted';
    		$scope.editToy = false;
    		ob.fetchAllToys(); 
	    });
    };		
    ob.reset = function() {
    	ob.toy = new Toy();
        $scope.toyForm.$setPristine();
    };	
    ob.cancelUpdate = function(id) {
    	$scope.editToy = false;
	    ob.toy = new Toy();
	    ob.flag = '';
   	    ob.fetchAllToys();
    };

}]);