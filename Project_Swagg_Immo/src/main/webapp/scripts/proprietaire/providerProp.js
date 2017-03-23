/**
 * Provider AJS des services CRUD du propriétaire
 */
app.factory("propProvider", function($http) {

	/**
	 * URL globale pour l'appel des services propriétaires
	 */
	var urlglobal = "http://localhost:8080/Project_Swagg_Immo/rest/proprietaire"; /* METTRE L'URL QUAND SERVICE OKI */

	/**
	 * ------------------------------------------------------------ Fonction
	 * pour ajouter un propriétaire
	 */
	function addProp(propForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal + '/add', /* VERIFIER L'URL AVEC REST */
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
		$http.get(urlglobal + '/proprietaire/' + idProp) /*
															 * VERIFIER L'URL
															 * AVEC REST
															 */
		.success(function(response) {
			console.log(response);
			callback(response);
		}).error(function(response) {
			console.log(response.statusText);
		})
	}
	/**
	 * -----------------------------------------------------------Fonction pour
	 * afficher tous les propriétaires
	 */
	function findAllProp(callback) {
		$http.get(urlglobal + '/proprietaires/') /* VERIFIER L'URL AVEC REST */
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
			url : urlglobal + '/delprop/'+id, /* VERIFIER L'URL AVEC REST */
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
			url : urlglobal + '/proprietaire', /* VERIFIER L'URL AVEC REST */
			data : angular.toJson(paysUpdate),
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