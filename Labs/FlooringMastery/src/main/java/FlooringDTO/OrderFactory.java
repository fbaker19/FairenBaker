/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringDTO;

/**
 *
 * @author apprentice
 */
public class OrderFactory extends OrderVariables {

    public OrderFactory() {

        laborCost = area * laborCostPerSqFt;
        materialCost = area * costPerSqFt;
        tax = taxRate * (materialCost + laborCost);
        total = materialCost + laborCost + tax;
    
    }
}
