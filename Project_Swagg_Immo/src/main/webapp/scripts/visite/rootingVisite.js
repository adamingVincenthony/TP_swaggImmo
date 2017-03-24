/**
 * Fichier de rootage
 */
app.config(function($routeProvider, $locationProvider) {
	$routeProvider
//================ Visites ============================================
	.when("/visite", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Visite/listVisite.html",
		controller : "findAllVisite"
	})
	.when("/ajouterVisite", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Visite/ajoutVisite.html",
		controller : "addVisite"
	})

	.when("/modifierVisite", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Visite/updateVisite.html",
		controller : "updateVisite"
	})
	.when("/chercherVisite", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Visite/findVisite.html",
		controller : "getVisite"
	})
	.when("/supprimerVisite", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Visite/deleteVisite.html",
		controller : "deleteVisite"
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

