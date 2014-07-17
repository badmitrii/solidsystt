/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.ProductDAO;
import Entities.Product;
import Entities.Sale;
import Hibernate.util.HibernateUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ProductDAOImpl implements ProductDAO {

    @Override
    public void addProduct(Product product) throws SQLException {
        Session session = Hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = String.format("INSERT INTO products (name,cost) VALUES('%s',%s);", product.getName(), product.getCost());
        /*Properties connectionProps = new Properties();
         connectionProps.put("user", "postgres");
         connectionProps.put("password", "123");
         Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/solid",connectionProps);
         conn.createStatement().execute(sql);*/
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        Session session = Hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        Session session = Hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = (Product) session.get(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public Collection<? extends Product> getAllProducts() throws SQLException {
        Session session = Hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Product> products = new ArrayList<Product>();
        products = session.createCriteria(Product.class).list();
        session.close();
        return products;
    }

    @Override
    public void deleteProduct(Product product) throws SQLException {
        Session session = Hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }

    private void Logger(String line) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        try {
            File statText = new File("C:/log.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(line);
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
    }

    @Override
    public List getListOfSale(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = String.format("SELECT DISTINCT saleid FROM products INNER JOIN sales ON (products.name = sales.prodname) where name='%s'", name);
        List l = session.createSQLQuery(sql).list();
        return l;
    }

}
