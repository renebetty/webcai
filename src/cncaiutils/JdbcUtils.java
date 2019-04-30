package cncaiutils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
//数据库连接类
    public static void main(String[] args) {
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
    }

    //静态块，当前类（class文件），被加载到JVM中，才会被执行，且执行一次
    static {
        //1、加载数据库驱动文件
        try {
            //如果有运行时的错误，Java会提示Try来捕获
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            //打印异常
            //抛出此异常，谁调用此方法，异常就抛给谁
            throw new RuntimeException(e);
        }
    }


    //3、返回一个连接对象
    public static Connection getConnection(){
        //加载Java类,加载Driver类，mysql驱动的入口
        try {
            //2、配置连接数据库参数
            //驱动管理类，通过此类设置账号，密码，url地址，并且返回connection对象
            return DriverManager.getConnection("jdbc:mysql://154.223.189.113:3306/sq_mkjgu105305","sq_mkjgu105305","dir437");
        } catch (Exception e) {
            //显示错误信息
            throw new RuntimeException(e);
        }
    }

}
