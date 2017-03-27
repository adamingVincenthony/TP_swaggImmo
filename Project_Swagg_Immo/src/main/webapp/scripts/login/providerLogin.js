/**
 * Provider AJS du login
 */
app.factory("propProvider", function($http) {

	/**
	 * URL globale pour l'appel du login
	 */
//	var urlglobal = "http://localhost:8080/Project_Swagg_Immo/rest/login";   ???

	/**
	 * ------------------------------------------------------------ Fonction
	 * pour authentification
	 */
	function LoginCtrl($scope, $routeParams, $http, $location) {
		
		$scope.login = function(){
			var data = "j_username="+$scope.username+"&j_password="+$scope.password+"&submit=Login";
			$http.post('j_spring_security_check', data, {
				  headers: {
				    'Content-Type': 'application/x-www-form-urlencoded',
				  }
			}).
		    success(function(data, status, headers, config) {
		    	console.info("You're now logged in, welcome "+$scope.username);
	/*	    	jQuery('#userLogin').hide();
				jQuery('#userInfo').show();*/
		    }).
		    error(function(data, status, headers, config){
		    	console.warn('This is a wrong username or/and a wrong password. Try again');
	/*	    	jQuery('#loginAlert').html("Wrong username or password !");
		    	jQuery('#loginAlert').show();
		    	setTimeout(function(){jQuery('#loginAlert').hide();},4000);*/
		    });
		};
		
		$scope.logout = function(){
			$http.get('j_spring_security_logout')
			.success(function(data, status, headers, config){
				console.info('logged out');
	/*			jQuery('#userLogin').show();
				jQuery('#userInfo').hide();*/
			});
		};
	}

})