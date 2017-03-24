/**
 * Provider AJS des services CRUD du propriétaire
 */
app.factory("visiteProvider", function($http) {

	/**
	 * URL globale pour l'appel des services visites
	 */
	var urlglobal = "http://localhost:8080/Project_Swagg_Immo/rest/visite"; /* METTRE L'URL QUAND SERVICE OKI */

	/**
	 * ------------------------------------------------------------ Fonction
	 * pour ajouter une visite
	 */
	function addVisite(visiteForm, callback) {
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
	 * chercher une visite
	 */
	function getVisite(idVisite, callback) {
		$http.get(urlglobal +'/getById/'+idVisite) 
														
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
	 * afficher toutes les visites
	 */
	function findAllVisite(callback) {
		$http.get(urlglobal + '/findall/') 
		.then(function successCallback(response) {
			console.log(response.data);
			callback(response);
		}, function errorCallback(response) {
			console.log("erreur : " + response.statusText);
		});
	}
	/**
	 * -----------------------------------------------------------Fonction pour
	 * supprimer une visite
	 */
	function deleteVisite(id, callback){
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
	 * modifier une visite
	 */
	function updateVisite(visiteUpdateForm, callback){
		$http({
			method : 'PUT',
			url : urlglobal, 
			data : angular.toJson(visiteUpdateForm),
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
		addVisite : addVisite,
		getVisite : getVisite,
		findAllVisite : findAllVisite,
		deleteVisite : deleteVisite,
		updateVisite : updateVisite
	}

})