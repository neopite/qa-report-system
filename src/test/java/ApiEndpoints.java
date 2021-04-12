import entities.Login;
import entities.RegistrationForm;
import entities.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiEndpoints {

    public Response getAllUsers() {
        return given().when().
                get(ConfigPath.USERS_ENDPOINT).
                then().extract().response();
    }

    public Response getUserById(long id) {
        return given().
                pathParam("userId", id).when().
                get(ConfigPath.USER_BY_ID).
                then().
                extract().response();
    }

    public Response createUser(User user) {
        return given().
                body(user).when().
                post(ConfigPath.USERS_ENDPOINT).then().extract().response();
    }

    public Response registerUser(RegistrationForm form) {
        return given().
                body(form).when().
                post(ConfigPath.REGISTER_ENDPOINT).
                then().extract().response();
    }

    public Response loginUser(Login login) {
        return given().
                body(login).
                post(ConfigPath.LOGIN_ENDPOINT).
                then().extract().response();
    }

    public Response getResourceById(long id){
        return given().pathParam("resId", id).get(ConfigPath.RESOURCE_BY_ID).then().extract().response();
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(ConfigPath.BASE_URL)
                .contentType(ContentType.JSON);
    }


}
