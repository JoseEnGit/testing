package exercise1;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;



public class MyRevenueCalculatorTest {
  @Test
  public void calculateRevenue() throws Exception {

    // Objects needed

    MyRevenueCalculator myRevenueCalculator = new MyRevenueCalculator();

    BigDecimal marginPercentage;

    BigDecimal costOfGoods;

    BigDecimal revenue;

    //////////////////

    ///////////////////////////
    // Test type: Basic
    /////////////////////////
    marginPercentage = new BigDecimal("20");
    costOfGoods = new BigDecimal("400");

    revenue = myRevenueCalculator.calculateRevenue(marginPercentage,costOfGoods);

//    assertThat(new BigDecimal("500"),  Matchers.comparesEqualTo(revenue));

    assertTrue(new BigDecimal("500").compareTo(revenue) == 0);

    ///////////////////////////
    // Test type: Decimals 1
    /////////////////////////
    marginPercentage = new BigDecimal("25.5");
    costOfGoods = new BigDecimal("400");

    revenue = myRevenueCalculator.calculateRevenue(marginPercentage,costOfGoods);

//    assertThat(new BigDecimal("500"),  Matchers.comparesEqualTo(revenue));

    assertTrue(new BigDecimal("536.91").compareTo(revenue) == 0);


    ///////////////////////////
    // Test type: Decimals 2
    /////////////////////////
    marginPercentage = new BigDecimal("25.5");
    costOfGoods = new BigDecimal("400.95");

    revenue = myRevenueCalculator.calculateRevenue(marginPercentage,costOfGoods);

    assertTrue(new BigDecimal("538.19").compareTo(revenue) == 0);

    ///////////////////////////
    // Test type: Zero Margin
    /////////////////////////
    marginPercentage = new BigDecimal("0");
    costOfGoods = new BigDecimal("400.95");

    revenue = myRevenueCalculator.calculateRevenue(marginPercentage,costOfGoods);

    assertTrue(new BigDecimal("400.95").compareTo(revenue) == 0);

    //////////////////////////////
    // Test type: Zero costOfGoods
    /////////////////////////////
    marginPercentage = new BigDecimal("25");
    costOfGoods = new BigDecimal("0");

    revenue = myRevenueCalculator.calculateRevenue(marginPercentage,costOfGoods);

    assertTrue(new BigDecimal("0").compareTo(revenue) == 0);

    //////////////////////////////
    // Test type: Zero both return 0
    /////////////////////////////
    marginPercentage = new BigDecimal("0");
    costOfGoods = new BigDecimal("0");

    revenue = myRevenueCalculator.calculateRevenue(marginPercentage,costOfGoods);

    assertTrue(new BigDecimal("0").compareTo(revenue) == 0);

    //////////////////////////////
    // Test type: Negative marginPercentage
    /////////////////////////////
    marginPercentage = new BigDecimal("-10");
    costOfGoods = new BigDecimal("300");

    revenue = myRevenueCalculator.calculateRevenue(marginPercentage,costOfGoods);

    assertNull("Margin should be null ", revenue);

    //////////////////////////////
    // Test type: Negative costOfGoods
    /////////////////////////////
    marginPercentage = new BigDecimal("10");
    costOfGoods = new BigDecimal("-300");

    revenue = myRevenueCalculator.calculateRevenue(marginPercentage,costOfGoods);

    assertNull("costOfGoods should be null ", revenue);

    //////////////////////////////
    // Test type: Negative both
    /////////////////////////////
    marginPercentage = new BigDecimal("-10");
    costOfGoods = new BigDecimal("-300");

    revenue = myRevenueCalculator.calculateRevenue(marginPercentage,costOfGoods);

    assertNull("costOfGoods should be null ", revenue);


  }

}