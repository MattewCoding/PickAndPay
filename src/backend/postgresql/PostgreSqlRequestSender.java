package backend.postgresql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class PostgreSqlRequestSender {

    public static boolean addUser(String lastName, String firstName, char gender, char phoneNumber, String email, String pseudo, String password) {
        String url = "jdbc:postgresql://aws-0-us-east-2.pooler.supabase.com:6543/postgres";
        String user = "postgres.gwrtkhydizquwpzppwdj";
        String passwordSql = "";

        String sql = "INSERT INTO public.\"Utilisateur\" " +
                     "(id_utilisateur, nom_utlisateur, prenom_utilisateur, sex_utilisateurn, numero_telephone_utilisateur, adresse_mail_utilisateur, pseudo, mot_de_passe) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Generate UUID for id_utilisateur
        String id_util = UUID.randomUUID().toString();

        try (Connection conn = DriverManager.getConnection(url, user, passwordSql);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id_util);
            pstmt.setString(2, lastName);
            pstmt.setString(3, firstName);
            pstmt.setString(4, String.valueOf(gender));  // char as String
            pstmt.setString(5, String.valueOf(phoneNumber));
            pstmt.setString(6, email);
            pstmt.setString(7, pseudo);
            pstmt.setString(8, password);

            int affectedRows = pstmt.executeUpdate();
            System.out.println("Inserted " + affectedRows + " row(s) into the database.");

            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
