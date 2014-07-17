/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entities.Product;
import Entities.Sale;
import java.util.Collection;

/**
 *
 * @author Admin
 */
public interface SaleDAO {
    public void addSale(Sale sale);
    public Collection<? extends Sale> getAllSales();
    public int getProductIdBySaleName(String name);
    public Sale getSaleById(int id);
}
