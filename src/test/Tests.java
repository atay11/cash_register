import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Currency;
import java.util.Set;


public class Tests {
    @Test
    public void shouldPass() {
        Assert.assertEquals(true, true);
    }

    @Test
    public void shouldFail() {
        Assert.assertEquals(true, false);
    }

    @Test void canAccessSrcMain()
    {
        Set x = Currency.getAvailableCurrencies();
    }

}
