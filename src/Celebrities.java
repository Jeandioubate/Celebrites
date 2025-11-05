//import java.util.*;

public class Celebrities {

	public static void main(String[] args) {
		  int numberOfGuests = 8; // nombre d'invités

		    // --- Étape 1 : Tableau des connaissances (chaque case contient la liste des invités connus) ---
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

		    // --- Étape 2 : Tableau des célébrités possibles ---
		    boolean[] isCelebrity = new boolean[numberOfGuests];
		    for (int i = 0; i < numberOfGuests; i++) {
		        isCelebrity[i] = true; // on suppose au départ que tout le monde peut être une célébrité
		    }

		    // --- Étape 3 : Vérification des règles ---
		    for (int i = 0; i < numberOfGuests; i++) { // pour chaque invité i
		        for (int j = 0; j < numberOfGuests; j++) { // pour chaque invité j
		            if (i != j) {
		                boolean iKnowJ = knows(knowledge[i], j + 1);

		                // Règle 1 : tout invité doit connaître les célébrités
		                if (isCelebrity[j] && !iKnowJ) {
		                    isCelebrity[j] = false;
		                }

		                // Règle 2 : une célébrité ne connaît aucun quidam
		                if (!isCelebrity[j] && iKnowJ && isCelebrity[i]) {
		                    isCelebrity[i] = false;
		                }
		            }
		        }
		    }

		    // --- Étape 4 : Affichage du résultat ---
		    System.out.println("Célébrités trouvées : ");
		    boolean empty = true;
		    for (int i = 0; i < numberOfGuests; i++) {
		        if (isCelebrity[i]) {
		            System.out.println("Invité " + (i + 1));
		            empty = false;
		        }
		    }

		    if (empty) {
		        System.out.println("Aucune célébrité trouvée !");
		    }
		}

		// --- Fonction auxiliaire ---
		// Retourne true si "invité" (numéro) est présent dans la liste "knownList"
		static boolean knows(int[] knownList, int guest) {
		    for (int i = 0; i < knownList.length; i++) {
		        if (knownList[i] == guest) {
		            return true;
		        }
		    }
		    return false;

	}

}
