class MultiplicationTable implements Runnable{
  int n;
  Thread tables;
  MultiplicationTable(int num){
    n=num;
    tables=new Thread(this,"Multiplication Table");
    tables.start();
  }
  public void run(){
    try{
      for(int i=1;i<=n;i++){
        System.out.println(n+"*"+Integer.toString(i)+"="+Integer.toString(n*i));
        tables.sleep(50);
      }
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}
