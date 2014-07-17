package Controllers;

import DAO.ProductDAO;
import DAO.SaleDAO;
import DAOImpl.ProductDAOImpl;
import DAOImpl.SaleDAOImpl;
import Entities.Product;
import Entities.Sale;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.Date;
import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SaleController {

    @RequestMapping("/sales.htm")
    public String getAllSales(Model model) throws SQLException {
        SaleDAO saleMapping = new SaleDAOImpl();
        ProductDAO mapping = new ProductDAOImpl();
        model.addAttribute("products", mapping.getAllProducts());
        model.addAttribute("sales", saleMapping.getAllSales());
        return "sales";
    }

    @RequestMapping("/sales/add.htm")
    @ResponseStatus(HttpStatus.OK)
    public void addSale(@RequestParam("name") String name, @RequestParam("count") String count, @RequestParam("date") String date) throws SQLException, UnsupportedEncodingException, IOException {
        SaleDAO saleMapping = new SaleDAOImpl();
        ProductDAO mapping = new ProductDAOImpl();
                Logger(name);
        int prodId = saleMapping.getProductIdBySaleName(name);

        Product product = mapping.getProductById(prodId);
        int sum = Integer.valueOf(count) * product.getCost();
        Sale sale = new Sale();
        sale.setDate(Date.valueOf(date));
        sale.setProdname(name);
        sale.setCount(Integer.valueOf(count));
        sale.setSum(sum);
        saleMapping.addSale(sale);
    }

    @RequestMapping(value = "/sales/info", produces = "application/json")
    public @ResponseBody Product getProductJson(@RequestParam String name) throws SQLException, UnsupportedEncodingException, IOException
    {
        ProductDAO mapping = new ProductDAOImpl();
        SaleDAO saleMapping = new SaleDAOImpl();
        int id = saleMapping.getProductIdBySaleName(name);
        Logger(name);
        Product product = mapping.getProductById(id);
        return product;
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
    
}
