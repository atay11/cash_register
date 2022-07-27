import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Tests {

    private static String grabOutput(String ... vals)
    {
        return CashRegister.processInput(vals);
    }


    @DataProvider
    public Object[][] validOrInvalid(){
        return new Object[][]{
                {"1", "1", true},
                {"1.00", "1", true},
                {"1", "1.00", true},
                {"1.0", "1", false},
                {"1", "1.000", false},
                {"1234567.89", "1", true},
                {"1", "9999999.99", true},
                {"1", "10000000.00", false},
                {"1", "123456789012345678901.00", false},
                {"1000000000", "1", false},
                {"1.", "1", false},
                {"$1", "1", false},
                {"1.00", "dog", false},
                {"1.00", "4.a0", false},
                {"--help", "4.00", false}
        };
    }

    static String inv = "Invalid Input Detected";
    static String help = "execute command type";
    @Test(dataProvider = "validOrInvalid")
    public void testShouldProcessValidInput(String arg1, String arg2, boolean isValid) {
        Assert.assertEquals(grabOutput(arg1, arg2).contains(inv), !isValid);
    }

    @Test
    public void testNoParamsShowsHelp() {
        String output = grabOutput();
        Assert.assertFalse(output.contains(inv));
        Assert.assertTrue(output.contains(help));
    }


    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void testNegativeDueThrowsException() {
        CashRegister.processPayment(-1, 0);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void testNegativeReceivedThrowsException() {
        CashRegister.processPayment(0, -1);
    }

    @Test
    public void testProcessPaymentReturnsSameAsProcessInputForValidAmountsWithDecimal() {
        String output1 = CashRegister.processPayment(741906725, 870598905);
        String output2 = grabOutput("7419067.25", "8705989.05");
        Assert.assertEquals(output1, output2);
    }

    @Test
    public void testProcessPaymentReturnsSameAsProcessInputForValidAmountsWithoutDecimal() {
        String output1 = CashRegister.processPayment(363082100, 840811200);
        String output2 = grabOutput("3630821", "8408112");
        Assert.assertEquals(output1, output2);
    }

    @Test
    public void testExactChange() {
        String output1 = CashRegister.processPayment(2950, 2950);
        Assert.assertEquals(output1, "$0.00");
    }

    @Test
    public void testExample1Change() {
        String output1 = CashRegister.processPayment(3594, 4000);
        Assert.assertEquals(output1, "$4.06 (1 PENNY, 1 NICKEL, 4 ONE)");
    }

    @Test
    public void testExample4Change() {
        String output1 = CashRegister.processPayment(7050, 10000);
        Assert.assertEquals(output1, "$29.50 (2 QUARTER, 4 ONE, 1 FIVE, 1 TWENTY)");
    }

    @Test
    public void testExample5BalanceDue() {
        String output1 = CashRegister.processPayment(13467, 10000);
        Assert.assertEquals(output1, "$-34.67 Due");
    }

    @Test
    public void testChangeWithEveryDenomination() {
        String output1 = CashRegister.processPayment(100000, 358641);
        Assert.assertEquals(output1, "$2586.41 (1 PENNY, 1 NICKEL, 1 DIME, 1 QUARTER, 1 ONE, 1 FIVE, 1 TEN, 1 TWENTY, 1 FIFTY, 25 ONE HUNDRED)");
    }

}
