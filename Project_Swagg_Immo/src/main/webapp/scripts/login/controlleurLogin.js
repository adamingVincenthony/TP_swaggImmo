/**
 * Controleur LOGIN
 */
app.controller("login", function($scope, $rootScope, $location, provider) {
	$scope.loginForm = {
		/** on initialise des valeurs nulles */
		username : "",
		password : ""
	}
	/** Développement de la méthode login appelée dans la page */
	$scope.login = function() {
		/** appel de la méthode du provider définie avant */
		providerLogin.loginCtrl($scope.loginForm, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path("/accueil"); 
//				url retour ?
			}
		})
	}
	
	/** Développement de la méthode login appelée dans la page */
	$scope.logout = function() {
		/** appel de la méthode du provider définie avant */
		providerLogin.logout(function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path("/index"); 
//				url retour ?
			}
		})
	}

	
});










