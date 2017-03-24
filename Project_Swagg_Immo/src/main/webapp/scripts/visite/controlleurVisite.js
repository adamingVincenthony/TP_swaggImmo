/**
 * Controleur AJS du CRUD visite
 */
app.controller("addVisite", function($scope, $rootScope, $location, visiteProvider) {
	$scope.visiteForm = {
		/** on initialise des valeurs nulles */
		date : ""
			//penser au attribution
	}
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** appel de la méthode du provider définie avant */
		visiteProvider.addVisite($scope.visiteForm, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path("/visite"); /* modifier cet url après la vue */
			}
		})
	}
	
})
/**
 * -------------------------------------------------------Fonction pour update
 * une visite
 */
.controller("updateVisite", function($scope, $rootScope, visiteProvider, $location){
	
	/** initiatisation des champs du formulaire en null + id en undefined */
	$scope.visiteUpdateForm = {
			id : undefined,
			date : ""
		//same
	}
	/** développement de la méthode appellée dans la page */
	$scope.update = function() {
		visiteProvider.updateVisite($scope.visiteUpdateForm, function (callback){
			if(callback !=undefined && callback!=""){
				$location.path("/visite"); /* modifier cet URL après pour le retour ^^ */
			}
		})
	}
	

	
})
/**
 * -------------------------------------------------------Fonction pour supprimer
 * une visite
 */
.controller("deleteVisite",function($scope, visiteProvider, $location){
	/** initialisation de l'id du visite à supprimer en indéfini */
	$scope.id = undefined;
	/** développement de la méthode appellée dans la page */
	$scope.delete = function() {
		visiteProvider.deleteVisite($scope.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.visite = callback;
				$location.path("/visite"); /* modifier cet url après la création de la vue */
			}
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour chercher
 * une visite
 */
.controller("getVisite", function($scope, $rootScope, $location, visiteProvider) {
	/** initialisation de l'id nul */
	$scope.id = undefined;
	/** développement de la méthode appellée dans la page */
	$scope.get = function() {
		visiteProvider.getVisite($scope.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.visite = callback;
				$location.path("/visite"); /* modifier cet url après la vue */
			}
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour afficher
 * toutes les visites
 */
.controller("findAllVisite",function($rootScope, $scope, visiteProvider, $location) {
			visiteProvider.findAllVisite(function(callback) {
				$scope.visite = callback.data;
			})
		});










