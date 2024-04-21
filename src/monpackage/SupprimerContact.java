package monpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
//import java.util.Scanner;
//import java.sql.SQLException;

public class SupprimerContact 
{
   public static void SuppressionContact()
    
	throws SQLException 
	{
       Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {
            System.out.println("Veuiller donner le prénom du contact à supprimer :");
            String prenom = scanner.nextLine();

            System.out.println("Veuiller donner le nom du contact à supprimer :");
            String nom = scanner.next();
            scanner.nextLine();


           String sql = "DELETE FROM Repertoire where prenom=? and nom=?;";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1, prenom);
                pstmt.setString(2, nom);
                
                pstmt.executeUpdate();

            }   System.err.println("Contact supprimé avec succés.");
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } 
        scanner.close();
    }
    
}
