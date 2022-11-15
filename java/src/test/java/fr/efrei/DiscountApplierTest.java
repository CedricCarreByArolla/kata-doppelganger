package fr.efrei;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountApplierTest {
    @Test
    void should_notify_twice_when_applying_discount_for_two_users_v1() {
        //Arrange
        List<User> users = new ArrayList<>() {{
            add(new User("Dimitri", "dimitri@arolla.fr"));
            add(new User("Cédric", "cedric@arolla.fr"));
        }};
        NotifierSpy notifier = new NotifierSpy();
        DiscountApplier discountApplier = new DiscountApplier(notifier);
        //Act
        discountApplier.applyV1(5.5, users);
        //Assert
        assertThat(notifier.getNumberOfCall()).isEqualTo(users.size());
    }

    @Test
    void should_notify_twice_when_applying_discount_for_two_users_v2() {
        //Arrange
        List<User> users = new ArrayList<>() {{
            add(new User("Dimitri", "dimitri@arolla.fr"));
            add(new User("Cédric", "cedric@arolla.fr"));
        }};
        NotifierMock notifier = new NotifierMock();
        DiscountApplier discountApplier = new DiscountApplier(notifier);
        //Act
        discountApplier.applyV2(5.5, users);
        //Arrange
        assertThat(notifier.isCallForAll(users)).isTrue();
    }

}
