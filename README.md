# Simple Web Commerce Application

Une application e-commerce simple construite avec **Spring Boot** et **Java 21**, proposant une API REST pour gérer des produits.

---

## 🛠️ Technologies Utilisées

* **Langage :** Java 21
* **Framework Principal :** Spring Boot 4.0.6 (avec Spring Web, Validation, etc.)
* **Persistance des Données :** Spring Data JPA (Hibernate)
* **Base de Données :** H2 Database (base de données en mémoire pour le développement)
* **Outil de Build :** Maven (avec Wrapper `./mvnw`)
* **Outils de Productivité :** Spring Boot DevTools (rechargement automatique)

---

## 📁 Structure du Projet

L'application suit l'architecture standard de Spring Boot :

* **`models/` :** Contient les entités JPA (par exemple, la classe `Product` mappée à la base de données).
* **`repositories/` :** Interfaces Spring Data pour l'accès aux données (par exemple, `ProductRepository` étendant `JpaRepository`).
* **`services/` :** Couche métier contenant la logique opérationnelle (par exemple, `ProductService`).
* **`controllers/` :** Points d'entrée de l'API REST (par exemple, `ProductController` exposant les routes `/products`).

---

## 🚀 Fonctionnalités & API REST

Le contrôleur expose les endpoints suivants pour la gestion des produits (`/products`) :

| Méthode | Route | Description |
| :--- | :--- | :--- |
| **GET** | `/products` | Récupérer tous les produits |
| **GET** | `/products/{id}` | Récupérer un produit par son identifiant unique |
| **POST** | `/products` | Créer et ajouter un nouveau produit |
| **PUT** | `/products/{id}` | Mettre à jour les informations d'un produit |
| **DELETE** | `/products/{id}` | Supprimer un produit par son identifiant |

### Exemple de corps JSON (POST / PUT) :
```json
{
  "name": "Clavier Mécanique RGB",
  "description": "Clavier de jeu rétroéclairé avec interrupteurs tactiles.",
  "price": 89.99,
  "stock": 150
}
```

---

## 💻 Exécution Locale

### Prérequis
* **Java 21** ou version supérieure.
* **Maven** (inclus via `./mvnw`).

### Lancer l'application
Exécutez la commande suivante à la racine du projet :
```bash
./mvnw spring-boot:run
```

L'application démarrera par défaut sur le port **8083** (configuré dans `application.properties`).

### Console H2
Vous pouvez accéder à la console de la base de données H2 en mémoire à l'adresse suivante :
* **URL :** `http://localhost:8083/h2-console`
* **JDBC URL :** `jdbc:h2:mem:Test`
* **Nom d'utilisateur :** `sa`
* **Mot de passe :** *(vide)*
