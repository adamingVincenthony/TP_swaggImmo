/**
 * Controleur AJS du CRUD client
 */
app.controller("addClient", function($scope, $rootScope, $location, clientProvider) {
	$scope.clientForm = {
		/** on initialise des valeurs nulles */
		numero : "",
		nom : ""
	}
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** appel de la méthode du provider définie avant */
		clientProvider.addClient($scope.clientForm, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path("/client"); /* modifier cet url après la vue */
			}
		})
	}
	
})
/**
 * -------------------------------------------------------Fonction pour update
 * un client
 */
.controller("updateClient", function($scope, $rootScope, clientProvider, $location){
	
	/** initiatisation des champs du formulaire en null + id en undefined */
	$scope.clientUpdateForm = {
			id : undefined,
			numero : "",
			nom : ""
		
	}
	/** développement de la méthode appellée dans la page */
	$scope.update = function() {
		clientProvider.updateClient($scope.clientUpdateForm, function (callback){
			if(callback !=undefined && callback!=""){
				$location.path("/client"); /* modifier cet URL après pour le retour ^^ */
			}
		})
	}
	

	
})
/**
 * -------------------------------------------------------Fonction pour supprimer
 * un client
 */
.controller("deleteClient",function($scope, clientProvider, $location){
	/** initialisation de l'id du client à supprimer en indéfini */
	$scope.id = undefined;
	/** développement de la méthode appellée dans la page */
	$scope.delete = function() {
		clientProvider.deleteClient($scope.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.clients = callback;
				$location.path("/client"); /* modifier cet url après la création de la vue */
			}
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour chercher
 * un client
 */
.controller("getClient", function($scope, $rootScope, $location, clientProvider) {
	/** initialisation de l'id nul */
	$scope.id = undefined;
	/** développement de la méthode appellée dans la page */
	$scope.get = function() {
		clientProvider.getClient($scope.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.clients = callback;
				$location.path("/client"); /* modifier cet url après la vue */
			}
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour afficher
 * tous les clients
 */
.controller("findAllClient",function($rootScope, $scope, clientProvider, $location) {
			clientProvider.findAllClient(function(callback) {
				$scope.clients = callback.data;
			})
		});










