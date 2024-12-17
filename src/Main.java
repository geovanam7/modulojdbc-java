import db.DB;

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
                    "UPDATE seller SET BaseSalary = BaseSalary + ? WHERE DepartmentId = ?"
            );

            // Configuração dos parâmetros
            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            // Executa a atualização
            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows Affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fecha recursos
            DB.CloseConnection();
            DB.closeStatement(st);
        }
    }
}
