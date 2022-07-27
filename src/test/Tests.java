import org.testng.Assert;
import org.testng.annotations.Test;


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
        for (Currency
                v : Currency.values()) {
            System.out.println(v.name() + " " + v.amount());
        }
    }

}
