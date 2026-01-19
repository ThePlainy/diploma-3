package steps;

import config.RestConfig;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.User;

import static io.restassured.RestAssured.given;

public class UserSteps {

    public static final String AUTH_REGISTER_HANDLER = "/api/auth/register";
    public static final String AUTH_USER_HANDLER = "/api/auth/user";
    public static final String AUTH_LOGIN_HANDLER = "/api/auth/login";

    @Step("Создание пользователя")
    public Response createUser(User user){
        return given()
                .baseUri(RestConfig.MAIN_BURGER_URI)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(AUTH_REGISTER_HANDLER);
    }

    @Step("Удаление пользователя")
    public Response deleteUser(User user){
        if (user.getAccessToken() != null) {
            return given()
                .header("Authorization",user.getAccessToken())
                .baseUri(RestConfig.MAIN_BURGER_URI)
                .when()
                .delete(AUTH_USER_HANDLER);}
        else {
            System.out.println("User was not created and cannot be deleted");
            return null;
        }
    }

    @Step("Логин пользователя")
    public Response loginUser(User user){
        return given()
                .baseUri(RestConfig.MAIN_BURGER_URI)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(AUTH_LOGIN_HANDLER);
    }
}
