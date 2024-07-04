package monpackage;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AfficherRepertoire{

public static void AffichageRepertoire()
throws SQLException 
{
    
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact", "root", "Papaloum1613")) 
    {
    Statement stmt = con.createStatement();
    String liste = "select prenom,nom,numero,mail from Repertoire ORDER BY nom,prenom;";

    ResultSet rs = stmt.executeQuery(liste);

    while (rs.next()) 
    {
     
     String prenom = rs.getString("prenom");
     String nom = rs.getString("nom");
     int numero = rs.getInt("numero");
     String mail = rs.getString("mail");
    
      String ligne = String.format("  \t" +"%-20s %-15s %-15s %-15s", prenom, nom, numero, mail);
     System.out.println(ligne);
    
    }
    if (con != null) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
    
} 
}