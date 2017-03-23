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
				$location.path("accueil"); /* modifier cet url après la vue */
			}
		})
	}
	
});
//
///**
// * -------------------------------------------------------Fonction pour afficher
// * tous les propriétaires
// */
//app.controller("findAllProp",
//		function($rootScope, $scope, propProvider, $location) {
//			propProvider.findAllProp(function(callback) {
//				$scope.proprietaires = callback.data;
//			})
//		}
///**
// * -------------------------------------------------------Fonction pour update
// * un propriétaire
// */
//.controller("updateProp", function($scope, $rootScope, propProvider, $location){
//	if($rootScope.propUpdateForm.id==undefined){
//	/** initiatisation des champs du formulaire en null + id en undefined */
//	$scope.propUpdateForm = {
//			propId : undefined,
//			propNom : "",
//			propAdresse : "",
//			propTel1 : "",
//			propTel2 : ""
//		}
//	}else{
//		$scope.propUpdateForm.propId = $rootScope.propUpdateForm.propId;
//		$scope.propUpdateForm.propNom = $rootScope.propUpdateForm.propNom;
//		$scope.propUpdateForm.propAdresse = $rootScope.propUpdateForm.propAdresse;
//		$scope.propUpdateForm.propTel1 = $rootScope.propUpdateForm.propTel1;
//		$scope.propUpdateForm.propTel2 = $rootScope.propUpdateForm.propTel2;
//		}
//	/** développement de la méthode appellée dans la page */
//	$scope.update = function() {
//		propProvider.updateProp($scope.propUpdateForm, function (callback){
//			if(callback !=undefined && callback!=""){
//				$location.path("accueil"); /* modifier cet URL après pour le retour ^^ */
//			}
//		})
//	}
//	
//}
///**
// * ---------------------------------------------------- Fonction pour ajouter un
// * propriétaire
// */
//
///**
// * -------------------------------------------------------Fonction pour chercher
// * un propriétaire
// */
//.controler("getProp", function($scope, $rootScope, $location, propProvider) {
//	/** initialisation de l'id nul */
//	$scope.id = undefined;
//	/** développement de la méthode appellée dans la page */
//	$scope.get = function() {
//		propProvider.getProp($scope.id, function(callback) {
//			/** Quand la fonction est terminée, le retour : */
//			if (callback != undefined && callback != "") {
//				$scope.proprietaire = callback;
//				$location.path("accueil"); /* modifier cet url après la vue */
//			}
//		})
//	}
//	
//}
///**
// * -------------------------------------------------------Fonction pour supprimer
// * un propriétaires
// */
//.controller("deleteProp",function($scope, propProvider, $location){
//	/** initialisation de l'id du propriétaire à supprimer en indéfini */
//	$scope.id = undefined;
//	/** développement de la méthode appellée dans la page */
//	$scope.get = function() {
//		propProvider.deleteProp($scope.id, function(callback) {
//			/** Quand la fonction est terminée, le retour : */
//			if (callback != undefined && callback != "") {
//				$scope.proprietaire = callback;
//				$location.path("accueil"); /* modifier cet url après la création de la vue */
//			}
//		})
//	}
//});
//
//
//
//






