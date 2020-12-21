//klasa reprezentuje liczbę zespoloną oraz
//umozliwia wykonywanie działań na liczbach zespolonych
class Complex{

  private double re; 
  private double im;

  static String  I = "1.0i";
  static String ZERO = "0.0";
  static double ONE = 1.0;

  Complex(){
    this(0,0);
  }

  Complex(double a){
    this(a,0);
  }

  Complex(double a, double b){
    re=a;
    im=b;
  }

  public String toString(){
    if (re==0 && im==0) return ZERO;
    if (re==0) return im+"i";
    if (im==0) return re+" ";
    return re+" + "+im+"i";
  }

  public double getRe(){return re;}
  public double getIm(){return im;}

  static Complex add(Complex c1, Complex c2){
  
    return new Complex(c1.re + c2.re , c1.im + c2.im);
    }

  static Complex subtract(Complex c1, Complex c2){
    
    return new Complex(c1.re - c2.re , c1.im - c2.im);
    }

  static Complex multiply(Complex c1, Complex c2){
    Complex result=new Complex();
    result.re = c1.re * c2.re - c1.im * c2.im;
    result.im = c1.re * c2.im + c1.im * c2.re;
    return result;
    }

  static Complex multiply(Complex c1, double d){
   
    return new Complex( c1.re * d, c1.im * d);
    }

  static Complex divide(Complex c1, Complex c2){
    Complex result=new Complex();
    result.re = (c1.re * c2.re + c1.im * c2.im)/(c2.re*c2.re + c2.im*c2.im);
    result.im = (c1.im * c2.re - c1.re * c2.im)/(c2.re*c2.re + c2.im*c2.im);
    return result;
    }

    double mod(){
      return Math.sqrt(re*re+im*im);
    }

 public static Complex sqrt(double d){
    Complex result=new Complex();
    if(d<0) { result.im = Math.sqrt(-d);}
    else result.re = Math.sqrt(d);
    return result;
    }

 public boolean equals(Complex c1){

    if(re == c1.re && im==c1.im) return true;
    return false;
  }

  void conjugate(){im=-im;}

  void opposite(){
    re=-re;
    im=-im;
    }

   public void test() {
    
        // Wykorzystanie konstruktorów:
        Complex c1 = new Complex(2.5, 13.1);
        Complex c2 = new Complex(-8.5, -0.9);
        System.out.println(c1); // 2.5 + 13.1i
        System.out.println(c2); // -8.5 - 0.9i
        System.out.println(new Complex(4.5)); // 4.5
        System.out.println(new Complex()); // 0.0
        System.out.println(new Complex(0, 5.1)); // 5.1i
        System.out.println();

        // Stałe typu Complex:
        System.out.println(Complex.I); // 1.0i
        System.out.println(Complex.ZERO); // 0.0
        System.out.println(Complex.ONE); // 1.0
        System.out.println();

        // Wykorzystanie metod zwracających wynik obliczeń:
        System.out.println("Re(c1) = " + c1.getRe()); // Re(c1) = 2.5
        System.out.println("Im(c1) = " + c1.getIm()); // Im(c1) = 13.1
        System.out.println("c1 + c2 = " + Complex.add(c1, c2)); // c1 + c2 = -6.0 + 12.2i
        System.out.println("c1 - c2 = " + Complex.subtract(c1, c2)); // c1 - c2 = 11.0 + 14.0i
        System.out.println("c1 * c2 = " + Complex.multiply(c1, c2)); // c1 * c2 = -9.46 - 113.6i
        System.out.println("c1 * 15.1 = " + Complex.multiply(c1, 15.1)); // c1 * 15.1 = 37.75 + 197.81i
        System.out.println("c1 / c2 = " + Complex.divide(c1, c2)); // c1 / c2 = -0.4522310429783739 - 1.4932931836846426i
        System.out.println("|c1| = " + c1.mod()); // |c1| = 13.336416310238668
        System.out.println("sqrt(243.36) = " + Complex.sqrt(243.36)); // sqrt(243.36) = 15.6
        System.out.println("sqrt(-243.36) = " + Complex.sqrt(-243.36)); // sqrt(-243.36) = 15.6i
        Complex c3 = new Complex(2.5, 13.1);
        System.out.println(c1.equals(c2)); // false
        System.out.println(c1.equals(c3)); // true
    
        System.out.println(c1.equals("test ze zlym obiektem")); // false
        System.out.println();

        // Metoda zamieniająca liczbę na jej sprzężenie:
        c1.conjugate();
        System.out.println("c1* = " + c1); // c1* = 2.5 - 13.1i

        // Metoda zamieniająca liczbę na przeciwną:
        c1.opposite();
        System.out.println("-c1 = " + c1); // -c1 = -2.5 + 13.1i
    }
}