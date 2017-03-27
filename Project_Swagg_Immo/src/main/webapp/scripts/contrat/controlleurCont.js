/**
 * Controleur AJS du CRUD Contriétaire
 */
app.controller("addCont", function($scope, $rootScope, $location, contratProvider) {
	$scope.contratForm = {
		/** on initialise des valeurs nulles */
		prix : "",
		date : "",
		reference : ""
		
	}
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** appel de la méthode du provider définie avant */
		contratProvider.addCont($scope.contratForm, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path("/contrat"); /* modifier cet url après la vue */
			}
		})
	}
	
})
/**
 * -------------------------------------------------------Fonction pour update
 * un Contriétaire
 */
.controller("updateCont", function($scope, $rootScope, contratProvider, $location){
	
	/** initiatisation des champs du formulaire en null + id en undefined */
	$scope.contratUpdateForm = {
			id : undefined,
			prix : "",
			date : "",
			reference : ""
		
	}
	/** développement de la méthode appellée dans la page */
	$scope.update = function() {
		contratProvider.updateCont($scope.contratUpdateForm, function (callback){
			if(callback !=undefined && callback!=""){
				$location.path("/contrat"); /* modifier cet URL après pour le retour ^^ */
			}
		})
	}
	

	
})
/**
 * -------------------------------------------------------Fonction pour supprimer
 * un Contriétaires
 */
.controller("deleteCont",function($scope, contratProvider, $location){
	/** initialisation de l'id du Contriétaire à supprimer en indéfini */
	$scope.id = undefined;
	/** développement de la méthode appellée dans la page */
	$scope.delete = function() {
		contratProvider.deleteCont($scope.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.contrat = callback;
				$location.path("/contrat"); /* modifier cet url après la création de la vue */
			}
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour chercher
 * un Contrat
 */
.controller("getCont", function($scope, $rootScope, $location, contratProvider) {
	/** initialisation de l'id nul */
	$scope.id = undefined;
	/** développement de la méthode appellée dans la page */
	$scope.get = function() {
		contratProvider.getCont($scope.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.contrat = callback;
				$location.path("/contrat"); /* modifier cet url après la vue */
			}
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour afficher
 * tous les Contriétaires
 */
.controller("findAllCont",function($rootScope, $scope, contratProvider, $location) {
	contratProvider.findAllCont(function(callback) {
				$scope.contrats = callback.data;
			})
		});










