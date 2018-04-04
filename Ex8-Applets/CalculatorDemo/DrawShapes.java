import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*<applet code = "DrawShapes" width = 800 height = 400> </applet>*/

public class DrawShapes extends Applet implements ActionListener,ItemListener,TextListener{
	CheckboxGroup shapes = new CheckboxGroup();
	Checkbox circle = new Checkbox("Circle",true,shapes);
	Checkbox arc = new Checkbox("Arc", false,shapes);
	Checkbox rectangle = new Checkbox("Rectangle",false,shapes);
	TextField radius = new TextField();
	Label radiusLabel = new Label("Radius");
	TextField length = new TextField();
	Label lengthLabel = new Label("Length");
	TextField breadth = new TextField();
	Label breadthLabel = new Label("Breadth");
	Button draw = new Button("Draw");
	public void init(){
		add(circle);
		add(arc);
		add(rectangle);
		add(radiusLabel);
		add(radius);
		add(lengthLabel);
		add(length);
		add(breadthLabel);
		add(breadth);
		add(draw);
		circle.addItemListener(this);
		arc.addItemListener(this);
		rectangle.addItemListener(this);
		radius.addTextListener(this);
		length.addTextListener(this);
		breadth.addTextListener(this);
		draw.addActionListener(this);
	}
	
	public void itemStateChanged(ItemEvent ie){
		if(ie.getSource()==circle){
			showStatus("Circle Checkbox: Checked");
		}
		else if(ie.getSource()==arc){
			showStatus("Arc Checkbox: Checked");
		}
		else if(ie.getSource()==rectangle){
			showStatus("Rectangle Checkbox: Checked");
		}
	}
	public void textValueChanged(TextEvent te){
		if(te.getSource()==radius){
			showStatus("Radius Modified");
		}
		else if(te.getSource()==length){
			showStatus("Length Modified");
		}
		else if(te.getSource()==breadth){
			showStatus("Breadth Modified");
		}
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==draw){
			showStatus("Draw Clicked");
			if(circle.getState()){
				int r=Integer.parseInt(radius.getText());
				//Graphics.drawArc(400,110,r,r,0,360);
			}
		}
	}
}