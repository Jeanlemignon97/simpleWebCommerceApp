# Simple Web Commerce Application

Une application e-commerce REST construite avec **Spring Boot** et **Java 21**, proposant une API complète pour gérer des produits, incluant le support d'upload d'images.

---

## 🛠️ Technologies Utilisées

| Technologie | Version | Rôle |
|---|---|---|
| Java | 21 | Langage principal |
| Spring Boot | 4.0.6 | Framework principal |
| Spring Web (MVC) | - | API REST & controllers |
| Spring Data JPA | - | Accès aux données via ORM |
| Hibernate | 7.2.x | Implémentation JPA |
| H2 Database | 2.4.x | Base de données en mémoire (dev) |
| Lombok | 1.18.46 | Génération automatique de code (getters, setters, etc.) |
| Spring Boot DevTools | - | Rechargement automatique du serveur |
| Maven | - | Outil de build |

---

## 📁 Structure du Projet

```
src/main/java/com/example/simpleWebCommerceApp/
├── SimpleWebCommerceApp.java       # Point d'entrée Spring Boot
├── controllers/
│   └── ProductController.java      # Endpoints REST API (/api/...)
├── services/
│   └── ProductService.java         # Logique métier
├── repositories/
│   └── ProductRepository.java      # Interface JPA (accès BDD)
└── models/
    └── Product.java                # Entité JPA Product

src/main/resources/
├── application.properties.example  # Template de configuration (à copier)
└── data.sql                        # Données de test initiales (10 produits)
```

---

## 🗃️ Modèle de Données — `Product`

| Champ | Type | Description |
|---|---|---|
| `id` | `Long` | Identifiant auto-généré |
| `name` | `String` | Nom du produit |
| `description` | `String` | Description |
| `price` | `double` | Prix |
| `stock` | `int` | Quantité en stock |
| `category` | `String` | Catégorie (ex: Électronique) |
| `brand` | `String` | Marque |
| `releaseDate` | `Date` | Date de sortie |
| `isAvailable` | `boolean` | Disponibilité |
| `imageUrl` | `String` | Nom original du fichier image |
| `imageType` | `String` | Type MIME de l'image |
| `imageData` | `byte[]` | Données binaires de l'image (BLOB) |

---

## 🚀 API REST — Endpoints

Tous les endpoints sont préfixés par `/api`. Le CORS est activé (`@CrossOrigin`).

| Méthode | Route | Corps / Paramètres | Réponse | Description |
|---|---|---|---|---|
| **GET** | `/api/products` | — | `200 OK` + liste JSON | Récupérer tous les produits |
| **GET** | `/api/product/{id}` | `id` (path) | `200 OK` / `404` | Récupérer un produit par ID |
| **POST** | `/api/product` | `product` (JSON part) + `imageFile` (multipart) | `201 Created` | Créer un nouveau produit avec image |
| **PUT** | `/api/product/{id}` | `id` (path) + `product` + `imageFile` | `200 OK` / `400` | Mettre à jour un produit |
| **DELETE** | `/api/product/{id}` | `id` (path) | `200 OK` / `400` | Supprimer un produit |
| **GET** | `/api/product/{id}/image` | `id` (path) | `200 OK` + image binaire | Récupérer l'image d'un produit |

### Exemple de corps JSON (partie `product` du multipart) :
```json
{
  "name": "iPhone 15 Pro",
  "description": "Smartphone Apple avec écran Super Retina XDR.",
  "price": 1229.00,
  "stock": 45,
  "category": "Électronique",
  "brand": "Apple",
  "isAvailable": true
}
```

---

## 💻 Exécution Locale

### Prérequis
* **Java 21** ou version supérieure
* **Maven** (inclus via le wrapper `./mvnw`)

### 1. Configurer l'application
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```
> ⚠️ `application.properties` est dans le `.gitignore` — ne le committez jamais avec de vrais secrets.

### 2. Lancer l'application
```bash
./mvnw spring-boot:run
```
L'application démarre sur le port **8083**.

### 3. Tester l'API
```bash
# Récupérer tous les produits
curl http://localhost:8083/api/products
```

---

## 🗄️ Console H2 (Base de données en mémoire)

Accessible via votre navigateur pendant que l'application tourne :

* **URL :** `http://localhost:8083/h2-console`
* **JDBC URL :** `jdbc:h2:mem:jeanlemignon`
* **Nom d'utilisateur :** `sa`
* **Mot de passe :** *(vide)*

---

## 🔒 Configuration & Sécurité

Le fichier `application.properties` est **ignoré par git** (via `.gitignore`) pour protéger les informations sensibles (URL BDD, credentials).

Un fichier template `application.properties.example` est fourni. Copiez-le et renseignez vos valeurs locales :
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```
