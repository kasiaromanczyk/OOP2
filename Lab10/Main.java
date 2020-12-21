class Main {
  public static void main(String[] args) {
    
    String a=args[0];
    String x=new String(), y=new String();
    String arr[] = a.split("");
    Stack<String> strStack= new Stack<String>(arr.length);

    for(String s : arr){
      if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
        y = strStack.pop();
        x = strStack.pop();
        strStack.push("("+x+s+y+")");
      }
      else strStack.push(s);
    }
    if(strStack.size==1) System.out.println("Wynik "+strStack); 
    if(strStack.size>1) {
      System.out.println("BLAD DANYCH WEJSCIOWYCH: Koniec algorytmu, a stos nie jest pusty:"+strStack);
    }
  }
}

//program implementuje algorytm dekodowania ONP
//korzysta ze stosu zaimplementowanego jako klasa Stack