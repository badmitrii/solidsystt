package DAOImpl;

import DAO.SaleDAO;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class SaleDAOImpl implements SaleDAO {

    @Override
    public void addSale(Sale sale) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = String.format("INSERT INTO sales (prodname,count,sum,date) VALUES('%s', %s, %s, '%s');", 
                sale.getProdname(), sale.getCount(), sale.getSum(), sale.getDate().toString());
        session.createSQLQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Collection<? extends Sale> getAllSales() {
        List<Sale> sales = new ArrayList<Sale>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        sales = session.createCriteria(Sale.class).list();
        session.close();
        return sales;
    }

    @Override
    public int getProductIdBySaleName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = String.format("SELECT DISTINCT id FROM products where name='%s'",name);
        List l = session.createSQLQuery(sql).list();
        return (Integer) l.get(0);
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
    public Sale getSaleById(int id) {
        Session session = Hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Sale sale = (Sale) session.get(Sale.class, id);
        session.close();
        return sale;
    }

}
