public class Palindrome {
  private Stack<Character> stack = new Stack<Character>();
  
  private char[] original;
  private char[] reversed;
  
  private boolean validity = true;
  
  private boolean palindromPruefen(String pStr) {
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


