package fr.efrei;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CalculatorTest {
    @Test
    void should_not_throw_when_authorized() {
        //Arrange
        Authorizer authorizer = new AllowAccessAuthorizerStub();
        Calculator calculator = new Calculator(authorizer);
        int numerator = 4;
        int denominator = 2;
        //Act
        Throwable thrown = catchThrowable(() -> calculator.divide(numerator, denominator));
        //Assert
        assertThat(thrown).isNull();
    }
}
