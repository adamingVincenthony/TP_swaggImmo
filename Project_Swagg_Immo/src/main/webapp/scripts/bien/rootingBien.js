/**
 * Fichier de rootage
 */
app.config(function($routeProvider) {
	$routeProvider
//================ Bieniétaires ============================================
	.when("/Bien", {
		templateUrl : "templates/main-content/Bienrietaire/listBien.html",
		controller : "findAllBien"
	})
	.when("/ajouterBien", {
		templateUrl : "templates/main-content/Bienrietaire/ajoutBien.html",
		controller : "addBalCtrl"
	})

	.when("/modifierBien", {
		templateUrl : "templates/main-content/Bienrietaire/updateBien.html",
		controller : "updateBien"
	})
	.when("/chercherBien", {
		templateUrl : "templates/main-content/Bienrietaire/findBien.html",
		controller : "getBien"
	})
	.when("/supprimerBien", {
		templateUrl : "templates/main-content/Bienrietaire/deleteBien.html",
		controller : "deleteBien"
	})
	.otherwise({
		redirectTo : "/accueil"
	})
});

//.when("/accueil", {
//	templateUrl : "index.html",	
//})