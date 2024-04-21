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

            int numero;
            System.out.println("Veuiller donner le numéro du contact : ");
            while (!scanner.hasNextInt()) 
            {
            System.out.println("Erreur !! Veuiller donner un numero du format (XXXXXXXXX) : ");
            scanner.next();		
            }
            numero= scanner.nextInt();	
            scanner.nextLine();

            System.out.println("Veuillez donner le mail du contact : ");
            String mail = scanner.nextLine();

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
