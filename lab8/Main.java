import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;


class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int nx = Integer.valueOf(0);
    char c;
    int a=Integer.valueOf(0),b=Integer.valueOf(0);//aktualna pozycja gracza na planszy
    boolean right=false;


     while(right==false){
        System.out.println("Podaj liczbe calkowita wieksza od 1:");
        try {
            nx = sc.nextInt();
            if(nx<2)throw new IllegalArgumentException();
            right=true;
        } catch (InputMismatchException e) {
            System.out.println("BLAD: Podaj liczbe calkowita!");
            sc.nextLine();
        } catch (IllegalArgumentException e) {
         System.out.println("BLAD: Zbyt mala wartosc nx: "+nx);
         sc.nextLine();
      }
     }
     
    char [][] board  = new char [nx][nx];

    Random rand = new Random();

    for(int i=0; i<nx; i++){
        for(int j=0;j<nx;j++){
            if (rand.nextDouble()<=0.3) board[i][j]='X';
            else if(right==true){
                board[i][j]='o';
                right=false;
                a=i;b=j;
            }
            else board[i][j]=' ';
        }
    }


    while(right==false){
        printBoard(board, nx);
        try {
            c = sc.next().charAt(0);
             if(c=='a'){
                 if((b-1)<0) throw new ArrayIndexOutOfBoundsException();
                 else if(board[a][b-1]=='X')throw new WallException("Uwaga sciana!");
                 else {
                     board[a][b-1]='o';
                     board[a][b]=' ';
                     b--;
                 }
             }
             else if(c=='d'){
                 if((b+1)>=nx) throw new ArrayIndexOutOfBoundsException();
                 else if(board[a][b+1]=='X')throw new WallException("Uwaga sciana!");
                 else {
                     board[a][b+1]='o';
                     board[a][b]=' ';
                     b++;
                 }
             }
             else if(c=='s'){
                 if((a+1)>=nx) throw new ArrayIndexOutOfBoundsException();
                 else if(board[a+1][b]=='X')throw new WallException("Uwaga sciana!");
                 else {
                     board[a+1][b]='o';
                     board[a][b]=' ';
                     a++;
                 }
             }
             else if(c=='w'){
                 if((a-1)<0) throw new ArrayIndexOutOfBoundsException();
                 else if(board[a-1][b]=='X')throw new WallException("Uwaga sciana!");
                 else {
                     board[a-1][b]='o';
                     board[a][b]=' ';
                     a--;
                 }
             }
            else if(c=='q'){
                right=true;
                System.out.println("Goodbye!");
            }
            else throw new OptionNotRecognizedException("Nie rozpoznano znaku");
        } catch (WallException e1) {
            System.out.println(e1);
            sc.nextLine();
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Proba wyjscia poza plansze!");
            sc.nextLine();
        } catch (OptionNotRecognizedException e1) {
         System.out.println(e1);
         sc.nextLine();
    }
    }
    sc.close();
  }


    public static void printBoard(char[][] board, int nx){
        for(int i=0; i<nx; i++){
            for(int j=0;j<nx;j++){
            System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
}