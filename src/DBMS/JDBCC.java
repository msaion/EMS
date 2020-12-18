package DBMS;
import java.sql.*;
import java.util.Scanner;
public class JDBCC {
    public static void main (String [] args) throws ClassNotFoundException, SQLException{
        System.out.println("---------- Employee Management System ----------");
        Scanner input=new Scanner(System.in);
        int num;
        System.out.println("Press 1 to show all employee information");
        System.out.println("Press 2 to add new employee information");
        System.out.println("Press 3 to update employee information");
        System.out.println("Press 4 to delete employee information");
        num = input.nextInt();
        Class.forName("com.mysql.jdbc.Driver");
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/employee?serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement statement = conn.createStatement();
        if(num==1){
        String query = "SELECT * FROM einfo";
        ResultSet result = statement.executeQuery(query);
        while(result.next()){
            String Name,ID,Shift,Salary;
            Name = result.getString("Name");
            ID = result.getString("ID");
            Shift = result.getString("Shift");
            Salary = result.getString("Salary");
            System.out.println(Name+" "+ID+" "+Shift+" "+Salary);
        } }
        if(num==2){
            String query = "INSERT INTO `einfo`(`Name`, `ID`, `Shift`, `Salary`) VALUES ('Maharib','1921513306','Night','60000')";
            statement.executeUpdate(query);
        }
        if(num==3){
            String query = "UPDATE `einfo` SET `Name`=\"Mahin\" WHERE ID='1921513306'";
            statement.executeUpdate(query);
        }
        if(num==4){
            String query = "DELETE FROM `einfo` WHERE ID='1921513306' ";
            statement.executeUpdate(query);
        }
        statement.close();
        conn.close();
    }
}
/*
##### Project ----- Basic Employee Management System #####
*/
*/
