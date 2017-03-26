/** Le module AngularJS */
var app=angular.module("appImmo",['ngRoute','ui.bootstrap']);
app.run(function($rootScope) {
	/** Cet object rootScope sert pour les biens :*/
	$rootScope.bienmodif = {'id': undefined, 'propid':undefined};
	
});
