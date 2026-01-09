import burgerpages.MainPage;
import org.junit.Before;
import org.junit.Test;
import util.Constants;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BurgerBuilderTests extends BaseTest {

    @Before
    public void startup(){
        driver.get(Constants.BURGER_MAIN_PAGE);
    }

    @Test
    public void sauceConstructButtonShouldBecomeActiveOnClick(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.sauceConstructButtonClick();
        assertThat(objMainPage.getActiveConstructButtonText(), is("Соусы"));
    }

    @Test
    public void fillingsConstructButtonShouldBecomeActiveOnClick(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.fillingsConstructButtonClick();
        assertThat(objMainPage.getActiveConstructButtonText(), is("Начинки"));
    }

    @Test
    public void bunConstructButtonShouldBecomeActiveOnClick(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.sauceConstructButtonClick();
        objMainPage.bunConstructButtonClick();
        assertThat(objMainPage.getActiveConstructButtonText(), is("Булки"));
    }
}
