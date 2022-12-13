package com.example.finalassignmentadvanceddb;
import java.sql.*;
public class DatabaseHandler {
    static final String DRIVER = "oracle.jdbc.OracleDriver";
    static final String DATABASE_URL = "INSERT_HERE";

    static final String USERNAME = "USERNAME_HERE";
    static final String PASSWORD = "PASSWORD_HERE";
    static Connection connection;
    static PreparedStatement pst;

    public static boolean attemptToConnect() {
        try{
            System.out.println(">> Starting Program!");

            Class.forName(DRIVER);
            System.out.println(">> Driver Loaded Successfully!");

            connection = DriverManager.getConnection(DATABASE_URL,USERNAME, PASSWORD);
            System.out.println(">> Database Connected Successfully!");

            return true;
        }catch (Exception e){
            System.out.println("Exception Found!");
            e.printStackTrace();
            return false;
        }
    }
    //TASK 1-1
    public static void Employee_hire_sp(String p_first_name, String p_last_name, String p_email, String p_salary, String p_hire_date, String p_phone, int p_job_id, int p_manager_id, int p_department_id )
    {
        try{
            //THE FIRST VALUE IS EMPLOYEE_ID, PLEASE CHECK TO SEE IF THIS IS CORRECT
            pst = connection.prepareStatement("INSERT INTO employees (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL,\n" +
                    "PHONE_NUMBER, HIRE_DATE,JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID ) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,"EMPLOYEES_SEQ.NEXTVAL");
            pst.setString(2,p_first_name);
            pst.setString(3,p_last_name);
            pst.setString(4,p_email);
            pst.setString(5,p_salary);
            pst.setString(6,p_hire_date);
            pst.setString(7,p_phone);
            pst.setInt(8,p_job_id);
            pst.setInt(9,p_manager_id);
            pst.setInt(10,p_department_id);


            ResultSet result = pst.executeQuery();

        }
        catch (Exception e)
        {
            System.out.println("EXCEPTION FOUND IN INSERT ATTEMPT");
            e.printStackTrace();

        }
    }

}
