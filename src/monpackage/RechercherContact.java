package monpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RechercherContact 
{
    public static void RechercheContact() throws SQLException {
        Scanner scanner = new Scanner(System.in);
    
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) {
            System.out.println("Veuillez donner le prénom du contact : ");
            String pprenom = scanner.nextLine();
            System.out.println("Veuillez donner le nom du contact : ");
            String nnom = scanner.nextLine();
            
    
            String liste = "SELECT * FROM Repertoire WHERE prenom = ? AND nom = ?";
            PreparedStatement pstmt = con.prepareStatement(liste);
    
            pstmt.setString(1, pprenom);
            pstmt.setString(2, nnom);
    
            ResultSet rs = pstmt.executeQuery();
    
            while (rs.next()) {
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                int numero = rs.getInt("numero");
                String mail = rs.getString("mail");
    
                String ligne = String.format(" %-20s %-10s %-15s %-15s", prenom, nom, numero, mail);
                System.out.println(ligne);
            }
            //System.err.println("Query executed.....");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}   