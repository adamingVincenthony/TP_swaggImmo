/**
* Controleur AJS des biens
*/

app.controller("addTAA",function($scope, $rootScope, $location, bienProvider) {
	$scope.bienForm = {
		/** on initialise des valeurs nulles */
		type : "",
		localisation : "",
		revenuCadastral : undefined,
		surface : "",
		prixAchat : undefined,
	}
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouterTAA = function() {
		/** appel de la méthode du provider définie avant */
		bienProvider.ajouterTAA($scope.bienForm, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path(""); /* modifier cet url après la vue */
			}
		})
	}
	
});