import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;

//program porównuje czasy wykonywania operacji na różnych kolekcjach

class Main {
  public static void main(String[] args) {

    int n=Integer.parseInt(args[0]);
    int m=Integer.parseInt(args[1]);
    //parametry wywołania: n, m całkowite, n>m
    int l;

    String [] t1 = new String [n];
    String [] t2 = new String [m];
    String [] t3 = new String [m];
    char [] pom;
    Random rand = new Random();
    int [] b = new int[m];
    int is_small;

    System.out.println("Losowanie "+n+" lancuhow");
    System.out.println("Testowanie dla "+m+" lancuhow");
    for(int i=0;i<n;i++){
      l = rand.nextInt(21)+5;
      pom = new char[l];
      for(int j=0;j<l;j++){
        is_small = rand.nextInt(2);
        pom[j] = (char)(rand.nextInt(26)+65+is_small*32);
      }
      t1 [i] = new String(pom);   //wylosowanie n łańcuchów 5-25 znakowych, zapis do t1
      if(i<m){
        l = rand.nextInt(21)+5;
        pom = new char[l];
        for(int j=0;j<l;j++){
          is_small = rand.nextInt(2);
          pom[j] = (char)(rand.nextInt(26)+65+is_small*32);
        }
        t3 [i] = new String(pom);
      }//wylosowanie m łańcuchów 5-25 znakowych, zapis do t3
    }
    
    int f=1;
    int i=0;
    while(i<m){
      l= rand.nextInt(n);
      for (int el : b){
        if(el == l) f=0;        
      }
      if(f==1){
        t2[i] = t1[l];
        b[i] =l;
        i++;
      }
      f=1;
    }//wylosowanie m (różnych) łańcuchów to tablicy t2

  //stworzenie czterech pustych kolekcji dla typu String
  ArrayList<String> arr = new ArrayList<String>(n);
  LinkedList<String> list = new LinkedList<String>();
  HashMap<String,String> hmap = new HashMap<String,String>(n);
  TreeMap<String,String> tmap = new TreeMap<String,String>();
  
  //wypełnienie każdej kolekcji n łańcuchami z t1 i pomiar czasu
  long start = System.nanoTime();
  for(int j=0;j<n;j++){
    arr.add(t1[j]);
  }
  double time_arr = (System.nanoTime() - start)*Math.pow(10,-6);

  start = System.nanoTime();
  for(int j=0;j<n;j++){
    list.add(t1[j]);
  }
  double time_linked = (System.nanoTime() - start)*Math.pow(10,-6);

  start = System.nanoTime();
  for(int j=0;j<n;j++){
    tmap.put(t1[j],"");
  }
  double time_tree = (System.nanoTime() - start)*Math.pow(10,-6);

  start = System.nanoTime();
  for(int j=0;j<n;j++){
    hmap.put(t1[j],"");
  }
  double time_hash = (System.nanoTime() - start)*Math.pow(10,-6);

  System.out.println("Genetrate: ArrayList("+time_arr+"ms), LinkedList("+time_linked+"ms), TreeMap("+time_tree+"ms), HashMap("+time_hash+"ms)");

  System.out.println("Poczatek: rozmiary:"+arr.size()+" "+list.size()+" "+tmap.size()+" "+hmap.size());
  boolean find=true;
  Iterator<String> arr_it = arr.iterator();
  Iterator<String> list_it = list.iterator();

//znalezienie w kolekcji m znaków z tablicy t2 i pomiar czasu
  start = System.nanoTime();
  for(int j=0;j<m;j++){
    arr_it=arr.iterator();
    find=true;
    while(arr_it.hasNext() && find)
      if(arr_it.next()==t2[j]){
         find=false;
      }
  }
  time_arr = (System.nanoTime() - start)*Math.pow(10,-6);

  start = System.nanoTime();
  for(int j=0;j<m;j++){
    list_it=list.iterator();
    find=true;
    while(list_it.hasNext() && find)
      if(list_it.next()==t2[j]){
         find=false;
      }
  }
  time_linked = (System.nanoTime() - start)*Math.pow(10,-6);
  
  start = System.nanoTime();
   for(int j=0;j<m;j++)
        tmap.get(t2[j]);
   time_tree = (System.nanoTime() - start)*Math.pow(10,-6);

  start = System.nanoTime();
   for(int j=0;j<m;j++)
        hmap.get(t2[j]);
   time_hash = (System.nanoTime() - start)*Math.pow(10,-6);

  System.out.println("Search: ArrayList("+time_arr+"ms), LinkedList("+time_linked+"ms), TreeMap("+time_tree+"ms), HashMap("+time_hash+"ms)");

//znalezienie w kolekcji m znaków z tablicy t3 i pomiar czasu
 start = System.nanoTime();
  for(int j=0;j<m;j++){
    arr_it=arr.iterator();
    find=true;
    while(arr_it.hasNext() && find)
      if(arr_it.next()==t3[j]){
         find=false;
      }
  }
  time_arr = (System.nanoTime() - start)*Math.pow(10,-6);

  start = System.nanoTime();
  for(int j=0;j<m;j++){
    list_it=list.iterator();
    find=true;
    while(list_it.hasNext() && find)
      if(list_it.next()==t3[j]){
         find=false;
      }
  }
  time_linked = (System.nanoTime() - start)*Math.pow(10,-6);
  
  start = System.nanoTime();
   for(int j=0;j<m;j++)
        tmap.get(t3[j]);
   time_tree = (System.nanoTime() - start)*Math.pow(10,-6);

  start = System.nanoTime();
   for(int j=0;j<m;j++)
        hmap.get(t3[j]);
   time_hash = (System.nanoTime() - start)*Math.pow(10,-6);

  System.out.println("Search NOT: ArrayList("+time_arr+"ms), LinkedList("+time_linked+"ms), TreeMap("+time_tree+"ms), HashMap("+time_hash+"ms)");

arr_it=arr.iterator();
list_it=list.iterator();
double time_it, time_for=0, time_each=0;

//pomiary czasu dostępu do elementów dla arraylist przez:
//iterator
  start = System.nanoTime();
    while(arr_it.hasNext()) arr_it.next();
  time_it = (System.nanoTime() - start)*Math.pow(10,-6);
//pętla for + metoda get
  start = System.nanoTime();
  for(int j=0;j<n;j++) arr.get(j);
  time_for = (System.nanoTime() - start)*Math.pow(10,-6);
//pętla for each
  start = System.nanoTime();
  for (String el : arr) 
  time_each = (System.nanoTime() - start)*Math.pow(10,-6);

  System.out.println("java.util.ArrayList: for("+time_for+"ms), for-each("+time_each+"ms), iterator("+time_it+"ms)");
  
//pomiary czasu dostępu do elementów dla Linkedlist przez:
//iterator
  start = System.nanoTime();
    while(list_it.hasNext()) list_it.next();
  time_it = (System.nanoTime() - start)*Math.pow(10,-6);
//pętla for + metoda get
  start = System.nanoTime();
  for(int j=0;j<n;j++) list.get(j);
  time_for = (System.nanoTime() - start)*Math.pow(10,-6);
//pętla for each
  start = System.nanoTime();
  for (String el : list) 
  time_each = (System.nanoTime() - start)*Math.pow(10,-6);

  System.out.println("java.util.LinkedList: for("+time_for+"ms), for-each("+time_each+"ms), iterator("+time_it+"ms)");

//pomiar czasu usunięcia całej kolekcji
  start = System.nanoTime();
  arr.clear();
  time_arr = (System.nanoTime() - start)*Math.pow(10,-6);

  start = System.nanoTime();
  list.clear();
  time_linked = (System.nanoTime() - start)*Math.pow(10,-6);
  
  start = System.nanoTime();
  tmap.clear();
   time_tree = (System.nanoTime() - start)*Math.pow(10,-6);

  start = System.nanoTime();
  hmap.clear();
  time_hash = (System.nanoTime() - start)*Math.pow(10,-6);

  System.out.println("Remove: ArrayList("+time_arr+"ms), LinkedList("+time_linked+"ms), TreeMap("+time_tree+"ms), HashMap("+time_hash+"ms)");
//końcowe rozmiary kolekcji
   System.out.println("Koniec: rozmiary:"+arr.size()+" "+list.size()+" "+tmap.size()+" "+hmap.size());
  }

}