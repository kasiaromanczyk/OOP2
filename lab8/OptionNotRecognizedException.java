class OptionNotRecognizedException extends Exception{

  String s = new String();

  OptionNotRecognizedException(String s){
    this.s=s;
  }

  public String toString(){
    return s;
  }


}