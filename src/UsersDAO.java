package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDAO {
   private Connection conn = null;
   private ResultSet rset = null;
   private int returnValue;

   void connect() {
      String var1 = "COSC424";
      String var2 = "not2secure";

      try {
         Class.forName("oracle.jdbc.OracleDriver");
      } catch (ClassNotFoundException var5) {
         System.out.println("Could not get class object for Driver");
         System.exit(1);
      }

      try {
         this.conn = DriverManager.getConnection("jdbc:oracle:thin:@csse-oracle3.canterbury.ac.nz:1521:CSORA131", var1, var2);
      } catch (SQLException var4) {
         System.out.println("Could not make connection to database");
         System.exit(1);
      }

   }

   void executeSQLQuery(FrontEnd var1) {
      String var2 = null;
      Statement var3 = null;
      var2 = "select * from users where username = \'" + var1.getUsername() + "\'" + " and " + "upassword = " + "\'" + var1.getPassword() + "\'";

      try {
         var3 = this.conn.createStatement();
         this.rset = var3.executeQuery(var2);
      } catch (SQLException var5) {
         System.out.println("Could not execute SQL statement: " + var2);
      }

   }

   void executeSQLQueryPrepared(FrontEnd var1) {
      String var2 = null;
      PreparedStatement var3 = null;
      var2 = "select * from users where username = ? and upassword = ?";

      try {
         var3 = this.conn.prepareStatement(var2);
         var3.setString(1, var1.getUsername());
         var3.setString(2, var1.getPassword());
         this.rset = var3.executeQuery();
      } catch (SQLException var5) {
         System.out.println("Could not execute SQL statement: " + var2);
      }

   }

   void executeSQLNonQuery(String var1) {
      Statement var2 = null;

      try {
         var2 = this.conn.createStatement();
         this.returnValue = var2.executeUpdate(var1);
      } catch (SQLException var4) {
         System.out.println("Could not execute SQL command: " + var1);
      }

   }

   String processResultSet() {
      ResultSetMetaData var1 = null;
      String var2 = "";

      try {
         var1 = this.rset.getMetaData();

         for(int var3 = var1.getColumnCount(); this.rset.next(); var2 = var2 + "\n") {
            for(int var4 = 1; var4 <= var3; ++var4) {
               var2 = var2 + this.rset.getString(var4) + "  ";
            }
         }
      } catch (SQLException var5) {
         System.out.println("error in processing result set");
      }

      return var2;
   }

   void disconnect() {
      try {
         if(this.conn != null) {
            this.conn.close();
         }
      } catch (SQLException var2) {
         System.out.println("Error in closing database connection");
      }

   }
}
