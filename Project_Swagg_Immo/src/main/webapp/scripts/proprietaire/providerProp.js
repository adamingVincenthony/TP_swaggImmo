/**
 * Provider AJS des services CRUD du propriétaire
 */
app.factory("propProvider", function($http) {

	/**
	 * URL globale pour l'appel des services propriétaires
	 */
	var urlglobal = "http://localhost:8080/Project_Swagg_Immo/rest/bien"; /* METTRE L'URL QUAND SERVICE OKI */

	/**
	 * ------------------------------------------------------------ Fonction
	 * pour ajouter un propriétaire
	 */
	function addProp(propForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal, 
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
	/**
	 * -----------------------------------------------------------Fonction pour
	 * chercher un propriétaire
	 */
	function getProp(idProp, callback) {
		$http.get(urlglobal +'/get/'+idProp) 
														
		.then(function successCallback(response) {
			console.log(response.data);
			console.log("successLook");
			callback(response);
		}, function errorCallback(response) {
			console.log("erreur : " + response.statusText);
		});
	
}
	/**
	 * -----------------------------------------------------------Fonction pour
	 * afficher tous les propriétaires
	 */
	function findAllProp(callback) {
		$http.get(urlglobal + '/liste/') 
		.then(function successCallback(response) {
			console.log(response.data);
			callback(response);
		}, function errorCallback(response) {
			console.log("erreur : " + response.statusText);
		});
	}
	/**
	 * -----------------------------------------------------------Fonction pour
	 * supprimer un propriétaires
	 */
	function deleteProp(id, callback){
		$http({
			method : 'DELETE',
			url : urlglobal +'/'+id, /*Encoder ça en formulaire ?  */
			})
			.then(function successCallback(response) {
				console.log(response.data);
				console.log("successDelete");
				callback(response);
			}, function errorCallback(response) {
				console.log("erreur : " + response.statusText);
			});
		
	}
	/**
	 * -----------------------------------------------------------Fonction pour
	 * modifier un propriétaire
	 */
	function updateProp(propUpdateForm, callback){
		$http({
			method : 'PUT',
			url : urlglobal, 
			data : angular.toJson(propUpdateForm),
			headers : {
				'Content-Type' : 'application/json'
			}

		})
		.success(function(response) {
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
		addProp : addProp,
		getProp : getProp,
		findAllProp : findAllProp,
		deleteProp : deleteProp,
		updateProp : updateProp
	}

})