package baseUtil;

import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDBConnect<ips> {

    // 这里可以设置数据库名称
    private static String URL = null;
    private static String USER = null;
    private static String PASSWORD = null;


    private static Connection conn = null;

    // 静态代码块（将加载驱动、连接数据库放入静态块中）
    static {

        Properties p = new Properties();
        // 加载配置文件
        InputStream ips = null;
        try {
            ips = new FileInputStream(".\\TestConfig\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            p.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }

        URL = p.getProperty("HOSTURL");
        USER = p.getProperty("NAME");
        PASSWORD = p.getProperty("PASSWD");
        try {
            ips.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // 1.加载驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 2.获得数据库的连接
            conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BaseDBConnect() throws FileNotFoundException {
    }

    // 对外提供一个方法来获取数据库连接
    public static Connection getConnection() {
        return conn;
    }

    public int DBQuery(String sql) throws Exception {

        // 3.通过数据库的连接操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        Logger.Output(LogType.LogTypeName.INFO, "建立数据库链接 ");
        //执行查询数据库的SQL语句 ，返回一个结果集（ResultSet）对象。
        Logger.Output(LogType.LogTypeName.INFO, "需要查询的语句是： " + sql);
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {// 如果对象中有数据，就会循环打印出来
            System.out.println(rs.getInt(1) + "," + rs.getString(4) + "," + rs.getString(3));
            Logger.Output(LogType.LogTypeName.INFO, "查询结束");
            return 1;
        } else {
            return -1;
        }
    }

    public void DBUpdate(String sql) throws Exception {
        Statement stmt = conn.createStatement();
        Logger.Output(LogType.LogTypeName.INFO, "建立数据库链接 ");
        Logger.Output(LogType.LogTypeName.INFO, "需要更新的语句是： " + sql);
        stmt.executeUpdate(sql);
        Logger.Output(LogType.LogTypeName.INFO, "指定会员已经更新 ");
    }

    public void DBExecute(String sql) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Logger.Output(LogType.LogTypeName.INFO, "建立数据库链接 ");
        Logger.Output(LogType.LogTypeName.INFO, "需要执行的语句是： " + sql);
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Logger.Output(LogType.LogTypeName.INFO, "指定语句已经执行。 ");
    }

}
