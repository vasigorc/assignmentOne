/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.classeight.model;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author v_gorcin
 */
public class Invoice {

    private static AtomicInteger idProvider;
    private final int invoiceId;
    private static Map<Character, Package> packages;
    private final Package invoicePackage;
    private final double MAX_HOURS = 744;
    private final double hoursUsed;

    private static final Logger log = LogManager.getLogger();

    static {
        packages.put('A', Package.A);
        packages.put('B', Package.B);
        packages.put('C', Package.C);
    }

    public Invoice(Character packageChar, double hoursUsed) {
        invoiceId = idProvider.getAndIncrement();
        log.info("A new invoice is generated with id: "+invoiceId);
        if (packages.containsKey(packageChar)) {
            this.invoicePackage = packages.get(packageChar);
            log.info("The selected package is: " + invoicePackage.name());
        } else {
            this.invoicePackage = Package.A;
            log.error("Provided character " + packageChar + " is not a valid package. Defaulting to: " + invoicePackage.name());
        }
        log.info("The hours used on the invoice is " + invoicePackage.name());
        this.hoursUsed = hoursUsed;
    }
    
    public void perform(){
        System.out.println("Your total amount due on invoice #"+invoiceId+" (before taxes) is "+invoicePackage.getMonthlyPrice(hoursUsed));
    }
}
