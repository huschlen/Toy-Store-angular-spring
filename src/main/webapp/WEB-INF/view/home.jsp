<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>NaokoInventory</title>
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
	
	
	<div class="container">

	<!--Search by the name of a toy-->
	<!--Filter by the Number in Stock-->
	<div class="col-sm-12 filter-change-form">
		<div class="row filter-change-form-row" ng-if="!addToy && !updateToy">

				<!--<div class="col-sm-12">
					<div class="input-group">
						<span class="input-group-addon" ng-model="searchKeyword">Keyword</span>
						<input
							type="text"
							class="form-control">
					</div>
				</div>-->

				<div class="col-sm-6">
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

				<div class="col-sm-6">
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

		</div>
		<button
			class="btn btn-primary"
			ng-click="addToy = !addToy"
			ng-show="!addToy && !updateToy">Add Toy
		</button>
		<button
			class="btn btn-danger"
			ng-click="addToy = !addToy"
			ng-show="addToy">Close
		</button>
		<div class="add-form" method="POST" ng-if="addToy">
			
			<h3>Add a toy</h3>
			<div class="row add-form-row">
				<div class="col-sm-4">
					<div class="input-group">
						<span class="input-group-addon">Id</span>
						<input
							type="text"
							placeholder="Enter the Id"
							class="form-control"
							ng-model="toyCtrl.toy.tid"
							required="required">
					</div>
				</div>
				<div class="col-sm-8">
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
							type="text"
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
							type="text"
							placeholder="Enter the # in Stock"
							class="form-control"
							ng-model="toyCtrl.toy.stock"
							required="required">
					</div>
				</div>

			</div> <!--End of div class="add-form-row"-->
			<button
				class="btn btn-primary add-button"
				ng-click="toyCtrl.addPerson()"
				ng-show="addToy">Add
			</button>
		</div> <!--End of div class="add-form"-->

		<!--Begin div class="update-form"-->
		<div class="update-form" method="POST" ng-show="updateToy">
			
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
							required="required">
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
								type="text"
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
							type="text"
							placeholder="Number in Stock"
							class="form-control"
							ng-model="toyCtrl.toy.stock"
							required="required">
					</div>
				</div>

			</div> <!--End of div class="update-form-row"-->
			<button
				class="btn btn-primary update-button center-block"
				ng-click="updateToyDetail()"
				ng-show="updateToy">Save
			</button>
			<button
				class="btn btn-danger update-button center-block"
				ng-click="toyCtrl.deleteToy(toyCtrl.toy.tid)"
				ng-show="updateToy">Delete
			</button>
		</div> <!--End of div class="update-form"-->	
	</div> <!--End of div class="filter-change-form"-->
</div> <!--End of dev class="container"-->

<!--Inventory Listings-->
<div class="container">
	<div class="table-bordered toy-list" ng-repeat="toy in toyCtrl.toys"><!-- | ngStockFilter:stockInfo">-->
		<p><strong>Id: </strong>{{toy.tid}}</p>
		<p><strong>Toy Name: </strong>{{toy.name}}</p>
		<p><strong>Category: </strong>{{toy.category}}</p>
		<p><strong>Price: </strong>{{toy.price | currency}}</p>
		<p><strong>Description: </strong>{{toy.description}}</p>
		<p><strong>In Stock: </strong>{{toy.stock}}</p>
		<button
			class="btn btn-xs btn-primary"
			ng-click="toyCtrl.editToy(toy.tid)">Edit
		</button>
	</div>
</div>
	
</body>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/2.3.0/ui-bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-resource.js"></script>
<script src="${pageContext.request.contextPath}/app-resources/js/app.js"></script>
<!--<script src="${pageContext.request.contextPath}/app-resources/js/controllers/ngInventoryFactory.js"></script>-->
<script src="${pageContext.request.contextPath}/app-resources/js/filters/ngStockFilter.js"></script>
<script src="${pageContext.request.contextPath}/app-resources/js/filters/keywordFilter.js"></script>-->
</html>