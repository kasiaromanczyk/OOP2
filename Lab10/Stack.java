import java.lang.StackOverflowError;
import java.util.EmptyStackException;
import java.util.Arrays;


//klasa Stack reprezentuje stos obiektów dowonego typu
class Stack<T>{
  T [] tab;
  int size;
  int max_size;

  Stack(int max) {
        @SuppressWarnings("unchecked")
        final T[] tab = (T[]) new Object[max];
        this.tab = tab;
        max_size=max;
        size = 0;
    }

   public boolean isEmpty(){
     if(size==0) return true;
     return false;
   }

   public boolean isFull(){
     if(size==max_size) return true;
     return false;
   }

   public void push(T x) throws StackOverflowError{
     try{
       if(size>=max_size) throw new StackOverflowError("Stos pełny!");
       tab[size]=x;
        size++;
     }catch(StackOverflowError e)
     {
       System.out.println(e);
     }
   }

   public T pop() throws EmptyStackException{
     @SuppressWarnings("unchecked")
     T temp = (T) new Object();
     try{
       if(size==0) throw new EmptyStackException();
        temp=tab[size-1];
        tab[size-1]=null;
        size--;
        }catch(EmptyStackException e)
     {
       System.out.println("BLAD DANYCH WEJSCIOWYCH! Na stosie jest za molo elementow, aby wykonac operacje");
       temp=null;
     }
     return temp;
   }

   public String toString(){
     String result = new String();
     int i=0;
     while(tab[i]!=null){
       result +=tab[i].toString()+", ";
       i++;
     }
     return result;
   }
}

