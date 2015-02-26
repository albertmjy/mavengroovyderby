package albert;


import java.lang.ClassNotFoundException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection con=null;
        String port=null;
        String ip=null;
        try {
            con = DriverManager.getConnection("jdbc:derby:MyDB;create=true");
            Statement s = con.createStatement();
            /*s.execute("create table MyTable(" +
                    "id char(6)," +
                    "name varchar(40)," +
                    "score int)");*/
            s.execute("insert into MyTable values('016954', 'San ZHANG', 86)");
            s.execute("insert into MyTable values('016934', 'Wu WANG', 45)");

            java.sql.ResultSet rs = s.executeQuery("Select * from MyTable");
            while (rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
