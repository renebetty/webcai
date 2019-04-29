package cncaidao;

import cncaimodel.Product;
import cncaiutils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

//主要是用来完成对Product表的CRUD操作
public class ProductDao {

    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        //存储多个对象C语言采用的是数组（指定大小）
        //ArrayList iList = new ArrayList(); 集合，不指定类型不指定大小
        //泛型集合可以在创建的时候指定类型
        ArrayList<Product> proList = dao.queryByName("");
        for (int i = 0;i < proList.size();i++){
            Product pro = proList.get(i);
            System.out.println(pro.toString());
        }
    }

    //插入数据
    public void save(Product product){
        String sql = "insert into product (name,price,remark) values (?,?,?)";
        //1、获取数据区的连接对象
        Connection con = JdbcUtils.getConnection();
        //2、传入参数，并且执行相应SQL操作
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,product.getName());
            pre.setDouble(2,product.getPrice());
            pre.setString(3,product.getRemark());
            //执行最后的SQL语句
            pre.executeUpdate();
        }catch (Exception e) {
            //显示错误信息
            throw new RuntimeException(e);
        }
    }
    //删除数据
    public void delete(int id){
        String sql = "delete from product where id = ?";
        Connection con = JdbcUtils.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,id);
            pre.executeUpdate();
        }catch (Exception e) {
            //显示错误信息
            throw new RuntimeException(e);
        }
    }
    //修改数据
    public void update(Product product){
        String sql = "update product set name = ?,price = ?,remark = ? where id = ?";
        //1、获取数据区的连接对象
        Connection con = JdbcUtils.getConnection();
        //2、传入参数，并且执行相应SQL操作
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,product.getName());
            pre.setDouble(2,product.getPrice());
            pre.setString(3,product.getRemark());
            pre.setInt(4,product.getId());
            //执行最后的SQL语句
            pre.executeUpdate();
        }catch (Exception e) {
            //显示错误信息
            throw new RuntimeException(e);
        }
    }
    //根据关键字，查询商品信息的功能
    public ArrayList<Product> queryByName(String name){
        //用来存储Product对象的泛型集合
        ArrayList<Product> productsList = new ArrayList<Product>();
        String sql = "select * from product where name like ?";
        //1、获取Connect对象
        Connection conn = JdbcUtils.getConnection();
        try {
            //2、创建SQL语句，并且配置查询参数
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,"%"+ name +"%");
            //3、获取查询结果，结果集都被封装到ResultSet对象中
            // 光标被置于第一行之前。next 方法将光标移动到下一行，如果有记录返回True
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                //把当前记录转化为Product对象
                Product p1 = new Product();
                p1.setId(rs.getInt("id"));
                p1.setName(rs.getString("name"));
                p1.setPrice(rs.getDouble("price"));
                p1.setRemark(rs.getString("remark"));
                p1.setDate(rs.getDate("date"));
                productsList.add(p1);
            }
            return productsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //
    }
}
