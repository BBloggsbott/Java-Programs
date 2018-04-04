import java.awt.*;
import java.awt.event.*;  
import java.util.*;
import java.lang.*;
import java.applet.*;
/*<applet code="WaterTank" width=600 height=600></applet>*/
public class WaterTank extends Applet implements Runnable,ActionListener
{
    Button b1,b2,b3,b4;
	boolean stopflag=false,suspendflag=false;Thread t;int x=0;
	public void init()
	{   setForeground(Color.black);
		b1=new Button("start");
		b2=new Button("stop");
		b3=new Button("suspend");
		b4=new Button("resume");x=0;
		add(b1);add(b2);add(b3);add(b4);
	    b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);//t=null;
		showStatus("tank started");
	}	
	
	public void start(){}
	public void run()
	{  
		while(!stopflag)
		{
			
						
				  if(suspendflag==true)
				  {try{
					t.wait();
				   }
				   catch(Exception e){}
				  }
			      else
				  { if(x<200)
				    {repaint();
			         x++;
					try{ t.sleep(200);}catch(InterruptedException e){}
				    }
				    else
				    { x=0;     showStatus("tank is filled and refilling");} 
				  }
		}
				
			
		
	}
		
	public void actionPerformed(ActionEvent ae)
	{       if(ae.getSource()==b1)
		    {t=new Thread(this);
		     stopflag=false;suspendflag=false;     showStatus("tank has started");x=0;
			 t.start();
			}
			if(ae.getSource()==b2)
			{   
				t=null;stopflag=true;
				x=0;     showStatus("tank is stopped");
		        repaint(); 	
		    }
			if(ae.getSource()==b3)
			{
				if(suspendflag==false)
				{   suspendflag=true;     
			        try{showStatus("tank is suspended"); wait();}catch(InterruptedException e){}
				
				}
			}
			if(ae.getSource()==b4)
			{
				if(suspendflag==true)
                { suspendflag=false;  showStatus("tank is resumed"); notify();    }
            }			
					
                			
	}
	public void paint(Graphics g)
	{ g.setColor(Color.black);
	  g.drawLine(200,400,400,400);
      g.drawLine(200,200,200,400);
      g.drawLine(400,200,400,400);
	  g.setColor(Color.blue);
      g.fillRect(200,400-x,200,x)	;  
	}

}




