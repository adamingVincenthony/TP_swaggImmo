/** Le module AngularJS */
var app=angular.module("appImmo",['ngRoute']);
app.run(function($rootScope) {
	/** Cet object rootScope sert pour les biens :*/
	$rootScope.bienmodif = {'id': undefined, 'propid':undefined};
	/** Cet object rootScope sert pour les proprio */
	$rootScope.propmodif = {'id':undefined};
});
