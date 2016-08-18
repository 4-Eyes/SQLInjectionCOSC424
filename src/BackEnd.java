package src;

public class BackEnd {
   private UsersDAO aUsersDAO = null;
   private Filter aFilter = null;

   public BackEnd() {
      this.aUsersDAO = new UsersDAO();
      this.aFilter = new Filter();
   }

   public String process(FrontEnd var1) {
      String var2 = null;
      this.aUsersDAO.connect();
      if(var1.getUseFilter()) {
         String var3 = var1.getUsername();
         System.out.println("Username before filtering: >" + var3 + "<");
         var3 = this.aFilter.filterMetaChars(var3);
         System.out.println("Username after filtering: >" + var3 + "<");
         var1.setUsername(var3);
         String var4 = var1.getPassword();
         System.out.println("Password before filtering: >" + var4 + "<");
         var4 = this.aFilter.filterMetaChars(var4);
         System.out.println("Password after filtering: >" + var4 + "<");
         var1.setPassword(var4);
      }

      if(var1.getUsePreparedStatement()) {
         this.aUsersDAO.executeSQLQueryPrepared(var1);
      } else {
         this.aUsersDAO.executeSQLQuery(var1);
      }

      var2 = this.aUsersDAO.processResultSet();
      this.aUsersDAO.disconnect();
      return var2;
   }
}
