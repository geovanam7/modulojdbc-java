import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            // Query SQL 
            st = conn.prepareStatement(
                    "DELETE FROM department WHERE Id = ?"
            );

            st.setInt(1, 9);

            // Executa a atualização
            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows Affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            // Fecha recursos
            DB.CloseConnection();
            DB.closeStatement(st);
        }
    }
}
