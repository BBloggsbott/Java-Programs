import java.util.Scanner;
class Queue{
  int[] arr;
  int front,rear;
  boolean full,empty;
  Scanner s = new Scanner(System.in);
  Queue(int n){
    arr=new int[n];
    front=rear=-1;
    full=false;
    empty=true;
  }
  void put() throws Exception{
    while(true){
      synchronized(this){
//Producer waits if list is full
        while(full==true)
          wait();
        System.out.println("Enter value to produce: ");
        int n=s.nextInt();
        if(empty==true){
          front=front+1;
          rear=rear+1;
          arr[rear]=n;
          empty=false;
          if(rear==arr.length-1){
            full=true;
          }
        }
        else{
          rear=rear+1;
          arr[rear]=n;
          if(rear==arr.length-1){
            full=true;
          }
        }
        System.out.println("Produced: "+arr[rear]);
        notify();
        Thread.sleep(1000);
      }
    }
  }
  void get() throws Exception{
    while(true){
      synchronized(this){
        while(empty==true)
          wait();

        if((front==0)&&(rear==0)){
          front=rear=-1;
          empty=true;
          System.out.println("Consumed: "+arr[rear+1]);
        }
        else{
          int n=arr[front];
          for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
          }
          rear=rear-1;
          System.out.println("Consumed: "+n);
        }
        notify();
        Thread.sleep(1000);
      }
    }
  }
}
