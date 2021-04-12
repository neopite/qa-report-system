import entities.AuthenticationToken;
import entities.Error;
import entities.RegistrationForm;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RegistrationTest {

    @Test
    public void verifyUserRegistrationAndReturn200(){
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setEmail("eve.holt@reqres.in");
        registrationForm.setPassword("123456");
        new ApiEndpoints().registerUser(registrationForm).then().statusCode(200);
    }

    @Test
    public void verifyUnsuccessfulRegistrationAndReturn400(){
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setEmail("Stamin4ik4@gmail.com");
        new ApiEndpoints().registerUser(registrationForm).then().statusCode(400);
    }

    @Test
    public void verifyAuthTokenIsReturnInResponseAndReturn200(){
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setEmail("george.bluth@reqres.in");
        registrationForm.setPassword("123124");
        AuthenticationToken authenticationToken = new ApiEndpoints().registerUser(registrationForm).body().as(AuthenticationToken.class);
        assertNotNull(authenticationToken);
    }

    @Test
    public void verifyRegisterErrorMissingPassword(){
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setEmail("Stamin4ik4@gmail.com");
        Error error = new ApiEndpoints().registerUser(registrationForm).body().as(Error.class);
        assertEquals("Missing password" , error.getError());
    }
    @Test
    public void verifyRegisterErrorMissingEmail(){
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setPassword("123");
        Error error = new ApiEndpoints().registerUser(registrationForm).body().as(Error.class);
        assertEquals("Missing email or username" , error.getError());
    }
}
