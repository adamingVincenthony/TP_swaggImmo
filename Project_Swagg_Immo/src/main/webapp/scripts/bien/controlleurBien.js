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
				/*
				 * L'objet envoyé contient le propriétaire, son ID sera
				 * directement lié dans la bdd
				 */
				bienProvider.ajouterBAL($scope.bienForm, function(callback) {
					/** Quand la fonction est terminée, le retour : */ 
						$location.path("/ajouterBien"); /*
														 * modifier cet url
														 * après la vue
														 */
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
				/*
				 * L'objet envoyé contient le propriétaire, son ID sera
				 * directement lié dans la bdd
				 */
				bienProvider.ajouterBAV($scope.bienForm, function(callback) {
					$location.path("/ajouterBien"); /*
													 * modifier cet url après la
													 * vue
													 */
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
				/*
				 * L'objet envoyé contient le propriétaire, son ID sera
				 * directement lié dans la bdd
				 */
				bienProvider.ajouterTER($scope.bienForm, function(callback) {
					/** Quand la fonction est terminée, le retour : */
					$location.path("/ajouterBien"); /*
													 * modifier cet url après la
													 * vue
													 */
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
		/**
		 * L'id du bien a delete est récupéré dans le rootScope a cause de la
		 * portée des controleurs
		 */
		bienProvider.deleteBien($rootScope.bienmodif.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$location.path("/supprimerBien"); 
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
				$location.path("/chercherBien"); 
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

/**
 * Le controlleur de la page main update
 */
.controller("updateBien", function($scope, $rootScope, $location, bienProvider) {
	/** développement de la méthode appellée dans la page */
	$scope.chercherM = function() {
		bienProvider.getBien($rootScope.bienmodif.id, function(callback) {
			/** Quand la fonction est terminée, le retour : */
			if (callback != undefined && callback != "") {
				$scope.bienup = callback.data;
				$scope.showform = true;
				$location.path("/modifierBien"); 
			}
		})
		
	}
	
})
.controller("updateTer", function($scope, $rootScope, propProvider, $location, bienProvider){
	
	/** initiatisation des champs du formulaire en null + id en undefined */
	$scope.bienupdate = {
			id : undefined,
			dateDispo : "",
			statut : "",
			prixAchat : ""
			
	}
	/** développement de la méthode appellée dans la page */
	$scope.updateTer = function() {
		/** recuperation du propriétaire : */
		$scope.bienupdate.id = $rootScope.bienmodif.id;
		propProvider.getProp($rootScope.bienmodif.propid, function(callback) {
				/* ajouter le propriétairebind au formulaire */
				$scope.bienupdate.proprietaire = callback.data;
				/* appel de la fonction */
				/*
				 * L'objet envoyé contient le propriétaire, son ID sera
				 * directement lié dans la bdd
				 */
				bienProvider.updateTerPro($scope.bienupdate, function(callback) {
					/** Quand la fonction est terminée, le retour : */ 
						$scope.messageupd =true;
						$location.path("/modifierBien"); 						 
									
				})				
			
		})
	
		
	}
	
})
.controller("updateBav", function($scope, $rootScope, propProvider, $location, bienProvider){
	
	/** initiatisation des champs du formulaire en null + id en undefined */
	$scope.bienupdate = {
			id : undefined,
			dateDispo : "",
			statut : "",
			prixAchat : "",
			etatBien :""
	}
	/** développement de la méthode appellée dans la page */
	$scope.updateBav = function() {
		/** recuperation du propriétaire : */
		$scope.bienupdate.id = $rootScope.bienmodif.id;
		propProvider.getProp($rootScope.bienmodif.propid, function(callback) {
				/* ajouter le propriétairebind au formulaire */
				$scope.bienupdate.proprietaire = callback.data;
				/* appel de la fonction */
				/*
				 * L'objet envoyé contient le propriétaire, son ID sera
				 * directement lié dans la bdd
				 */
				bienProvider.updateBavPro($scope.bienupdate, function(callback) {
					/** Quand la fonction est terminée, le retour : */ 
						$scope.messageupd =true;
						$location.path("/modifierBien"); 						 
									
				})				
			
		})
	
		
	}
	
})
.controller("updateBal", function($scope, $rootScope, propProvider, $location, bienProvider){
	
	/** initiatisation des champs du formulaire en null + id en undefined */
	$scope.bienupdate = {
			id : undefined,
			dateDispo : "",
			statut : "",
			montantCaution : "",
			loyerMensuel : "",
			loyerCharge :"",
			typeBail : "",
			ameublement :""
	}
	/** développement de la méthode appellée dans la page */
	$scope.updateBal = function() {
		/** recuperation du propriétaire : */
		$scope.bienupdate.id = $rootScope.bienmodif.id;
		propProvider.getProp($rootScope.bienmodif.propid, function(callback) {
				/* ajouter le propriétairebind au formulaire */
				$scope.bienupdate.proprietaire = callback.data;
				/* appel de la fonction */
				/*
				 * L'objet envoyé contient le propriétaire, son ID sera
				 * directement lié dans la bdd
				 */
				bienProvider.updateBalPro($scope.bienupdate, function(callback) {
					/** Quand la fonction est terminée, le retour : */ 
						$scope.messageupd =true;
						$location.path("/modifierBien"); 						 
									
				})				
			
		})
	
		
	}
	
})
;

