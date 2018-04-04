import java.util.Scanner;
class ProdCons{
  public static void main(String[] args) throws InterruptedException{
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the size of queue: ");
    int n=s.nextInt();
    Queue q = new Queue(n);
    Thread producer=new Thread(new Runnable(){
      public void run(){
        try{
          q.put();
        }
        catch(Exception e){
          System.out.println(e);
        }
      }
    });
    Thread consumer=new Thread(new Runnable(){
      public void run(){
        try{
          q.get();
        }
        catch(Exception e){
          System.out.println(e);
        }
      }
    });
    producer.start();
    consumer.start();

    producer.join();
    consumer.join();
  }
}
