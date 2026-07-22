# API - PPE ERP Enterprise

## Base URL

```
http://localhost:8080/api
```

---

# Authentification

## GET /auth

Vérifie que le service d'authentification fonctionne.

Réponse :

```json
{
  "message": "Auth OK"
}
```

---

# Produits

## GET /products

Retourne la liste des produits.

## GET /products/{id}

Retourne un produit.

## POST /products

Crée un produit.

## PUT /products/{id}

Modifie un produit.

## DELETE /products/{id}

Supprime un produit.

---

# Clients

GET /customers

POST /customers

PUT /customers/{id}

DELETE /customers/{id}

---

# Fournisseurs

GET /suppliers

POST /suppliers

PUT /suppliers/{id}

DELETE /suppliers/{id}

---

# Santé de l'application

GET /health

Permet de vérifier que l'application fonctionne.

---

# Version

GET /version

Retourne la version du logiciel.
