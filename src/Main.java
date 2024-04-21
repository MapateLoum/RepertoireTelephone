import monpackage.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("Bienvenu dans votre répertoire de téléphone.");
		System.out.println("");
		System.out.println("-----------------------------------------");
		System.out.println("| Choix    | Fonctions                  |");
		System.out.println("-----------------------------------------");
		System.out.println("| 1        | Créer un nouveau contact   |");
		System.out.println("-----------------------------------------");
		System.out.println("| 2        | Modifier un contact        |");
		System.out.println("-----------------------------------------");
		System.out.println("| 3        | Supprimer un contact       |");
		System.out.println("-----------------------------------------");
		System.out.println("| 4        | Afficher tous les contacts |");
		System.out.println("-----------------------------------------");
		System.out.println("| 5        | Rechercher un contact      |");
		System.out.println("-----------------------------------------");
		
		 try 
		 {
			System.out.println("Veuiller faire votre choix :");
			int choix = scanner.nextInt();
			System.out.println("");
         switch (choix) 
		 {
			case 1:
				CreerContact.CreationContact();
				break;
			case 2:
				ModifierContact.ModificationContact();
				break;
			case 3:
			SupprimerContact.SuppressionContact();
			break;
			case 4:
			AfficherRepertoire.AffichageRepertoire();
			break;
			case 5:
			RechercherContact.RechercheContact();
			break;
			default:
			System.out.println("Veuiller faire un choix parmi ceux qui sont donnés.");
				break;
		 }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		scanner.close();
	}

}