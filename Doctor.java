import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Doctor {
    Scanner in =new Scanner(System.in);
	public void doctor() throws ClassNotFoundException, SQLException {
        		Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","root");
        PreparedStatement preparedStatement=con.prepareStatement("select * from dbms.Doctor where Specialist=?");
        ResultSet resultSet;
        String doctor;
        System.out.println("1)Cardiologist");
        System.out.println("2)Critical care medicine specialists");
        System.out.println("3)Dermatologist");
        System.out.println("4)Audiologist");
        System.out.println("5)Dentist");
        System.out.println("6)ENT Specialist");
        System.out.println("Enter choice:");
        int choice =in.nextInt();
        switch(choice)
        {
            case 1:
                preparedStatement.setString(1,"cardiologist");
                resultSet=preparedStatement.executeQuery();
                System.out.println("Doctors:");
                while (resultSet.next())
                {
                    doctor=resultSet.getString(1);
                    System.out.println(doctor);
                }
                break;
            case 2:
                preparedStatement.setString(1,"critical");
                resultSet=preparedStatement.executeQuery();
                System.out.println("Doctors:");
                while (resultSet.next())
                {
                    doctor=resultSet.getString(1);
                    System.out.println(doctor);
                }
                break;
            case 3:
                preparedStatement.setString(1,"dermato");
                resultSet=preparedStatement.executeQuery();
                System.out.println("Doctors:");
                while (resultSet.next())
                {
                    doctor=resultSet.getString(1);
                    System.out.println(doctor);
                }
                break;
            case 4:
                preparedStatement.setString(1,"audio");
                resultSet=preparedStatement.executeQuery();
                System.out.println("Doctors:");
                while (resultSet.next())
                {
                    doctor=resultSet.getString(1);
                    System.out.println(doctor);
                }
                break;
            case 5:
                preparedStatement.setString(1,"dentist");
                resultSet=preparedStatement.executeQuery();
                System.out.println("Doctors:");
                while (resultSet.next())
                {
                    doctor=resultSet.getString(1);
                    System.out.println(doctor);
                }
                break;
            case 6:
                preparedStatement.setString(1,"ent");
                resultSet=preparedStatement.executeQuery();
                System.out.println("Doctors:");
                while (resultSet.next())
                {
                    doctor=resultSet.getString(1);
                    System.out.println(doctor);
                }
                break;
  }
}}
