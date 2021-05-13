package api;

import entities.Error;
import entities.Login;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Test
    public void verifyLoginExistedUserAndReturn200(){
        Login login = new Login();
        login.setEmail("george.bluth@reqres.in");
        login.setPassword("123456");
        new ApiEndpoints().loginUser(login).then().statusCode(200);
    }

    @Test
    public void verifyLoginNonExistedUserAndReturn400(){
        Login login = new Login();
        login.setEmail("NotExisted@gmail.com");
        login.setPassword("123456");
        new ApiEndpoints().loginUser(login).then().statusCode(400);  //fef
    }

    @Test
    public void verifyLoginNonExistedUserAndReceiveError(){
        Login login = new Login();
        login.setEmail("NotExisted@gmail.com");
        login.setPassword("123456");
        Error error = new ApiEndpoints().loginUser(login).as(Error.class);
        assertEquals("user not found",error.getError());
    }

    @Test
    public void verifyLoginWithEmptyPassword(){
        Login login = new Login();
        login.setEmail("eve.holt@reqres.in");
        Error error = new ApiEndpoints().loginUser(login).as(Error.class);
        assertEquals("Missing password",error.getError());
    }
}