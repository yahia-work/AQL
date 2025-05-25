# TP1 : Tests Unitaires avec JUnit 5

Ce projet porte sur l'implémentation et le test de différents algorithmes et services à l'aide de tests unitaires avec **JUnit 5**. Il comprend des corrections de bogues, une meilleure gestion des exceptions, ainsi qu'une couverture de tests approfondie pour garantir la robustesse et la fiabilité du code.

---

## 🧠 Objectifs du TP

- Corriger des erreurs logiques dans des algorithmes courants.
- Implémenter des tests unitaires robustes.
- Gérer les exceptions via des classes personnalisées.
- Maîtriser les techniques de **mocking** et de **test d’interaction**.

---

## 📁 Structure du Projet

Le projet est divisé en plusieurs exercices (Exo1 à Exo6) :

- **Exo1** : Palindrome  
- **Exo2** : Anagramme  
- **Exo3** : Recherche binaire  
- **Exo4** : Équation quadratique  
- **Exo5** : Conversion chiffres romains  
- **Exo6** : FizzBuzzLine  

Des services supplémentaires comme `UserService` et un `Jeu de dés` ont aussi été testés.

---

## ✅ Corrections Apportées

### 🔁 Algorithmes

| Exercice | Problème | Correction |
|---------|----------|------------|
| **Exo1 : Palindrome** | Boucle avec `i--`, `j++` incorrects | Corrigé en `i++`, `j--` |
| **Exo2 : Anagramme** | Dépassement de tableau (`i <= s1.length()`) | Corrigé en `i < s1.length()` |
| **Exo3 : Recherche Binaire** | Cas `low == high` non traité | Condition modifiée en `low <= high` |
| **Exo4 : Équation Quadratique** | Aucun bogue détecté | ✅ |
| **Exo5 : Chiffres Romains** | Dépassement (`i <= symbols.length`) | Corrigé en `i < symbols.length` |
| **Exo6 : FizzBuzzLine** | Condition trop restrictive (`n <= 1`) | Corrigée en `n < 1` |

---

## ❗ Exceptions Personnalisées

### 🧍 UserService

- **Exception** : `ServiceException`  
- **Rôle** : Levée si l'utilisateur a des données invalides (null, vide).

### 🎲 Jeu de Dés

- **`DebitImpossibleException`** : Levée si la mise > solde joueur.
- **`JeuFermeException`** : Levée si le jeu est fermé (fonds épuisés).

---

## 🧪 Améliorations des Tests Unitaires

| Classe Testée | Problèmes Initiaux | Améliorations |
|---------------|--------------------|---------------|
| **Calculatrice** | Méthode `getResult()` manquante, mock inutile | Ajout de `getResult()`, suppression du mock |
| **UserService** | Tests limités | Ajout de tests paramétrés, assertions complètes |
| **UserServiceScenariosTest** | Scénarios incomplets | Couverture des cas limites |
| **Jeu (Jeu de dés)** | Manque de couverture | Tests ajoutés pour exceptions et comportements critiques |

---

## 🔍 Tests de la Classe `Jeu`

### ✅ Dépendances à Mocker

- `Banque` : Crédit/débit de fonds
- `Joueur` : Solde, mises
- `De` : Génére des lancers aléatoires

### 📘 Scénarios de Test

1. **Jeu fermé** : `JeuFermeException` levée
2. **Joueur insolvable** : `DebitImpossibleException` levée
3. **Somme ≠ 7** : Joueur perd, banque garde mise
4. **Somme = 7, banque solvable** : Joueur gagne x2
5. **Somme = 7, banque insolvable** : Banque paie partiellement, jeu fermé
6. **Banque insolvable dès le départ** : Jeu fermé immédiatement

### 🔎 Test le plus simple

- **Scénario** : Jeu fermé
- **Test** : Appel à `fermer()` suivi de `jouer()` → `JeuFermeException`

### 🧪 Test d'interaction : joueur insolvable

- Objectif : Vérifier que les dés **ne sont pas lancés**
- Vérification avec :  
  ```java
  verify(de1Mock, never()).lancer();
  verify(de2Mock, never()).lancer();
