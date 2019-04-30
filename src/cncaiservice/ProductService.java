package cncaiservice;

import cncaidao.ProductDao;
import cncaimodel.Product;

import java.util.ArrayList;

//ProductService=>ProduceDao=>JdbcUtils=>db数据库
public class ProductService {

    private ProductDao productDao = new ProductDao();


    //编写一个方法调用Dao完成数据库的入库操作
    public void save(Product product){
        //以后会添加业务逻辑代码，处理完毕之后调用数据访问层
        productDao.save(product);
    }

    public void delete(int id){
        //以后会添加业务逻辑代码，处理完毕之后调用数据访问层
        productDao.delete(id);
    }

    public void update(Product product){
        //以后会添加业务逻辑代码，处理完毕之后调用数据访问层
        productDao.update(product);
    }

    public ArrayList<Product> queryName (String name){
        //查询
        return productDao.queryByName(name);
    }

    public Product getById (int id){
        //查询
        return productDao.getById(id);
    }

}
