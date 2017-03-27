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
			$scope.messageadd = true;
				
			
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
		$scope.propUpdateForm.id = $rootScope.propmodif.id
		propProvider.updateProp($scope.propUpdateForm, function (callback){
				$scope.proprietairex = callback;
				$scope.messageupd = true;
				
			
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour supprimer
 * un propriétaires
 */
.controller("deleteProp",function($rootScope, propProvider, $location, $scope){
	/** développement de la méthode appellée dans la page */
	$scope.delete = function() {
		propProvider.deleteProp($rootScope.propmodif.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.proprietairex = callback;
				$scope.messagedel = true;
				$location.path("/supprimerProp"); /* modifier cet url après la création de la vue */
			}
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour chercher
 * un propriétaire
 */
.controller("getProp", function($scope, $rootScope, $location, propProvider) {

	/** développement de la méthode appellée dans la page */
	$scope.get = function() {
		propProvider.getProp($rootScope.propmodif.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			propProvider.findBiens($rootScope.propmodif.id, function(callback) {
				$scope.biens = callback.data;
			})
				$scope.propretour = true;
				$scope.prop = callback.data;
				$location.path("/chercherProp"); /* modifier cet url après la vue */
			
		})
		
	}
	
})
/**
 * -------------------------------------------------------Fonction pour afficher
 * tous les propriétaires
 */
.controller("findAllProp",function($rootScope, $scope, propProvider, $location) {
			propProvider.findAllProp(function(callback) {
				$scope.proprietaires = callback.data;
			})
		})
		
.controller("getPropUp", function($scope, $rootScope, $location, propProvider) {

	/** développement de la méthode appellée dans la page */
	$scope.getU = function() {
		propProvider.getProp($rootScope.propmodif.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.propforu = true;
				$scope.prop = callback.data;
				$location.path("/modifierProp"); /* modifier cet url après la vue */
			}
		})
		
	}
	
})		
/**
 * -------------------------------------------------------Fonction pour afficher
 * la liste des biens du propriétaire
 */		
.controller("getBienByProp",function($rootScope, $scope, propProvider, $location) {
			
		})		
		
		;










