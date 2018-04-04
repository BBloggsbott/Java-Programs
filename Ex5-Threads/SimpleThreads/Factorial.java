class Factorial implements Runnable{
  Thread fact;
  int factorial,num;
  Factorial(int n){
    factorial=1;
    num=n;
    fact=new Thread(this,"Factorial");
    fact.start();
  }
  public void run(){
    try{
      for(int i=num;i>0;i--){
        factorial=factorial*i;
        System.out.println("Factorial Step "+Integer.toString(num-i+1)+" Done!");
        fact.sleep(50);
      }
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
  public String toString(){
    return Integer.toString(factorial);
  }
}
