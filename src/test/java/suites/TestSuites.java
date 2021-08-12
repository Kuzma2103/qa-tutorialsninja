package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;
import tests_with_login.AddToWishListTest;
import tests_with_login.CheckoutWithLoginTest;
import tests_with_login.LogoutTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        LoginWithEmptyEmailTest.class,
        LoginWithEmptyPasswordTest.class,
        LoginWithWrongUserDataTest.class,
        CheckoutWithRegisterAccountTest.class,
        RegistrationTest.class,
        ValidLoginTest.class,
        LogoutTest.class,
        CheckoutWithLoginTest.class,
        CheckoutAsGuestTest.class,
        RemoveItemFromCartTest.class,
        AddToWishListTest.class
})

public class TestSuites {
}
