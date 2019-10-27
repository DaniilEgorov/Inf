package Second_kurs;

import java.sql.*;
import java.util.Scanner;

public class Task6 {
    static Connection connection = null;
    static PreparedStatement ps = null;
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        newConnect();
        addNewClient("ООО Шуба","Russia","Cheboksary","ул.Петрова, д.4","237-89-08","mex@mail.ru");
        addNewClient(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
        change();
        del();
        outDatabase();
    }
    public static void newConnect() throws  SQLException {
        String url = "jdbc:postgresql://127.0.0.1:5432/data1";
        String name = "postgres";
        String password = "qwerty";
        connection = DriverManager.getConnection(url,name,password);
    }
    public static void addNewClient( String name, String country, String city, String address, String phone, String email) throws SQLException {
        ps = connection.prepareStatement("INSERT INTO table1 VALUES ('"+name+"','"+country+"','"+city +"','" +address +"','"+phone+"','"+email+"')");
        ps.executeUpdate();
    }
    public static void change() throws SQLException {
        ps = connection.prepareStatement("UPDATE table1 SET Имя = 'Институт ядерных технологий', Телефон = '511-11-11' WHERE Код_клиента = 4");
        ps.executeUpdate();
    }
    public static void del() throws SQLException {
        ps = connection.prepareStatement("DELETE FROM table1 WHERE Код_клиента = 5");
        ps.executeUpdate();
    }
    public static void outDatabase() throws SQLException {
        ps = connection.prepareStatement("SELECT * FROM table1");
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt("Код_клиента")+ " " + resultSet.getString("Имя")
                    + resultSet.getString("Страна")+ resultSet.getString("Город") + resultSet.getString("Адрес")
                    + resultSet.getString("Телефон") + resultSet.getString("Электронная_почта"));
        }
    }
}
