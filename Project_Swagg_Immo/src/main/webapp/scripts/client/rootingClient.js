/**
 * Fichier de rootage
 */
app.config(function($routeProvider, $locationProvider) {
	$routeProvider
//================ Clients ============================================
	.when("/client", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Client/listClient.html",
		controller : "findAllClient"
	})
	.when("/ajouterClient", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Client/ajoutClient.html",
		controller : "addClient"
	})

	.when("/modifierClient", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Client/updateClient.html",
		controller : "updateClient"
	})
	.when("/chercherClient", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Client/findClient.html",
		controller : "getClient"
	})
	.when("/supprimerClient", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Client/deleteClient.html",
		controller : "deleteClient"
	})
	.otherwise({
		redirectTo : "/accueil"
	})
	//supprimer les # dans les url avec le mode html 5
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
		});
});

