/**
 * Fichier de rootage
 */
app.config(function($routeProvider, $locationProvider) {
	$routeProvider
//================ Propiétaires ============================================
	.when("/prop", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Proprietaire/listProp.html",
		controller : "findAllProp"
	})
	.when("/ajouterProp", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Proprietaire/ajoutProp.html",
		controller : "addProp"
	})

	.when("/modifierProp", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Proprietaire/updateProp.html",
		controller : "updateProp"
	})
	.when("/chercherProp", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Proprietaire/findProp.html",
		controller : "getProp"
	})
	.when("/supprimerProp", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Proprietaire/deleteProp.html",
		controller : "deleteProp"
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

