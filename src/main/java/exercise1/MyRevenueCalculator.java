package exercise1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MyRevenueCalculator implements RevenueCalculator {
  public BigDecimal calculateRevenue(BigDecimal marginPercentage, BigDecimal costOfGoods) {

    // Case not positive parameters null is returned
    if (marginPercentage.compareTo(BigDecimal.ZERO) == -1 || costOfGoods.compareTo(BigDecimal.ZERO) == -1)
      return null;

    // If costOfGoods is Zero marginPercentage makes no sense and we always return Zero
    if (costOfGoods.compareTo(BigDecimal.ZERO) == 0)
      return BigDecimal.ZERO;

    // If marginPercentage == 0 then COST = Revenue
    if (marginPercentage.compareTo(BigDecimal.ZERO) == 0)
      return costOfGoods;

    // if marginPercentage is from Revenue we would need to apply 100 - marginPercentage to
    // costOfGoods.
    BigDecimal marginOfCostOfGoods = new BigDecimal(100).subtract(marginPercentage);

    BigDecimal bdAux = costOfGoods.multiply(new BigDecimal("100"));

    return bdAux.divide(marginOfCostOfGoods ,2, RoundingMode.HALF_UP);
  }
}
