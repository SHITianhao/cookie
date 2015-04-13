Choix d'implémentations : 

-1 bean par fonctionalité attendue + 1 bean pour pouvoir ajouter des ingrédients, en trouver.

-Il n'y a pas de recette personalisée, mais on peut envisager de rentrer un ingrédient dans la base de donnée qui fasse office de recette personnalisée.

-Certaines fonctionalités se recoupent, ce pourquoi on a quelques managers.

-On essaye de ne sauvegarder que quand c'est nécessaire(cad à la validation de la commande)
De ce fait, on a beaucoup de "Eager", car on a besoin de toute l'arboresence (mais elle n'est utilisée qu'une fois).

-On renvoie dans une chaîne de caractères la confirmation de commande.

-Le client, en terminal, permet d'accéder de manière simple aux fonctionnalités.

Problèmes :
- On ne peut créer qu'une commande pour l'instant
- On n'a pas de lien entre boutique et commande, seulement une string.




