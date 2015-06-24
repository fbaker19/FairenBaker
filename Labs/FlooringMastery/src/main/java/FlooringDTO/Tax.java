/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FlooringDTO;

/**
 *
 * @author Clay McMullen
 */
public class Tax {
    double taxRate;
    String stateName;

    public double getTaxRate() {
        return taxRate;
    }

    public String getStateName() {
        return stateName;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    
}
