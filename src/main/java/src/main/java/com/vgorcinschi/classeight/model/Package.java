/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.vgorcinschi.classeight.model;

import static java.util.OptionalDouble.of;
import java.util.OptionalDouble;
import static java.util.OptionalDouble.empty;

/**
 *
 * @author v_gorcin
 */
public enum Package {

    /**
     *
     */
    A(9.95, of(2), of(10)),
    B(14.95, of(1), of(20)),
    C(19.95, empty(), empty());
    private final double baseRate;
    private final OptionalDouble extraRate;
    private final OptionalDouble coveredHours;

    Package(double baseRate, OptionalDouble extraRate, OptionalDouble coveredHours) {
        this.baseRate = baseRate;
        this.coveredHours = coveredHours;
        this.extraRate = extraRate;
    }

    public double getMonthlyPrice(double hoursUsed) {
        if (hoursUsed > 744) {
            hoursUsed = 744;
        }
        double total = 0;
        if (!this.coveredHours.isPresent()) {
            total = hoursUsed * baseRate;
        } else {
            double remainder = hoursUsed - coveredHours.getAsDouble();
            if (remainder>0) {
                total=coveredHours.getAsDouble()*baseRate+remainder*extraRate.getAsDouble();
            }else{
                total=hoursUsed*baseRate;
            }
        }
        return total;
    }
}
