/**
 * Fichier de rootage
 */
app.config(function($routeProvider, $locationProvider) {
	$routeProvider
//================ Contrats ============================================
	.when("/contrat", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Contrat/listContrat.html",
		controller : "findAllCont"
	})
	.when("/ajouterContrat", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Contrat/ajoutContrat.html",
		controller : "addCont"
	})

	.when("/modifierContrat", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Contrat/updateContrat.html",
		controller : "updateCont"
	})
	.when("/chercherContrat", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Contrat/findContrat.html",
		controller : "getCont"
	})
	.when("/supprimerContrat", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Contrat/deleteContrat.html",
		controller : "deleteCont"
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

