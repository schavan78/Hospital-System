import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class Hospital {
    public void menu() throws IOException, SQLException, ClassNotFoundException {
        int ch;
        Scanner in = new Scanner(System.in);
        Doctor obj = new Doctor();
        Patient pat = new Patient();
        Other other=new Other();
        do {
            System.out.println("------------------Hospital-------------------------");
            System.out.println("----------------------------------------------------");
            System.out.println("1)Enter new patient details:");
            System.out.println("2)Show patients list:");
            System.out.println("3)Doctor list");
            System.out.println("4)Room Details:");
            System.out.println("5)Search patient by name:");
            System.out.println("Enter choice:");
            ch = in.nextInt();
            switch (ch) {
                case 1:
                    pat.get_patient();
                    break;
                case 2:
                    pat.put_patient();
                    break;
                case 3:
                    obj.doctor();
                    break;
                case 4:
                    other.room();
                    break;
                case 5:
                    pat.search();
                    break;
            }
        } while (ch != 7);
    }
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Hospital obj = new Hospital();
        obj.menu();
    }
}
