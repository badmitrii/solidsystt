package Controllers;

import DAO.SaleDAO;
import DAOImpl.ProductDAOImpl;
import DAOImpl.SaleDAOImpl;
import Entities.Product;
import Entities.Sale;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ProductController {

    @RequestMapping("/products.htm")
    public String getAllProducts(Model model) throws SQLException {
        ProductDAOImpl mapping = new ProductDAOImpl();
        model.addAttribute("products", mapping.getAllProducts());
        return "index";
    }

    @RequestMapping("/products/change.htm")
    @ResponseStatus(HttpStatus.OK)
    public void change(@RequestParam("id") String id, @RequestParam("cost") String cost, @RequestParam("name") String name, Model model) throws SQLException, UnsupportedEncodingException {
        ProductDAOImpl mapping = new ProductDAOImpl();
        Product product = new Product();
        product.setId(Integer.parseInt(id));
        product.setName(name);
        product.setCost(Integer.parseInt(cost));
        mapping.updateProduct(product);
    }

    @RequestMapping("/products/add.htm")
    @ResponseStatus(HttpStatus.OK)
    public void add(@RequestParam("cost") String cost, @RequestParam("name") String name) throws SQLException {
        ProductDAOImpl mapping = new ProductDAOImpl();
        Product product = new Product();
        product.setName(name);
        product.setCost(Integer.parseInt(cost));
        mapping.addProduct(product);
    }

    @RequestMapping("/products/remove.htm")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@RequestParam("id") String id) throws SQLException 
    {
        ProductDAOImpl mapping = new ProductDAOImpl();
        Product product = new Product();
        product.setId(Integer.parseInt(id));
        mapping.deleteProduct(product);
    }
    
    @RequestMapping(value = "/products/info", produces = "application/json")
    public @ResponseBody List<Sale> listOfSales(@RequestParam("name") String name)
    {
        List<Sale> sales = new ArrayList();
        ProductDAOImpl mapping = new ProductDAOImpl();
        SaleDAO saleMapping = new SaleDAOImpl();
        List saleIds = mapping.getListOfSale(name);
        for(Object i: saleIds)
        {
            Sale sale = saleMapping.getSaleById((Integer) i);
            sales.add(sale);
        }
        return sales;
    }
}
