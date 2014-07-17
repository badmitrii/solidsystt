/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entities.Product;
import Entities.Sale;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductDAO {
    public void addProduct(Product product) throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public Product getProductById(int id) throws SQLException;
    public Collection<? extends Product> getAllProducts() throws SQLException;
    public void deleteProduct(Product product) throws SQLException;
    public List<Sale> getListOfSale(String name);
}
