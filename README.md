# Project Java - Baetslé Antoine & Antoine Valentin

## Fonctionnalités 
- Finir le formulaire INSERT 
- Listing de tout les objets SELECT
- Supprimer un objet DELETE 
- Mettre à jour un objet UPDATE

--> Vendredi max

## Questions 
- Fermeture de la db. Where ? 
## Requêtes pour Val

* Select tout les collectifs ==> Done 
* Select tout les objets d'un collectif ==> Almost Done
* Select tout les objets

## Todo Val
* Gestion du null dans le spinner et dans le listing
* Gestion des exceptions ?
* Forcer des champs obligatoires
* Recharger liste des objest après un delete
* Gestion des dates un peu partout :
* * update qui récupère la date (ou null)
* * update peut mettre la date à null
* * insert peut mettre une date null

## Design Patterns 
### Couche Controler
* public addObject(object)
* public addTypeOfProblemRental(typeOfProblemRental)
* public addProblemExitLocation(problemExitLocation)
* public addRental(rental)
* public modifyRental(rental)
* public deleteRental(rental)
* public addCollective(collective)
* public getCollectivesByCategorie(categorie)
* public getRentalsByTypeOfProblemExitLocation(typeOfProblemLocation)
* public getProblemsBetweenDates(firstDate, secondDate)
* public deleteObject(object)
* public changeObject(object)
* publit getAllObjectsByCollectives(collective)
* public getAllRentalsByCollectives(collective)

### Couche Business
* public addObject(object)
* public addTypeOfProblemRental(typeOfProblemRental)
* public addProblemExitLocation(problemExitLocation)
* public addRental(rental)
* public modifyRental(rental)
* public deleteRental(rental)
* public addCollective(collective)
* public getCollectivesByCategorie(categorie)
* public getRentalsByTypeOfProblemExitLocation(typeOfProblemLocation)
* public getProblemsBetweenDates(firstDate, secondDate)
* public deleteObject(object)
* public changeObject(object)
* publit getAllObjectsByCollectives(collective)
* public getAllRentalsByCollectives(collective)

### Couche DataAccess
* public addObject(object)
* public addTypeOfProblemRental(typeOfProblemRental)
* public addProblemExitLocation(problemExitLocation)
* public addRental(rental)
* public modifyRental(rental)
* public deleteRental(rental)
* public addCollective(collective)
* public getCollectivesByCategorie(categorie)
* public getRentalsByTypeOfProblemExitLocation(typeOfProblemLocation)
* public getProblemsBetweenDates(firstDate, secondDate)
* public deleteObject(object)
* public changeObject(object)
* publit getAllObjectsByCollectives(collective)
* public getAllRentalsByCollectives(collective)
