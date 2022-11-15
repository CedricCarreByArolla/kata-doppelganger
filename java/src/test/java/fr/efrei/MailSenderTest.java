package fr.efrei;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MailSenderTest {
  @Test
  void should_make_a_sendgrid_request() {
    //Arrange
    User user = new User("Dimitri", "dimitri@arolla.fr");
    HttpClientSpy httpClientSpy = new HttpClientSpy();
    MailSender mailSender = new MailSender(httpClientSpy);
    List<String> expectedResult = new ArrayList<>(Arrays.asList("Dimitri", "dimitri@arolla.fr", "New notification","Well done !"));
    //Act
    mailSender.sendV1(user, "Well done !");
    //Assert
    assertThat(httpClientSpy.getRequestParamsOrdered()).isEqualTo(expectedResult);
  }

  @Test
  void should_retry_when_getting_a_503_error() {
    //Arrange
    User user = new User("Dimitri", "dimitri@arolla.fr");
    HttpClientSpy httpClientSpy = new HttpClientSpy();
    MailSender mailSender = new MailSender(httpClientSpy);
    //Act
    mailSender.sendv2(user, "Well done !");
    //Assert
    assertThat(httpClientSpy.nbOfCallWithValidParams()).isEqualTo(2);
  }
}
