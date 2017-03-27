/**
 * Provider AJS des services CRUD du client
 */
app.factory("clientProvider", function($http) {

	/**
	 * URL globale pour l'appel des services client
	 */
	var urlglobal = "http://localhost:8080/Project_Swagg_Immo/rest/client"; /* METTRE L'URL QUAND SERVICE OKI */

	/**
	 * ------------------------------------------------------------ Fonction
	 * pour ajouter un client
	 */
	function addClient(clientForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal, 
			data : angular.toJson(clientForm),
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
	 * chercher un client
	 */
	function getClient(idClient, callback) {
		$http.get(urlglobal +'/get/'+idClient) 
														
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
	 * afficher tous les clients
	 */
	function findAllClient(callback) {
		$http.get(urlglobal + '/findAll/') 
		.then(function successCallback(response) {
			console.log(response.data);
			callback(response);
		}, function errorCallback(response) {
			console.log("erreur : " + response.statusText);
		});
	}
	/**
	 * -----------------------------------------------------------Fonction pour
	 * supprimer un client
	 */
	function deleteClient(id, callback){
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
	 * modifier un client
	 */
	function updateClient(clientUpdateForm, callback){
		$http({
			method : 'PUT',
			url : urlglobal, 
			data : angular.toJson(clientUpdateForm),
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
	 * fonctions du client
	 */
	return {
		addClient : addClient,
		getClient : getClient,
		findAllClient : findAllClient,
		deleteClient : deleteClient,
		updateClient : updateClient
	}

})