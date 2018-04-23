import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.*;

public class JdbcDerbyConnection {

    public static void main(String[] args) {
         String c[]={"Tom","Dick","Harry","Blah","Bleh"};
		 int b[]={1,2,3,4,5};
        try {
            // connect method #1 - embedded driver
            String dbURL1 = "jdbc:derby:dummy/student1;create=true";
            Connection conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                System.out.println("Connected to database #1");
            }
			Statement a=conn1.createStatement();
      //Add next statement if the table is not created
			//a.executeUpdate("create table student(name varchar(20),age integer)");
      PreparedStatement d;
      for(int i=0;i<5;i++){
			     d=conn1.prepareStatement("insert into student values(?,?)");
			     d.setString(1,c[i]);
			     d.setInt(2,b[i]);
			     d.executeUpdate();
      }
			ResultSet rs=a.executeQuery("select * from student");
            while(rs.next())
			{
				System.out.println(rs.getString("name")+"\t"+rs.getInt("age"));
			}
            // connect method #2 - network client driver
            String dbURL2 = "jdbc:derby:dummy/student2;create=true";
            String user = "username";
            String password = "password";
            Connection conn2 = DriverManager.getConnection(dbURL2, user, password);
            if (conn2 != null) {
                System.out.println("Connected to database #2");
            }

            // connect method #3 - network client driver
            String dbURL3 = "jdbc:derby:dummy/student3";
            Properties properties = new Properties();
            properties.put("create", "true");
            properties.put("user", "username");
            properties.put("password", "secret");

            Connection conn3 = DriverManager.getConnection(dbURL3, properties);
            if (conn3 != null) {
                System.out.println("Connected to database #3");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
