package monpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreerContact
{
    
	public static void CreationContact()
    
	throws SQLException 
	{
        Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {

           
            System.out.println("Veuillez donner le prénom du contact : ");
            String prenom = scanner.nextLine();
            System.out.println("Veuillez donner le nom du contact : ");
            String nom = scanner.nextLine();

            System.out.print("Veuillez donner le numéro de téléphone du patient  : ");
            int numero;
            while (!scanner.hasNextInt()) 
            {
                System.out.println("Le numéro doit être un entier !");
                scanner.next();
            }
            numero = scanner.nextInt();
    
            while (numero / 10000000 != 77 && numero / 10000000 != 78 && numero / 10000000 != 76 && numero / 10000000 != 70 && numero / 10000000 != 75) 
            {
                System.out.println("Le numéro doit commencer par 77, 78, 76, 70 ou 75 !");
                System.out.print("Veuillez entrer à nouveau le numéro de téléphone du patient : ");
                while (!scanner.hasNextInt()) 
                {
                    System.out.println("Le numéro doit être un entier !");
                    scanner.next();
                }
                numero = scanner.nextInt();
            }
            scanner.nextLine();

            String mail;
            do 
            {
                System.out.print("Veuillez saisir votre adresse e-mail : ");
                mail = scanner.nextLine();
    
                if (mail.length() < 10 || !mail.substring(mail.length() - 10).equals("@gmail.com")) 
                {
                    System.out.println("L'adresse e-mail n'est pas valide. Veuillez saisir une adresse e-mail valide.");
                }
            } while (mail.length() < 10 || !mail.substring(mail.length() - 10).equals("@gmail.com"));

            String sql = "INSERT INTO Repertoire(prenom,nom,numero,mail) VALUES(?,?,?,?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1, prenom);
                pstmt.setString(2, nom);
                pstmt.setInt(3,numero);
                pstmt.setString(4,  mail);

                pstmt.executeUpdate();

                System.err.println("Contact créé avec succés.");
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            scanner.close();
        }
    }


   

}
