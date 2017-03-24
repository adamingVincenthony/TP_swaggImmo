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
		montantCaution : "",
		loyerMensuel : "",
		loyerCharge : "",
		typeBail : "",
		ameublement : ""	
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
	
});