/**
 * Provider AJS des services CRUD du contrat
 */
app.factory("contratProvider", function($http) {

	/**
	 * URL globale pour l'appel des services propriétaires
	 */
	var urlglobal = "http://localhost:8080/Project_Swagg_Immo/rest/contrat"; /* METTRE L'URL QUAND SERVICE OKI */

	/**
	 * ------------------------------------------------------------ Fonction
	 * pour ajouter un contrat
	 */
	function addCont(contratForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal, 
			data : angular.toJson(contratForm),
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
	 * chercher un contrat
	 */
	function getCont(idCont, callback) {
		$http.get(urlglobal +'/getById/'+idCont) 
														
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
	 * afficher tous les contrats
	 */
	function findAllCont(callback) {
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
	 * supprimer un contrat
	 */
	function deleteCont(id, callback){
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
	 * modifier un contrat
	 */
	function updateCont(contratUpdateForm, callback){
		$http({
			method : 'PUT',
			url : urlglobal, 
			data : angular.toJson(contratUpdateForm),
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
		addCont : addCont,
		getCont : getCont,
		findAllCont : findAllCont,
		deleteCont : deleteCont,
		updateCont : updateCont
	}

})