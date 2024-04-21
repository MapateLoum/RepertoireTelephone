package monpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ModifierContact
{
    public static void ModificationContact()
    
	throws SQLException 
	{
       Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {
            System.out.println("Veuiller donner le prénom du contact à modifier :");
            String prenom = scanner.nextLine();

            System.out.println("Veuiller donner le nom du contact à modifier :");
            String nom = scanner.nextLine();

            System.out.println("Veuillez donner le nouveau prénom du contact : ");
            String nprenom = scanner.nextLine();
            System.out.println("Veuillez donner le nouveau nom du contact : ");
            String nnom = scanner.nextLine();
            System.out.println("Veuillez donner le nouveau numéro du contact : ");
            int numero = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Veuillez donner le nouveau mail du contact : ");
            String mail = scanner.nextLine();

           String sql = "UPDATE Repertoire SET prenom = ?,nom=?,numero=?,mail=? WHERE prenom=? and nom=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1, nprenom);
                pstmt.setString(2, nnom);
                pstmt.setInt(3,numero);
                pstmt.setString(4,mail);
                pstmt.setString(5,prenom);
                pstmt.setString(6, nom);
                
                pstmt.executeUpdate();

            }   System.err.println("Contact modifié avec succés.");
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
