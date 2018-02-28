package exercise1;

import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {

    MyRevenueCalculator myRevenueCalculator = new MyRevenueCalculator();

    BigDecimal marginPercentage = new BigDecimal("20");

    BigDecimal costOfGoods = new BigDecimal("400");

    BigDecimal revenue = myRevenueCalculator.calculateRevenue(marginPercentage,costOfGoods);

    System.out.println(revenue);

  }
}
