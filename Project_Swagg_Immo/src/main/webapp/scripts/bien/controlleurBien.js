/**
* Controleur AJS des biens
*/
app.controller("addBalCtrl",function($scope, $rootScope, $location, bienProvider) {
	$scope.bienForm = {
		/** on initialise des valeurs nulles */
		type : "",
		localisation : "",
		revenuCadastral : undefined,
		surface : "",
		montantCaution : undefined,
		loyerMensuel : undefined,
		loyerCharge : undefined,
		typeBail : "",
		ameublement : "",
		dateDispo : undefined
	}
	
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** appel de la méthode du provider définie avant */
		bienProvider.ajouterBAL($scope.bienForm, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path(""); /* modifier cet url après la vue */
			}
		})
	}
	
})
/**
 * Controlleur pour ajouter un bien à vendre
 */
.controller("addBavCtrl",function($scope, $rootScope, $location, bienProvider) {
	$scope.bienForm = {
		/** on initialise des valeurs nulles */
		type : "",
		localisation : "",
		revenuCadastral : undefined,
		surface : "",
		dateDispo : undefined,
		etatBien: "",
		prixAchat : undefined
	}
	
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** appel de la méthode du provider définie avant */
		bienProvider.ajouterBAV($scope.bienForm, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path(""); /* modifier cet url après la vue */
			}
		})
	}
	
})
/**
 * Controller pour ajouter un terrain à vendre
 */
.controller("addTerCtrl",function($scope, $rootScope, $location, bienProvider) {
	$scope.bienForm = {
		/** on initialise des valeurs nulles */
		localisation : "",
		revenuCadastral : undefined,
		surface : "",
		dateDispo : undefined,
		prixAchat : undefined
	}
	
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** appel de la méthode du provider définie avant */
		bienProvider.ajouterTER($scope.bienForm, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path(""); /* modifier cet url après la vue */
			}
		})
	}
	
})
/**
 * Controller pour supprimer un bien
 */
.controller("deleteBien",function($scope, bienProvider, $location){
	/** initialisation de l'id du propriétaire à supprimer en indéfini */
	$scope.id = undefined;
	/** développement de la méthode appellée dans la page */
	$scope.deleteBien = function() {
		bienProvider.deleteBien($scope.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.proprietaire = callback;
				$location.path("/prop"); /* modifier cet url après la création de la vue */
			}
		})
		
	}
	
})
/**
 * Controller pour récupuérer un bien
 */
.controller("getBien", function($scope, $rootScope, $location, bienProvider) {
	/** initialisation de l'id nul */
	$scope.id = undefined;
	/** développement de la méthode appellée dans la page */
	$scope.getDatBien = function() {
		bienProvider.getBien($scope.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.proprietaire = callback;
				$location.path("/prop"); /* modifier cet url après la vue */
			}
		})
		
	}
	
})
/**
 * Controller pour afficher tous les biens
 */
.controller("findAllBien",function($rootScope, $scope, bienProvider, $location) {
			bienProvider.findAllBien(function(callback) {
				$scope.biens = callback.data;
			})
		})

;