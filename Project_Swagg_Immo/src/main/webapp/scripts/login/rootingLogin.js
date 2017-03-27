/**
 * Fichier de rootage
 */
app.config(function($routeProvider, $locationProvider) {
	$routeProvider
//================ Login ============================================
	.when("/index", {
		templateUrl : "Project_Swagg_Immo/WEB-INF/index.html",
		controller : "login"
	})
	//supprimer les # dans les url avec le mode html 5
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
		});
});

