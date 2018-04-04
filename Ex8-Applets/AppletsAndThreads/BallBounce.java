import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*<applet code="BallBounce" width=600 height = 600></applet>*/
public class BallBounce extends Applet implements Runnable,MouseListener{
  int y,x;
  Thread t;
  boolean insideFlag=false,bounceFlagTB,bounceFlagLR;
  public void init(){
    y=0;
    x=0;
    showStatus("BallBounce Initialised");
    addMouseListener(this);
  }
  public void run(){
    while(insideFlag){
      if(bounceFlagTB==false)
        y+=5;
      else{
        y-=5;
      }
      if(bounceFlagLR==false){
        x+=5;
      }
      else{
        x-=5;
      }
      repaint();
      try{
        t.sleep(50);
      }
      catch(Exception e){}
      if(y==250)
        bounceFlagTB=true;
      if(300+y==0)
        bounceFlagTB=false;
      if(x==550)
        bounceFlagLR=true;
      if(x==0)
        bounceFlagLR=false;
    }
  }

  public void start(){}

  public void mousePressed(MouseEvent me){}

  public void mouseReleased(MouseEvent me){}

  public void mouseClicked(MouseEvent me){}
  public void mouseEntered(MouseEvent me){
    insideFlag=true;
    t=new Thread(this);
    bounceFlagLR=false;
    bounceFlagTB=false;
    t.start();
  }
  public void mouseExited(MouseEvent me){
    insideFlag=false;
    t=null;
  }
  public void paint(Graphics g){
    g.setColor(Color.red);
    g.fillOval(0+x,300+y,50,50);
  }
}
