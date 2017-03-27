/**
* Controleur AJS des biens
*/
app.controller("addBalCtrl",function($scope, $rootScope, $location, bienProvider, propProvider) {
	$scope.bienForm = {
		/** on initialise des valeurs nulles */
		type : "",
		localisation : "",
		revenuCadastral : undefined,
		surface : "",
		montantCaution : undefined,
		loyerMensuel : undefined,
		loyerCharge : undefined,
		typeBail : "",
		ameublement : "",
		dateDispo : undefined
	}
	
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** recuperation du propriétaire : */
		propProvider.getProp($rootScope.bienmodif.propid, function(callback) {
				/* ajouter le propriétairebind au formulaire */
				$scope.bienForm.proprietaire = callback.data;
				/* appel de la fonction */
				/* L'objet envoyé contient le propriétaire, son ID sera directement lié dans la bdd */
				bienProvider.ajouterBAL($scope.bienForm, function(callback) {
					/** Quand la fonction est terminée, le retour : */ 
						$location.path("/ajouterBien"); /* modifier cet url après la vue */
						$scope.messageadd =true;			
				})				
			
		})
	
		
	}
	
})
/**
 * Controlleur pour ajouter un bien à vendre
 */
.controller("addBavCtrl",function($scope, $rootScope, $location, bienProvider, propProvider) {
	$scope.bienForm = {
		/** on initialise des valeurs nulles */
		type : "",
		localisation : "",
		revenuCadastral : undefined,
		surface : "",
		dateDispo : undefined,
		etatBien: "",
		prixAchat : undefined
	}
	
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** recuperation du propriétaire : */
		propProvider.getProp($rootScope.bienmodif.propid, function(callback) {
				/* ajouter le propriétairebind au formulaire */
				$scope.bienForm.proprietaire = callback.data;
				/* appel de la fonction */
				/* L'objet envoyé contient le propriétaire, son ID sera directement lié dans la bdd */
				bienProvider.ajouterBAV($scope.bienForm, function(callback) {
					$location.path("/ajouterBien"); /* modifier cet url après la vue */
					$scope.messageadd =true;	
				})				
			
		})
	
		
	}
	
})
/**
 * Controller pour ajouter un terrain à vendre
 */
.controller("addTerCtrl",function($scope, $rootScope, $location, bienProvider, propProvider) {
	$scope.bienForm = {
		/** on initialise des valeurs nulles */
		localisation : "",
		revenuCadastral : undefined,
		surface : "",
		dateDispo : undefined,
		prixAchat : undefined
	}
	
	/** Développement de la méthode ajouter appellée dans la page */
	$scope.ajouter = function() {
		/** recuperation du propriétaire : */
		propProvider.getProp($rootScope.bienmodif.propid, function(callback) {
				/* ajouter le propriétairebind au formulaire */
				$scope.bienForm.proprietaire = callback.data;
				/* appel de la fonction */
				/* L'objet envoyé contient le propriétaire, son ID sera directement lié dans la bdd */
				bienProvider.ajouterTER($scope.bienForm, function(callback) {
					/** Quand la fonction est terminée, le retour : */
					$location.path("/ajouterBien"); /* modifier cet url après la vue */
					$scope.messageadd =true;	
				})				
			
		})
	
		
	}
	
})
/**
 * Controller pour supprimer un bien
 */
.controller("deleteBien",function($scope, bienProvider, $location, $rootScope){
	/** développement de la méthode appellée dans la page */
	$scope.deleteBien = function() {
		/** L'id du bien a delete est récupéré dans le rootScope a cause de la portée des controleurs */
		bienProvider.deleteBien($rootScope.bienmodif.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path("/supprimerBien"); /* modifier cet url après la création de la vue */
				$scope.messagedel =true;
			}
		})
		
	}
	
})
/**
 * Controller pour récupuérer un bien
 */
.controller("getBien", function($scope, $rootScope, $location, bienProvider) {
	/** développement de la méthode appellée dans la page */
	$scope.getDatBien = function() {
		bienProvider.getBien($rootScope.bienmodif.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.b = callback.data;
				$scope.bienretour = true;
				$location.path("/chercherBien"); /* modifier cet url après la vue */
			}
		})
		
	}
	
})
/**
 * Controller pour afficher tous les biens
 */
.controller("findAllBien",function($rootScope, $scope, bienProvider, $location) {
			bienProvider.findAllBien(function(callback) {
				$scope.biens = callback.data;
			})
		})


.controller("updateBien",function($rootScope, $scope, bienProvider, $location) {
			bienProvider.findAllBien(function(callback) {
				$scope.bienfezfezfs = callback.data;
			})
		});


