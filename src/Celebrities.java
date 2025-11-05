//import java.util.*;

public class Celebrities {

	public static void main(String[] args) {
		
		// Je déclare et initialise variable entière avec la valeur 8. Elle représente le nombre total d'invités.
		  int numberOfGuests = 8; 

		    // Je crée un tableau de tableaux d'entiers, ici, chaque ligne est un tableau d'entiers listant les numéros des invités que la personne connait.
		    int[][] knowledge = {
		        {2, 5, 6},          // 1. Albert
		        {3, 5, 6},          // 2. Bénédicte
		        {2, 4, 5, 6},       // 3. Christophe
		        {1, 2, 5, 6, 8},    // 4. Delphine
		        {6},                // 5. Edouard
		        {5},                // 6. Françoise
		        {2, 3, 5, 6, 8},    // 7. Gaston
		        {2, 4, 5, 6, 7}     // 8. Héloïse
		    };

		    // Je crée un tableau booléens, chaque case de ce tableau indiquera, à la fin si l'invité est considéré comme célébrité ou non.
		    boolean[] isCelebrity = new boolean[numberOfGuests];
		    for (int i = 0; i < numberOfGuests; i++) {
		        isCelebrity[i] = true; //La boucle for initialise chaque élément du tableau (isCelebrity), on suppose au départ que tout le monde peut être une célébrité.
		    }

		    // Par vérification des règles, on élimine ceux qui ne respectent pas les règles.
		    
		    for (int i = 0; i < numberOfGuests; i++) { // pour chaque invité i (i étant la personne testée)
		        for (int j = 0; j < numberOfGuests; j++) { // pour chaque invité j (j étant la personne potentiellement candidat célébrité)
		            if (i != j) {
		                boolean iKnowJ = knows(knowledge[i], j + 1); /*** Un booléen appelle la fonction (knows) pour vérifier si l'invité i connait j. Ensuite on stocke le résultat (true/false) dans (iKnowJ)***/

		                // Règle 1 : Chaque invité connait toutes les célébrités.
		                
		                if (isCelebrity[j] && !iKnowJ) {	
		                    isCelebrity[j] = false;
		                }										/***Ici si j est encore marqué comme célébrité possible mais que l'invité i ne le connait pas, alors j ne peut pas être une célébrité***/

		                // Règle 2 : Chaque célébrité ne connait que les autres célébrités.
		                if (!isCelebrity[j] && iKnowJ && isCelebrity[i]) {
		                    isCelebrity[i] = false;
		                }													/***j étant éliminé, si i connait j et i est actuellement encore candidat célébrité, alors i ne peut pas être une célébrité. Le
		                 													tableau (isCelebrity) affiche true pour les indices qui n'ont pas été disqualifiés par les deux règles.***/
		            }
		        }
		    }

		    // Affichage du résultat
		    System.out.println("Célébrités trouvées : ");
		    boolean empty = true;								// J'initialise un indicateur à true pour savoir si aucune célébrité n'a été trouvée, afin d'afficher un message si nécessaire.
		    for (int i = 0; i < numberOfGuests; i++) {
		        if (isCelebrity[i]) {
		            System.out.println("Invité " + (i + 1));
		            empty = false;								// Cette boucle parcourt tous les invités et affiche (Invité + le numéro) si (isCelebrity) vaut true. Ainsi (empty) vaut false.
		        }
		    }

		    if (empty) {
		        System.out.println("Aucune célébrité trouvée !");
		    }														// Si (empty) vaut true, on affiche le message indiquant qu'aucune célébrité n'a été trouvée.
		}

		
		// Elle retourne true si "invité" (numéro) est présent dans la liste "knownList"
		static boolean knows(int[] knownList, int guest) {
		    for (int i = 0; i < knownList.length; i++) {
		        if (knownList[i] == guest) {
		            return true;
		        }
		    }
		    return false;						/*** Cette méthode prend en paramètres la liste (tableau) des personnes connues par une personne donnée, et un numéro. La boucle parcourt chaque élément de (KnownList).
		     									Si un élément égale (guest), elle renvoie true (c'est à dire que la personne est trouvée dans la liste). Si la boucle se termine sans trouver (guest), elle renvoie false.***/

	}

}
