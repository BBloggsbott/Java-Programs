class SumofSeries implements Runnable{
  Thread Sum;
  int sum,n;
  boolean suspended=false;
  SumofSeries(int num){
    sum=0;
    n=num;
    Sum=new Thread(this,"Sum of Series");
    Sum.start();
  }
  public void run(){
    try{
      for(int i=n;i>0;i--){
        sum=sum+i;
        System.out.println("Sum of Series Step "+Integer.toString(n-i+1)+" Done!");
        synchronized(this){while(suspended){ wait(); }}
      }
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
  void suspend(){
    suspended=true;
  }
  synchronized void resume(){
    suspended=false;
	notify();
  }
}
