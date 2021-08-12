package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;
import tests_with_login.*;


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
        AddToWishListTest.class,
        RemoveFromWishListTest.class
})

public class TestSuites {
}
