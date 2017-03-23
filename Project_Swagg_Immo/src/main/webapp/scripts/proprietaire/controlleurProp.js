/**
 * Controleur AJS du CRUD propriétaire
 */
app.controller("addProp", function($scope, $rootScope, $location, propProvider) {
	$scope.propForm = {
		/** on initialise des valeurs nulles */
		nom : "",
		adresse : "",
		numeroPrive : "",
		numeroTravail : ""
	}
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** appel de la méthode du provider définie avant */
		propProvider.addProp($scope.propForm, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path("/testadd.html"); /* modifier cet url après la vue */
			}
		})
	}
	
})
/**
 * -------------------------------------------------------Fonction pour update
 * un propriétaire
 */
.controller("updateProp", function($scope, $rootScope, propProvider, $location){
	
	/** initiatisation des champs du formulaire en null + id en undefined */
	$scope.propUpdateForm = {
			id : undefined,
			nom : "",
			adresse : "",
			numeroPrive : "",
			numeroTravail : ""
		
	}
	/** développement de la méthode appellée dans la page */
	$scope.update = function() {
		propProvider.updateProp($scope.propUpdateForm, function (callback){
			if(callback !=undefined && callback!=""){
				$location.path("/testadd.html"); /* modifier cet URL après pour le retour ^^ */
			}
		})
	}
	

	
})
/**
 * -------------------------------------------------------Fonction pour supprimer
 * un propriétaires
 */
.controller("deleteProp",function($scope, propProvider, $location){
	/** initialisation de l'id du propriétaire à supprimer en indéfini */
	$scope.id = undefined;
	/** développement de la méthode appellée dans la page */
	$scope.delete = function() {
		propProvider.deleteProp($scope.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.proprietaire = callback;
				$location.path("/testadd.html"); /* modifier cet url après la création de la vue */
			}
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour chercher
 * un propriétaire
 */
.controller("getProp", function($scope, $rootScope, $location, propProvider) {
	/** initialisation de l'id nul */
	$scope.id = undefined;
	/** développement de la méthode appellée dans la page */
	$scope.get = function() {
		propProvider.getProp($scope.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.proprietaire = callback;
				$location.path("/testresul.html"); /* modifier cet url après la vue */
			}
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour afficher
 * tous les propriétaires
 */
.controller("findAllProp",
		function($rootScope, $scope, propProvider, $location) {
			propProvider.findAllProp(function(callback) {
				$scope.proprietaires = callback.data;
			})
		}



});










