import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
* <h1>Survey Form</h1>
* The SurveyForm program implements an application that
* generates a Survey Form to get details from the user
* and store them in a Database.
* <p>
*<b>Note:</b> Set Classpath to the Derby Drivers before Compilation
* @author  Vishal R
* @version 1.0
*/

public class SurveyForm extends Frame implements ActionListener,TextListener{
    Button next1,next2,submit;
    TextField nameText,qualificationText,nativeText,errorText,incomeText,taxText,errorText3;
    Label nameLabel,nativeLabel,dobLabel,mtLabel,citizenLabel,qualificationLabel,martialLabel,incomeLabel,taxLabel;
    Choice dd,mm,yy,mt,citizenship,martial;
    Panel p1,p2,p3;
    CardLayout card;
    boolean saveFlag = false;
    Connection conn;
    
    /**This is a Constructor for the SurveyForm class
     * It initializes and adds elements to the frame.
     * It has Three panels to act as three pages of the form.
     * The other elements are added to the corresponding pages.
     * @return Nothing.
     */
  
    SurveyForm(){
      card = new CardLayout();
      setLayout(card);
      setSize(300,320);
  
  
      next1 = new Button("Next");
      nameLabel = new Label("Name");
      dobLabel = new Label("DOB");
      mtLabel = new Label("Moter Tongue");
      nativeLabel = new Label("Native");
      nameText = new TextField();
      nativeText = new TextField();
      dd = new Choice();
      mm = new Choice();
      yy = new Choice();
      for(int i=1;i<32;i++){
        dd.add(Integer.toString(i));
      }
      for(int i=1;i<13;i++){
        mm.add(Integer.toString(i));
      }
      for(int i=1980;i<2019;i++){
        yy.add(Integer.toString(i));
      }
      mtLabel = new Label("Mother Tongue");
      mt = new Choice();
        mt.add("Tamil");
        mt.add("Telugu");
        mt.add("Malayalam");
      nativeLabel = new Label("Native");
      nativeText = new TextField();
      errorText = new TextField();
      errorText.setEditable(false);
      p1 = new Panel();
  
      nameLabel.setBounds(30,70,90,20);
      nameText.setBounds(135,70,90,20);
      dobLabel.setBounds(30,100,90,20);
      dd.setBounds(135,100,50,20);
      mm.setBounds(195,100,50,20);
      yy.setBounds(255,100,40,20);
      mtLabel.setBounds(30,130,100,20);
      mt.setBounds(135,130,90,20);
      nativeLabel.setBounds(30,160,90,20);
      nativeText.setBounds(135,160,90,20);
      errorText.setBounds(30,190,150,20);
      next1.setBounds(180,190,40,20);
  
  
  
      p1.setLayout(null);
      p1.add(nameLabel);
      p1.add(nameText);
      p1.add(dobLabel);
      p1.add(dd);
      p1.add(mm);
      p1.add(yy);
      p1.add(mtLabel);
      p1.add(mt);
      p1.add(nativeLabel);
      p1.add(nativeText);
      p1.add(errorText);
      p1.add(next1);
  
      next1.addActionListener(this);
  
      add("Page1",p1);
  //------------------------------------------------------------------------------
      //Page 2
      p2 = new Panel();
      citizenLabel = new Label("Citizenship");
      qualificationLabel = new Label("Qualificaton");
      qualificationText = new TextField();
      martialLabel = new Label("Martial Status");
      citizenship = new Choice();
        citizenship.add("Indian");
        citizenship.add("Other");
      martial = new Choice();
        martial.add("Yes");
        martial.add("No");
      next2 = new Button("Next");
  
      citizenLabel.setBounds(30,70,90,20);
      citizenship.setBounds(135,70,80,20);
      qualificationLabel.setBounds(30,100,90,20);
      qualificationText.setBounds(135,100,90,20);
      martialLabel.setBounds(30,130,90,20);
      martial.setBounds(135,130,50,20);
      next2.setBounds(180,190,40,20);
  
      p2.setLayout(null);
      p2.add(citizenLabel);
      p2.add(citizenship);
      p2.add(qualificationLabel);
      p2.add(qualificationText);
      p2.add(martialLabel);
      p2.add(martial);
      p2.add(next2);
  
      next2.addActionListener(this);
  
      add("Page2",p2);
  
  //------------------------------------------------------------------------------
      //Page 3
      p3 = new Panel();
  
      incomeLabel = new Label("Annual Income");
      taxLabel = new Label("Tax");
      incomeText = new TextField();
      taxText = new TextField("0");
      taxText.setEditable(false);
      submit = new Button("Submit");
      errorText3 = new TextField("Wait after Submit");
  
      incomeLabel.setBounds(30,70,90,20);
      incomeText.setBounds(135,70,90,20);
      taxLabel.setBounds(30,100,90,20);
      taxText.setBounds(135,100,90,20);
      submit.setBounds(180,190,90,20);
      errorText3.setBounds(30,190,150,20);
  
      p3.setLayout(null);
      p3.add(incomeLabel);
      p3.add(incomeText);
      p3.add(taxLabel);
      p3.add(taxText);
      p3.add(submit);
      p3.add(errorText3);
  
      add("Page3",p3);
  
      submit.addActionListener(this);
      incomeText.addTextListener(this);
  
      setVisible(true);
  
  
    }
  
    /**This function is the event handler.
     * It Handles the events thrown by the next, and the submit buttons
     * It has an Internal SQLException Handler
     * @see SQLException
     * @param ae Used to identify the source of the Action Event
     */
  
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==next1){
        if(nameText.getText().isEmpty())
          errorText.setText("Enter a Valid Name");
        else
          card.next(this);
      }
      else if(ae.getSource()==next2){
        card.next(this);
      }
      else if(ae.getSource()==submit){
        if((2018-Integer.parseInt(yy.getSelectedItem()))<18){
          errorText3.setText("Must be 18 or older");
        }
        else{
          errorText3.setText("Please Wait");
          try{
            String url = "jdbc:derby:summy/surveyDB;create=true";
            conn = DriverManager.getConnection(url);
            errorText3.setText("Connected to DB");
            Statement s = conn.createStatement();
            //Include the next line if you aare runnin this code for the first time
            //s.executeUpdate("create table survey(Name varchar(20),Native varchar(10),DOB varchar(10),MotherTongue varchar(15),Citizenship varchar(20),Qualification varchar(7),Martial varchar(5),Income double, Tax double)");
            PreparedStatement ps = conn.prepareStatement("insert into survey values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1,nameText.getText());
            ps.setString(2,nativeText.getText());
            ps.setString(3,dd.getSelectedItem()+"/"+mm.getSelectedItem()+"/"+yy.getSelectedItem());
            ps.setString(4,mt.getSelectedItem());
            ps.setString(5,citizenship.getSelectedItem());
            ps.setString(6,qualificationText.getText());
            ps.setString(7,martial.getSelectedItem());
            ps.setString(8,incomeText.getText());
            ps.setString(9,taxText.getText());
            int i=ps.executeUpdate();
            if(i>0){
              errorText3.setText("Data Saved");
              saveFlag = true;
            }
            else
              errorText3.setText("Save failed. Try Again");
          }
          catch(SQLException se){ System.out.println(se);}
          if(!saveFlag)
            errorText3.setText("Save Failed. Try Again");
  
          try{
              Statement selector = conn.createStatement();
              ResultSet rs = selector.executeQuery("select * from survey");
              while(rs.next()){
                System.out.println("Name: "+rs.getString("Name"));
                System.out.println("Native: "+rs.getString("Native"));
                System.out.println("DOB: "+rs.getString("DOB"));
                System.out.println("Mother Tongue: "+rs.getString("MotherTongue"));
                System.out.println("Citizenship: "+rs.getString("Citizenship"));
                System.out.println("Qualification: "+rs.getString("Qualification"));
                System.out.println("Martial: "+rs.getString("Martial"));
                System.out.println("Income: "+rs.getDouble("Income"));
                System.out.println("Tax: "+rs.getDouble("Tax"));
                System.out.println("\n\n\n");
              }
          }
          catch(Exception e){System.out.println(e);}
        }
      }
    }
  
    /**This function is the event handler for text valuse changes.
     * It handles the Text Valuse Changes in Income Text Field
     * @param te Used to identify the source of the Text Value Change
     */
  
    public void textValueChanged(TextEvent te){
      if(te.getSource()==incomeText){
        int income;
        double tax;
        income=Integer.parseInt(incomeText.getText());
        if(income>500000){
          tax=125000+(0.2*income);
          taxText.setText(Double.toString(tax));
        }
        else{
          taxText.setText("0");
        }
      }
    }
  
  }