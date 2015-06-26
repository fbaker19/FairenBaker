/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringDTO;

import com.swcguild.flooringmastery.dao.ProductDAO;
import com.swcguild.flooringmastery.dao.TaxDAO;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class OrderFactory {

    TaxDAO taxDao = new TaxDAO();
    ProductDAO productDao = new ProductDAO();

    public Order createNewOrder(String customerName, String state, String materials, double area,String date) {
        
        Order order = new Order(1);
        order.orderNum = order.getOrderNumCount();
        order.setDate (date);
        order.setArea(area);
        order.setState(state);
        order.setMaterials(materials);
        order.setCustomerName(customerName);
        Tax taxInfo = new Tax();

//      Tax taxInfo = tax.loadTaxInfo(); //reads info
        ArrayList<Product> productInfo = productDao.loadProductInfo();//reads info
        
        Product product2 = new Product();
        
        ArrayList<Tax> stateTax = taxDao.loadTaxInfo();

        for (Tax taxState : stateTax) {
            if (state.equalsIgnoreCase(taxState.getStateName())) {
                taxInfo.setTaxRate(taxState.getTaxRate());

            }

        }
        for (Product productType : productInfo) {

            if (materials.equalsIgnoreCase(productType.getProductName())) 
            {
                product2.setCostPerSqFt(productType.getCostPerSqFt());
                product2.setLaborCostPerSqFt(productType.getLaborCostPerSqFt());
            }
        }
        order.setTaxRate((double)(taxInfo.getTaxRate()));
        order.setCostPerSqFt((double)(product2.getCostPerSqFt()));

        order.setLaborCost((double)(area * product2.getCostPerSqFt()));
        order.setLaborCostPerSqFt((double)(product2.getLaborCostPerSqFt()));
        order.setMaterialCost(product2.getCostPerSqFt() * area);

        order.setTax((double)((taxInfo.getTaxRate() * (product2.getLaborCostPerSqFt() * area + (area * product2.getCostPerSqFt())))));

        order.setTotal((double)(area * product2.getLaborCostPerSqFt() + (area * product2.getCostPerSqFt()) + taxInfo.getTaxRate()));

        return order;
    }
}
