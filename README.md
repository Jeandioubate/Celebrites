# Célébrités

## 1. Objectif du programme

Ce programme permet d'identifier le groupe de célébrités lors d'une fête, à partir des connaissances entre invités. Une célébrité est définie selon deux règles:

    * Chaque invités connait toutes les célébrités;
    * Chaque célébrité ne connait que les autres célébrités (elle ne connait aucun quidam).

Le programme utilie une structure de données simple (tableau de liste) pour représenter les connaissances.

## 2. Fonctionnement

    a. Chaque invité est représenté par un numéro (1 à 8);
    b. Pour chaque invité, on stocke la liste des personnes qu'il connait dans un tableau. Exemple:

        ```{2, 5, 6} // signifie : l'invité 1 connait les invités 2, 5 et 6.```
    
    c. Le programme commence par supposer que tout le monde peut être une célébrité;
    d. Ensuite, il applique les deux règles :

        * Si un invité ne connait pas une célébrité alors cette personne n'est pas une célébrité;
        * Si une célébrité connait un quidam alors elle perd son statut de célébrité;

    e. A la fin, le programme affiche la liste des invités restants qui respectent ces conditions.

## 3. Structure du code

    * int[][] knowlegde : stocke les relations de connaissance;
    * boolean[] isCelebrity : indique si un invité est encore candidat célébrité;
    * Boucles ```for``` imbriquées : appliquent les deux règles du problème;
    * knows(int[] knownList, int guest) : vérifie si une personne connait une autre;
    * System.out.println : affiche le résultat final.

## 4. Exécution

    ### Compiler le programme

    ```bash
    javac Celebrities.java
    ```

    ### Exécuter le programme

    ```bash
    java Celebrities
    ```