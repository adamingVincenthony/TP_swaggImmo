/**
 * Controleur AJS du CRUD propriétaire
 */
app.controller("proprietaireController", function($scope, $rootScope, propProvider) {
})
/* Fonction pour ajouter un propriétaire */
	.controller("addProp", function($scope, $rootScope,$location) {
	$scope.propForm = {
	/* on initialise des valeurs nulles */
		propNom : "",
		propAdresse : "",
		propTel1 : "",
		propTel2 : ""
	};
	/* Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/* appel de la méthode du provider définie avant */
		propProvider.addProp($scope.propForm, function(callback) {
			/* Quand la fonction est terminée, le retour : */
			if(callback !=undefined && callback!=""){
				$location.path("accueil"); /* modifier cet url après la vue */
			}
		})
	}	
});