class WallException extends Exception{

  String s = new String();
  
  WallException(String s){
    this.s=s;
  }

  public String toString(){
    return s;
  }
}