package src;

public class Filter {
   public String filterMetaChars(String var1) {
      String var2 = "";
      String[] var3 = var1.split("\\p{Punct}");

      for(int var4 = 0; var4 < var3.length; ++var4) {
         var2 = var2 + var3[var4];
      }

      return var2;
   }
}
