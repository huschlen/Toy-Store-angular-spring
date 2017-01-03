<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Naoko's Toy Store</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/app-resources/css/style.css">
</head>
<body ng-app="ngInventory" ng-controller="ToyController as toyCtrl">
	<!--Nav Bar-->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Inventory</a>
			</div>
		</div>
	</nav>
	<div class="container col-sd-12 text-right">
		<a href="/angular-spring-1/logout">Logout</a>
	</div>
	
	<div class="container">

	<!--Search by the name of a toy-->
	<!--Filter by the Number in Stock-->
	<div class="col-sm-12 filter-change-form">
		<div class="row filter-change-form-row" ng-if="!addToy && !editToy">
			<div class="col-sm-10">
				<div class="input-group">
					<span class="input-group-addon">Keywords</span>
					<input
						type="text"
						placeholder="Enter keywords"
						ng-model="keywordSearch.text"
						class="form-control">
				</div>
			</div>
			<div class="col-sm-2">
				<div class="input-group">
					<button
						type="button"
						class="btn btn-primary"
						ng-click="toyCtrl.clearKeywordFilter()">Clear Filter
					</button>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="input-group">
					<span class="input-group-addon">Min in Stock</span>
					<select name="minStock" tid="minStock" ng-model="stockInfo.min" class="form-control">
						<option value="0">0</option>
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
					</select>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="input-group">
					<span class="input-group-addon">Max in Stock</span>
					<select name="maxStock" tid="maxStock" ng-model="stockInfo.max" class="form-control">
						<option value="0">0</option>
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
					</select>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="input-group">
					<button
						type="button"
						class="btn btn-primary"
						ng-click="toyCtrl.clearStockFilter()">Clear Filter
					</button>
				</div>
			</div>
		</div>
		<button
			type="button"
			class="btn btn-primary"
			ng-click="addToy = !addToy"
			ng-show="!addToy && !editToy">Add Toy
		</button>
		<button
			type="button"
			class="btn btn-danger"
			ng-click="addToy = !addToy"
			ng-show="addToy">Close
		</button>
		<form name="toyForm" method="POST">
		<div class="add-form" ng-if="addToy  && !editToy">
			<h3>Add a toy</h3>
			<div class="row add-form-row">
				<div id="nter-name" class="col-sm-8">
					<div class="input-group">
						<span class="input-group-addon">Toy Name</span>
						<input
							type="text"
							placeholder="Enter the Toy Name"
							class="form-control"
							ng-model="toyCtrl.toy.name"
							required="required">
					</div>
				</div>					
			</div> <!--End of div class="add-form-row"-->
			<div class="row add-form-row">
				<div class="col-sm-8">
					<div class="input-group">
						<span class="input-group-addon">Category</span>
						<input
							type="text"
							placeholder="Enter the Category"
							class="form-control"
							ng-model="toyCtrl.toy.category"
							required="required">
					</div>
				</div>					
				<div class="col-sm-4">
					<div class="input-group">
						<span class="input-group-addon">Price</span>
						<input
							type="number"
							placeholder="Enter the Price"
							class="form-control"
							ng-model="toyCtrl.toy.price"
							required="required">
					</div>
				</div>			
			</div> <!--End of div class="add-form-row"-->
			<div class="row add-form-row">
				<div class="col-sm-8">
					<div class="input-group">
						<span class="input-group-addon">Description</span>
						<input
							type="text"
							placeholder="Enter the Description"
							class="form-control"
							ng-model="toyCtrl.toy.description"
							required="required">
					</div>
				</div>
				<div class="col-sm-4">
					<div class="input-group">
						<span class="input-group-addon">Number in Stock</span>
						<input
							type="number"
							min="0"
							max="30"
							placeholder="Enter the # in Stock"
							class="form-control"
							ng-model="toyCtrl.toy.stock"
							required="required">
					</div>
				</div>
			</div> <!--End of div class="add-form-row"-->
			<button
				type="submit"
				class="btn btn-primary add-button"
				ng-click="toyCtrl.addToy()"
				ng-show="addToy">Add
			</button>
		</div> <!--End of div class="add-form"-->
		
		<!--Begin div class="update-form"-->
		<div class="update-form" ng-show="editToy">		
			<h3>Update a toy</h3>
			<div class="row update-form-row">
				<div class="col-sm-4">
					<div class="input-group">
						<span class="input-group-addon">Id</span>
						<input
							type="text"
							placeholder="Id"
							class="form-control"
							ng-model="toyCtrl.toy.tid"
							readonly="readonly">
					</div>
				</div>
				<div class="col-sm-8">
					<div class="input-group">
						<span class="input-group-addon">Toy Name</span>
						<input
							type="text"
							placeholder="Toy Name"
							class="form-control"
							ng-model="toyCtrl.toy.name"
							required="required">
					</div>
				</div>		
			</div> <!--End of div class="update-form-row"-->
			<div class="row update-form-row">
				<div class="col-sm-8">
					<div class="input-group">
						<span class="input-group-addon">Category</span>
						<input
							type="text"
							placeholder="Category"
							class="form-control"
							ng-model="toyCtrl.toy.category"
							required="required">
					</div>
				</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">Price</span>
							<input
								type="number"
								placeholder="Price"
								class="form-control"
								ng-model="toyCtrl.toy.price"
								required="required">
					</div>
				</div>
			</div> <!--End of div class="update-form-row"-->
			<div class="row update-form-row">
				<div class="col-sm-8">
					<div class="input-group">
						<span class="input-group-addon">Description</span>
						<input
							type="text"
							placeholder="Description"
							class="form-control"
							ng-model="toyCtrl.toy.description"
							required="required">
					</div>
				</div>
				<div class="col-sm-4">
					<div class="input-group">
						<span class="input-group-addon">Number in Stock</span>
						<input
							type="number"
							min="0"
							max="30"
							placeholder="Number in Stock"
							class="form-control"
							ng-model="toyCtrl.toy.stock"
							required="required">
					</div>
				</div>
			</div> <!--End of div class="update-form-row"-->
			<button
				type="button"
				id="deleteButton"
				class="btn btn-danger update-button"
				ng-click="toyCtrl.deleteToy(toyCtrl.toy.tid)"
				ng-show="editToy">Delete
			</button>
			<button
				type="button"
				id="cancelButton"
				class="btn btn-primary update-button"
				ng-click="toyCtrl.cancelUpdate()"
				ng-show="editToy">Cancel
			</button>
			<button
				type="button"
				id="saveButton"			
				class="btn btn-primary update-button"
				ng-click="toyCtrl.updateToyDetail()"
				ng-show="editToy">Save
			</button>
		</div> <!--End of div class="update-form"-->
		<span ng-if="toyCtrl.flag=='created'" class="msg-success">Toy successfully added.</span>
		<span ng-if="toyCtrl.flag=='updated'" class="msg-success">Toy successfully updated.</span>
		<span ng-if="toyCtrl.flag=='deleted'" class="msg-success">Toy successfully deleted.</span>
		</form>
	</div> <!--End of div class="filter-change-form"-->
</div> <!--End of dev class="container"-->

<!--Inventory Listings-->
<div class="container">
	<form name="toyForm" method="POST">
	<div class="table-bordered toy-list" ng-repeat="toy in toyCtrl.toys | ngStockFilter:stockInfo | ngKeywordFilter:keywordSearch">
		<p><strong>Id: </strong>{{toy.tid}}</p>
		<p><strong>Toy Name: </strong>{{toy.name}}</p>
		<p><strong>Category: </strong>{{toy.category}}</p>
		<p><strong>Price: </strong>{{toy.price | currency}}</p>
		<p><strong>Description: </strong>{{toy.description}}</p>
		<p><strong>In Stock: </strong>{{toy.stock}}</p>
		<input type="button" class="btn btn-xs btn-primary" ng-click="toyCtrl.editToy(toy.tid)" value="Edit"/>
	</div>
	</form>
</div>
	
</body>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/2.3.0/ui-bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-resource.js"></script>
<script src="${pageContext.request.contextPath}/app-resources/js/app.js"></script>
<!--<script src="${pageContext.request.contextPath}/app-resources/js/controllers/ngInventoryController.js"></script>-->
<script src="${pageContext.request.contextPath}/app-resources/js/filters/ngStockFilter.js"></script>
<script src="${pageContext.request.contextPath}/app-resources/js/filters/keywordFilter.js"></script>
</html>