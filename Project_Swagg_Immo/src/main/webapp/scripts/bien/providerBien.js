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
	 * pour ajouter un bien à louer :
	 */
	function ajouterBAL (bienForm, callback){
		$http({
			method : 'POST',
			url : urlglobal+"/bal/", 
			data : angular.toJson(bienForm),
			headers : {
				'Content-Type' : 'application/json'
			}

		}).then(function successCallback(response) {
			callback(response);
		});

	}
	/**
	 * ------------------------------------------------------------ Fonction
	 * pour ajouter un bien à vendre :
	 */
	function ajouterBAV (bienForm, callback){
		$http({
			method : 'POST',
			url : urlglobal+"/bav/", 
			data : angular.toJson(bienForm),
			headers : {
				'Content-Type' : 'application/json'
			}

		}).then(function successCallback(response) {
			callback(response);
		});

	}
	/**
	 * Fonction pour ajouter un terrain à louer
	 */
	function ajouterTER (bienForm, callback){
		$http({
			method : 'POST',
			url : urlglobal+"/ter/", 
			data : angular.toJson(bienForm),
			headers : {
				'Content-Type' : 'application/json'
			}

		}).then(function successCallback(response) {
			callback(response);
		});

	}
	/**
	 * Fonction pour supprimer un bien
	 */	
	function deleteBien(id, callback){
		$http({
			method : 'DELETE',
			url : urlglobal+'/'+id,		
		}).then(function successCallback(response) {
			console.log(response.data);
			console.log("successDelete");
			callback(response);
		}, function errorCallback(response) {
			console.log("erreur : " + response.statusText);
		});
	}
	
	/**
	 * Fonction pour chercher un bien
	 */
	function getBien(idBien, callback) {
		$http.get(urlglobal +'/get/'+idBien) 
														
		.then(function successCallback(response) {
			console.log(response.data);
			console.log("successLook");
			callback(response);
		}, function errorCallback(response) {
			console.log("erreur : " + response.statusText);
		});
	
}
	/**
	 * Fonction pour afficher tous les biens :
	 */
	function findAllBien(callback) {
		$http.get(urlglobal + '/liste/') 
		.then(function successCallback(response) {
			console.log(response.data);
			callback(response);
		}, function errorCallback(response) {
			console.log("erreur : " + response.statusText);
		});
	}
	
	
	/**
	 * Fonction pour update TER
	 */
	function updateTerPro(propUpdateForm, callback) {
		$http({
			method : 'PUT',
			url : urlglobal + '/upter/', 
			data : angular.toJson(propUpdateForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);
		}, function errorCallback(response) {
			console.log("erreur : " + response.statusText);
		});
	}
	/**
	 * Fonction pour update Bav
	 */
	function updateBavPro(propUpdateForm, callback) {
		$http({
			method : 'PUT',
			url : urlglobal + '/upbav/', 
			data : angular.toJson(propUpdateForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);
		}, function errorCallback(response) {
			console.log("erreur : " + response.statusText);
		});
	}
	/**
	 * Fonction pour update Bal
	 */
	function updateBalPro(propUpdateForm, callback) {
		$http({
			method : 'PUT',
			url : urlglobal + '/upbal/', 
			data : angular.toJson(propUpdateForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);
		}, function errorCallback(response) {
			console.log("erreur : " + response.statusText);
		});
	}
	/**
	 * -------------------------------------------------------------Retour des
	 * fonctions du provider
	 */
	return {
		ajouterBAL : ajouterBAL,
		ajouterBAV : ajouterBAV,
		ajouterTER : ajouterTER,
		deleteBien : deleteBien,
		getBien : getBien,
		findAllBien : findAllBien,
		updateTerPro : updateTerPro,
		updateBavPro : updateBavPro,
		updateBalPro : updateBalPro
	}

})
