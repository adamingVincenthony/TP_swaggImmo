/**
 * Provider AJS des services CRUD des biens
 */
app.factory("bienProvider", function($http){
	/**
	 * URL globale pour l'appel des services propriétaires
	 */
	var urlglobal = "http://localhost:8080/Project_Swagg_Immo/rest/bien";
	/**
	 * ------------------------------------------------------------ Fonction
	 * pour ajouter un bien
	 */
	function ajouterTAA (bienForm, callback){
		$http({
			method : 'POST',
			url : urlglobal, 
			data : angular.toJson(bienForm),
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
	/**
	 * -------------------------------------------------------------Retour des
	 * fonctions du provider
	 */
	return {
		ajouterTAA : ajouterTAA
		
	}

})
