package api;

import entities.User;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserCreationTest {

    @Test
    public void userCanBeCreatedReturn201(){
        User user = new User();
        user.setId(1003);
        user.setEmail("lolkek@gmail.com");
        user.setFirstName("Yarik");
        user.setLastName("Obruch");
        user.setAvatar("avatar.com");
        new ApiEndpoints().createUser(user).then().statusCode(201);
    }
}