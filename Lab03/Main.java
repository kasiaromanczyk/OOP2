class Main {
  
  public static void main(String[] args) {

    System.out.println("Test klasy complex:");
    Complex x = new Complex();
    x.test();

    double a,b,c;
    System.out.println("Rozwiazanie rownania kwadratowego, wspolczynniki:");
    a=Double.parseDouble(args[0]);
    b=Double.parseDouble(args[1]);
    c=Double.parseDouble(args[2]);

  System.out.println("a="+a+", b="+b+", c="+c);

  double del=b*b - 4*a*c;
  System.out.println(del);

  Complex sqrt_d= Complex.sqrt(del);
  System.out.println(sqrt_d);
  
  Complex bb=new Complex(-b);
  Complex aa=new Complex(2*a);

  Complex x1=Complex.divide((Complex.subtract(bb,sqrt_d)),aa);
  Complex x2=Complex.divide((Complex.add(bb,sqrt_d)),aa);
  System.out.println("x1= "+x1+"\nx2= "+x2);
  }
}
