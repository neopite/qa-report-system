import org.hamcrest.Matchers;
import org.junit.Test;

public class ResourceTest {
    @Test
    public void verifyGetExistedResourceAndReturn200(){
        long idExistedResource = 2;
        new ApiEndpoints().getUserById(idExistedResource).then().statusCode(200);
    }

    @Test
    public void verifyGetNonExistedResourceAndReturn404(){
        long idExistedResource = 5000;
        new ApiEndpoints().getUserById(idExistedResource).then().statusCode(404);
    }

    @Test
    public void verifyNotEmptyResponse(){
        long idExistedResource = 2;
        new ApiEndpoints().getUserById(idExistedResource).then().assertThat().body(Matchers.notNullValue());
    }
}
