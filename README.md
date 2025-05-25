Projet TP1 : Tests Unitaires

Ce projet se concentre sur la mise en œuvre et le test d'algorithmes et de services à l'aide de tests unitaires avec JUnit 5. Les exercices couvrent des problèmes de programmation courants (par exemple, Palindrome, Anagramme, Recherche binaire) et incluent des corrections de bogues, l'ajout de gestion d'exceptions et l'amélioration des tests unitaires. Ce README fournit une vue d'ensemble détaillée des corrections, des exceptions ajoutées et des scénarios de test.

Aperçu

Le projet comprend plusieurs exercices (Exo1 à Exo6) qui impliquent la correction d'erreurs logiques dans des algorithmes et la mise en place de tests unitaires robustes. De plus, nous avons renforcé la gestion des erreurs en ajoutant des exceptions personnalisées et amélioré les cas de test pour des classes spécifiques comme UserService et Jeu (un jeu de dés). Ce document répond également à des questions clés sur les stratégies et scénarios de test.

Corrections des Bogues dans les Algorithmes

Les exercices suivants présentaient des erreurs logiques dans leurs implémentations, qui ont été corrigées :





Exo1 : Palindrome





Problème : La boucle utilisait une logique incorrecte pour les incréments/décréments (i-- et j++).



Correction : Modifié en i++ et j-- pour comparer correctement les caractères depuis les deux extrémités de la chaîne.



Exo2 : Anagramme





Problème : La condition de boucle était incorrecte (i <= s1.length()), provoquant une erreur de dépassement.



Correction : Corrigée en i < s1.length() pour rester dans les limites de la chaîne.



Exo3 : Recherche Binaire





Problème : La condition de boucle (low < high) excluait le cas où low est égal à high.



Correction : Modifiée en low <= high pour inclure la vérification du dernier élément possible.



Exo4 : Équation Quadratique





Statut : Aucun problème détecté ; l'implémentation était correcte.



Exo5 : Chiffres Romains





Problème : La condition de boucle (i <= symbols.length) provoquait une erreur de dépassement.



Correction : Corrigée en i < symbols.length pour une itération correcte.



Exo6 : FizzBuzzLine





Problème : La condition pour une entrée invalide (n <= 1) était trop restrictive.



Correction : Modifiée en n < 1 pour permettre n = 1 comme entrée valide.

Exceptions Ajoutées pour la Robustesse

Pour améliorer la gestion des erreurs, nous avons introduit des exceptions personnalisées afin de gérer les cas limites et les entrées invalides. Ces exceptions renforcent la fiabilité du code en traitant explicitement les scénarios d'erreur.

1. UserService





Exception : ServiceException





Objectif : Levée lorsque les données de l'utilisateur sont incomplètes ou invalides.



Cas d'utilisation : Déclenchée lors de l'appel à creerUtilisateur(utilisateur) avec des données incorrectes ou manquantes (par exemple, champs nuls ou vides).

2. Jeu de Dés





Exception : DebitImpossibleException





Objectif : Levée lorsqu'un joueur tente de parier une somme qu'il ne peut pas payer (insolvabilité).



Cas d'utilisation : Se produit lors de l'appel à jouer(joueur, de1, de2) avec une mise invalide.



Exception : JeuFermeException





Objectif : Levée lorsque le jeu est fermé et qu'une action non autorisée est tentée.



Cas d'utilisation : Déclenchée après un gain qui vide les fonds de la banque, empêchant tout jeu supplémentaire.

Corrections et Améliorations des Tests

Les tests unitaires ont été mis à jour pour corriger les problèmes et améliorer leur fiabilité. Voici les corrections pour les classes de test spécifiques :





Exo1 : Calculatrice





Problème : La classe Calculatrice n'avait pas de méthode getResult() (ou getState()), rendant impossible la vérification directe de l'état de l'objet.



Problème : Le test de la méthode additionner utilisait un mock, ce qui empêchait de vérifier l'état réel sans stubbing supplémentaire.



Problème : Le test appelait getResult() sans invoquer la méthode testée.



Correction : Ajout d'une méthode getResult() à Calculatrice et mise à jour des tests pour vérifier l'état réel après l'appel à additionner.



Exo2 : UserService





Correction : Mise à jour des tests pour utiliser les fonctionnalités de JUnit 5, telles que les assertions et les tests paramétrés, pour une meilleure couverture et clarté.



Exo3 : UserServiceScenariosTest





Correction : Amélioration des scénarios de test pour couvrir les cas limites et garantir une validation complète des comportements de UserService.



Exo4 : Jeu





Correction : Ajout de cas de test pour gérer les scénarios où le jeu est fermé ou le joueur est insolvable, assurant une gestion correcte des exceptions.

Tests de la Classe Jeu

La classe Jeu (Jeu de Dés) a été testée de manière approfondie, en se concentrant sur la méthode jouer. Voici les réponses aux questions spécifiques sur les tests de cette classe :

1. Dépendances à Mocker pour Tester jouer

Pour tester la méthode jouer en isolation, les dépendances suivantes doivent être mockées :





Banque : Interagit avec le jeu pour créditer/débiter des fonds et vérifier la solvabilité.



Joueur : Gère la mise du joueur, les débits et les crédits.



De (Dés) : Deux objets dés qui génèrent des lancers aléatoires.



Raison : Ce sont des dépendances externes. Les mocker permet de tester la classe Jeu de manière isolée, en contrôlant précisément leur comportement et leurs valeurs de retour.

2. Scénarios de Test (Classes d'Équivalence) pour jouer

Les scénarios suivants couvrent les différents comportements de la méthode jouer :





Jeu Fermé :





Configuration : Le jeu est fermé avant l'appel à jouer.



Résultat attendu : Lève JeuFermeException.



Joueur Insolvable :





Configuration : Le joueur n'a pas assez de fonds pour la mise.



Résultat attendu : La méthode debiter du joueur lève DebitImpossibleException.



Somme des Dés Différente de 7 :





Configuration : Les dés retournent une somme autre que 7.



Résultat attendu : Le joueur perd sa mise, et la banque conserve les fonds.



Somme des Dés Égale à 7, Banque Solvable :





Configuration : Les dés retournent une somme de 7, et la banque a des fonds suffisants.



Résultat attendu : Le joueur gagne le double de sa mise, et la banque débite ce montant.



Somme des Dés Égale à 7, Banque Insolvable :





Configuration : Les dés retournent une somme de 7, mais la banque ne peut pas payer les gains.



Résultat attendu : La banque paie ce qu'elle peut, devient insolvable, et le jeu se ferme.



Banque Initialement Insolvable :





Configuration : La banque est insolvable dès le départ.



Résultat attendu : Le jeu se ferme immédiatement.

3. Cas de Test le Plus Simple





Scénario : Jeu fermé.



Type : Test d'état.



Description : Vérifie l'état du jeu après l'appel à fermer() en s'assurant que jouer lève JeuFermeException.

4. Tester l'Insolvabilité du Joueur





Objectif : Vérifier que les dés ne sont pas lancés lorsque le joueur est insolvable.



Approche :





Utiliser verify(de1Mock, never()).lancer() et verify(de2Mock, never()).lancer() pour confirmer que les méthodes des dés ne sont pas appelées.



Type : Test d'interaction.



Description : Vérifie qu'aucune interaction n'a lieu avec les dés lorsque la méthode debiter du joueur lève DebitImpossibleException.

Détails des Exercices

Exo1 : UserService





Classes :





UserService : Récupère un objet User par son ID en utilisant UserRepository.



User : Représente un utilisateur avec un ID et un nom.



Interface :





UserRepository : Définit une méthode findUserById utilisée par UserService.



Approche de Test :





Définir un User avec un ID et un nom.



Configurer le mock UserRepository pour retourner l'utilisateur défini.



Appeler UserService.findUserById et stocker le résultat.



Vérifier que le mock a été appelé avec le bon ID et que le résultat correspond à l'utilisateur attendu.

Exo2 : OrderController





Classes :





OrderController : Crée une commande en appelant orderService.createOrder(order).



OrderService : Enregistre une commande en appelant orderDao.saveOrder(order).



Interface :





OrderDao : Retourne un booléen indiquant si la commande a été enregistrée avec succès.



Approche de Test :





Mocker OrderDao pour simuler le comportement d'enregistrement.



Tester OrderController.createOrder pour s'assurer qu'il délègue correctement à OrderService et gère le résultat.

Exo3 : ProductService





Classes :





ProductService : Récupère un Product par son ID en utilisant ProductApiClient.



Product : Représente un produit avec un ID et un nom.



Interface :





ProductApiClient : Récupère les données du produit.



Scénarios de Test :





Récupération Réussie :





Configurer le mock ProductApiClient pour retourner un Product valide.



Initialiser ProductService avec le mock.



Appeler la méthode de récupération et vérifier le résultat.



Valider que le mock a été appelé avec le bon ID.



Argument Invalide :





Configurer le mock pour lever une exception pour un ID invalide.



Vérifier que ProductService gère l'exception correctement.



Échec de l'Appel API :





Configurer le mock pour simuler un échec d'API.



Vérifier que ProductService gère l'échec de manière appropriée.