package src;

public class FrontEnd {
   private String username;
   private String password;
   private boolean usePreparedStatement;
   private boolean useFilter;
   private BackEnd aBackEnd;

   public FrontEnd() {
   }

   public FrontEnd(BackEnd var1) {
      this.aBackEnd = var1;
   }

   public String getUsername() {
      return this.username;
   }

   public String getPassword() {
      return this.password;
   }

   public boolean getUsePreparedStatement() {
      return this.usePreparedStatement;
   }

   public boolean getUseFilter() {
      return this.useFilter;
   }

   public void setUsername(String var1) {
      this.username = var1;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }

   public void setUsePreparedStatement(boolean var1) {
      this.usePreparedStatement = var1;
   }

   public void setUseFilter(boolean var1) {
      this.useFilter = var1;
   }

   public String processInput(String var1, String var2, boolean var3, boolean var4) {
      String var5 = null;
      this.setUsername(var1);
      this.setPassword(var2);
      this.setUsePreparedStatement(var3);
      this.setUseFilter(var4);
      var5 = this.aBackEnd.process(this);
      return var5;
   }
}
