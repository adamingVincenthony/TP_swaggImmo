/**
* Provider AJS des services CRUD du propriétaire
*/
app.factory("propProvider", function($http) {
	
	/**
	 * URL globale pour l'appel des services propriétaires
	 */
	var urlglobal = ""; /* METTRE L'URL QUAND SERVICE OKI */
	
	/**
	 * Fonction pour ajouter un propriétaire
	 */
	function addProp(propForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal + '/ajouter',
			data : angular.toJson(propForm),
			headers : {
				'Content-Type' : 'application/json'
			}

		}).success(function(response) {
			console.log(response);
			callback(response);

		}).error(function(response) {
			console.log('Erreur : ' + response.statusText);

		})

	}
/*Retour des fonctions du provider*/
	return {
		addProp : addProp,
	}

})