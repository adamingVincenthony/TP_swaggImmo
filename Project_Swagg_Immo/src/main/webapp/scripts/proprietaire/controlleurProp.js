/**
 * Controleur AJS du CRUD propriétaire
 */
app
/** ---------------------------------------------------- Fonction pour ajouter un propriétaire */
	.controller("addProp", function($scope, $rootScope,$location, propProvider) {
	$scope.propForm = {
	/** on initialise des valeurs nulles */
		propNom : "",
		propAdresse : "",
		propTel1 : "",
		propTel2 : ""
	};
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** appel de la méthode du provider définie avant */
		propProvider.addProp($scope.propForm, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if(callback !=undefined && callback!=""){
				$location.path("accueil"); /* modifier cet url après la vue */
			}
		})
	}	
}
/** -------------------------------------------------------Fonction pour chercher un propriétaire */
	.controler("getProp", function($scope, $rootScope, $location, propProvider){
		/** initialisation de l'id nul */
		$scope.id = undefined;
		/** développement de la méthode appellée dans la page */
		$scope.get = function (){
			propProvider.getProp($scope.id, function(callback){
				/** Quand la fonction est terminée, le retour : */
			if(callback !=undefined && callback!=""){
				$scope.proprietaire = callback;
				$location.path("accueil"); /* modifier cet url après la vue */
			}
			})
		}	
	}
	
	
	
	
	
	
	);