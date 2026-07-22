# Architecture - PPE ERP Enterprise

## Architecture générale

Le projet suit une architecture en couches (Layered Architecture).

```
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
PostgreSQL
```

---

## Structure du projet

```
backend/
└── src/main/java/
    └── fr/ppe/
        ├── config/
        ├── controller/
        ├── dto/
        ├── entity/
        ├── repository/
        ├── security/
        ├── service/
        └── PPEApplication.java
```

---

## Technologies

- Java 21
- Spring Boot
- Spring Security
- JWT
- Maven
- PostgreSQL
- Flyway
- Swagger/OpenAPI
- Docker
- GitHub Actions

---

## Principes

- Architecture REST
- Séparation des responsabilités
- Injection de dépendances avec Spring
- Base de données versionnée avec Flyway
- Sécurité par JWT
- Documentation OpenAPI

---

## Évolution prévue

### Version 0.2.0
- Authentification JWT complète
- CRUD Produits
- CRUD Clients
- CRUD Fournisseurs

### Version 0.3.0
- Gestion des commandes

### Version 0.4.0
- Gestion du stock

### Version 0.5.0
- Facturation

### Version 1.0.0
- Première version stable de gestion commerciale
