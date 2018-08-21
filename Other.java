import java.sql.*;

public class Other {
    protected  void room() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","root");
        Statement statement=con.createStatement();
        ResultSet resultSet=statement.executeQuery("select Room_no from dbms.Patient");
        System.out.println("Rooms occupied are:");
        while (resultSet.next())
        {
            int room =resultSet.getInt(1);
            System.out.println(room);
        }
    }}
Patient.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
public class Patient {
    String name,doctor,nurses,management_staff,address,occ,find_name,mobile_no,disease;
    int age,room;
    Scanner in = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public void get_patient() throws IOException, ClassNotFoundException, SQLException {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","root");


            PreparedStatement preparedStatement=con.prepareStatement("insert into dbms.Patient values(?,?,?,?,?,?,?)");
            System.out.println("Enter name");
            name=in.nextLine();
            System.out.println("Enter address of patient:");
            address = in.nextLine();
            System.out.println("Enter the occupation of the patient:");
            occ = in.nextLine();
            System.out.println("Enter mobile number");
            mobile_no=in.nextLine();
            System.out.println("Enter Disease:");
            disease = in.nextLine();
            System.out.println("Enter age of patient:");
            age =in.nextInt();
            System.out.println("Enter room number");
            room = in.nextInt();
            preparedStatement.setInt(1,room);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,mobile_no);
            preparedStatement.setInt(5,age);
            preparedStatement.setString(6,occ);
            preparedStatement.setString(7,disease);
            preparedStatement.executeUpdate();
            con.close();
        }

    public void put_patient() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","root");
        Statement statement=con.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from dbms.Patient");
        System.out.println("Room No\tPatient Name\tAddress\t\tMobile No\t\tAge\tOccupation\tDisease");
        while (resultSet.next()) {
                  Integer room = resultSet.getInt(1);
            String patient_name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String mobile_no = resultSet.getString(4);
            int age = resultSet.getInt(5);
            String occupation = resultSet.getString(6);
            String disease = resultSet.getString(7);
            System.out.println(room+"\t\t"+patient_name+"\t\t\t"+address+"\t\t"+mobile_no+"\t\t"+age+"\t\t"+occupation+"\t\t"+disease);
        }
        con.close();
    }
    public void search() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","root");
        System.out.println("Enter patient name:");
        String name=in.nextLine();
        PreparedStatement preparedStatement=con.prepareStatement("select * from dbms.Patient where Patient_name=?");
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        System.out.println("Room No\tPatient Name\tAddress\t\tMobile No\t\tAge\tOccupation\tDisease");    
              Integer room = resultSet.getInt(1);
            String patient_name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String mobile_no = resultSet.getString(4);
            int age = resultSet.getInt(5);
            String occupation = resultSet.getString(6);
            String disease = resultSet.getString(7);           System.out.println(room+"\t\t"+patient_name+"\t\t\t"+address+"\t\t"+mobile_no+"\t\t"+age+"\t\t"+occupation+"\t\t"+disease);
        }
        con.close();
}}
