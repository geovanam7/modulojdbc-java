import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
     PreparedStatement st = null;

     try {
         conn = DB.getConnection();

//         st = conn.prepareStatement(    //inserir um seller
//                 "INSERT INTO seller" +
//                         "(Name, Email, BirthDate, BaseSalary, DepartmentId)" +
//                         "VALUES " +"(?,?,?,?,?)" ,
//                         Statement.RETURN_GENERATED_KEYS);
//
//          st.setString(1,"Carl Purple");
//          st.setString(2,"Carl@gmail.com");
//          st.setDate(3,new java.sql.Date(sdf.parse("22/04/1985").getTime()));
//         st.setDouble(4,3000.0);
//         st.setInt(5,4);

         st = conn.prepareStatement("insert into department (Name) values ('D1'),('D2') ", Statement.RETURN_GENERATED_KEYS);  // inserir dois departments
       int rowsAffected = st.executeUpdate();

      if (rowsAffected > 0 ){
         ResultSet rs = st.getGeneratedKeys();
         while (rs.next()){
             int id = rs.getInt(1);
             System.out.println ("Done! Id = " + id);

         }
      }else{
          System.out.println ("No rows afeccted");
      }

     } catch (SQLException  e) {
         throw new RuntimeException(e);
     }
     finally {
         DB.closeStatement(st);
         DB.CloseConnection();
     }

    }
}
