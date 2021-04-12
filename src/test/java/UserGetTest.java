import org.hamcrest.Matchers;
import org.junit.Test;

public class UserGetTest {

    @Test
    public void verifyListOfUsers() {
        new ApiEndpoints().
                getAllUsers().
                then().statusCode(200).
                assertThat().
                body(Matchers.notNullValue());
    }

    @Test
    public void verifyNotExistingUserReturn404(){
        new ApiEndpoints().
                getUserById(1000).
                then().log().body().statusCode(404);
    }

    @Test
    public void verifyExistingUserReturn200(){
        new ApiEndpoints().getUserById(1).then().log().body().statusCode(200).assertThat().body(Matchers.notNullValue());
    }


}
