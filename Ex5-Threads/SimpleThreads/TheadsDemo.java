class ThreadsDemo{
  public static void main(String[] args) {
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    Factorial f=new Factorial(10);
    SumofSeries s=new SumofSeries(5);
    try{
      s.suspend();
    }
    catch(Exception e){
      System.out.println(e);
    }
    MultiplicationTable mt=new MultiplicationTable(9);
    try{
      s.resume();
    }
    catch(Exception e){
      System.out.println(e);
    }
    System.out.println("Main Thread Priority: "+Thread.currentThread().getPriority());
  }
}
