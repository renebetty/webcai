package cncaiservice;

import cncaidao.ProductDao;
import cncaimodel.Product;

//ProductService=>ProduceDao=>JdbcUtils=>db数据库
public class ProductService {

    private ProductDao productDao = new ProductDao();

    //编写一个方法调用Dao完成数据库的入库操作
    public void save(Product product){
        //以后会添加业务逻辑代码，处理完毕之后调用数据访问层
        productDao.save(product);
    }

}
