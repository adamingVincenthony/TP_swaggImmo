/**
 * Fichier de rootage
 */
app.config(function($routeProvider) {
	$routeProvider
//================ Bieniétaires ============================================
	.when("/bien", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Bien/listBien.html",
		controller : "findAllBien"
	})
	.when("/ajouterBien", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Bien/ajoutBien.html",
		controller : "addBalCtrl"
	})

	.when("/modifierBien", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Bien/updateBien.html",
		controller : "updateBien"
	})
	.when("/chercherBien", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Bien/findBien.html",
		controller : "getBien"
	})
	.when("/supprimerBien", {
		templateUrl : "Project_Swagg_Immo/templates/main-content/Bien/deleteBien.html",
		controller : "deleteBien"
	})
	.otherwise({
		redirectTo : "/accueil"
	})
});

//.when("/accueil", {
//	templateUrl : "index.html",	
//})