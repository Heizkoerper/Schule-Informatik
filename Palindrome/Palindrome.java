public class Palindrome {
  private static Stack<Character> stack = new Stack<Character>();
  
  private static char[] original;
  private static char[] reversed;
  
  // private static boolean validity = true;
  
  public static boolean palindromPruefen(String pStr) {
    
         System.out.println("test");
    
      boolean validity = true;
    
      String str = pStr.replaceAll("\\s", "");
      str = str.toLowerCase();
      
      int len = str.length();
  
      original = str.toCharArray();
      reversed = new char[len];
      
      for (int i = 0; i < len; i++) {
          stack.push(original[i]);
      }
    
    
      int j = 0;
      while (!stack.isEmpty()) { 
          reversed[j] = stack.top();
          stack.pop();
      
          j++;
      }
      
    
      if (original.length != reversed.length) System.out.println("Fehler, Arrays nicht gleich lang!");
      
    
      for (int i = 0; i < original.length; i++) {
          if (validity) { validity = (original[i] == reversed[i]); }
      }
    
      System.out.println(validity);
      return validity;
  }
} 


