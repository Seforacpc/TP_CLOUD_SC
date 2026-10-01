# TP Cloud - Car Rental REST API

Application REST de location de voitures réalisée avec Java 21, Spring Boot et Gradle.

## Fonctionnalités

- Lister les voitures disponibles
- Récupérer une voiture par son numéro de plaque
- Louer une voiture
- Rendre une voiture

## Lancer l'application

```powershell
.\gradlew.bat bootRun

```

L'application est disponible sur :

http://localhost:8080

## Routes REST

### Liste des voitures disponibles

GET /cars

### Récupérer une voiture

GET /cars/{plateNumber}

Exemple :

GET /cars/AA11BB

### Louer une voiture

PUT /cars/{plateNumber}?rent=true

Body JSON :

```json
{
  "begin": "11/11/2017",
  "end": "1/1/2018"
}
```

### Rendre une voiture

PUT /cars/{plateNumber}?rent=false

## Build

```powershell
.\gradlew.bat clean test
.\gradlew.bat build
```