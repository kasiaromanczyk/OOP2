import java.util.Arrays;
import java.lang.Class;
import java.lang.reflect.*;
import java.lang.*;

class Main {

  public static void main(String[] args) {

    try{
    String[] tab;
    tab=splitArgs(args[0]);                       
    Object arguments[] = new Object[tab.length-1];
    
    for(int i=1;i<tab.length;i++){
      arguments[i-1]= Double.parseDouble(tab[i]);
    }
    
      Class cl = Class.forName("java.lang.Math");
      Method m;
      if(tab.length==2) m = cl.getMethod(tab[0], Double.TYPE);
      else m = cl.getMethod(tab[0], Double.TYPE, Double.TYPE);
      Object obj = new Object();
      System.out.println("Wynik: "+m.invoke(obj, arguments));
    }
    catch(ClassNotFoundException e){
      System.out.println(e);
    }
    catch(NoSuchMethodException e){
      System.out.println("Nie ma takiej metody!");
    }
    catch(IllegalAccessException e){
      System.out.println(e);
    }
    catch(InvocationTargetException e){
      System.out.println(e);
    }
    catch(NumberFormatException e){
      System.out.println("Argumenty funkcji musza byc liczbami!");
    }
    catch(IllegalArgumentException e){
      System.out.println("Zla liczba argumentow funkcji! Podaj jedna lub dwie liczby");
    }
    catch(ArrayIndexOutOfBoundsException e){
      System.out.println("Nie podano nic do obliczenia!");
    }
    
    
  }

  public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> w.isEmpty() == false).toArray(String[]::new);
    }

}

//program takes one parameter: math function and arguments, e.g. "sin(0.0)""
//if given function exists as a method in Math class and arguments are valid
//program returns result of calculations