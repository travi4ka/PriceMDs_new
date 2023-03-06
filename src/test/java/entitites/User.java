package entitites;

import configuration.MainAdmin;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static configuration.Configuration.*;
import static io.restassured.RestAssured.given;

public class User {

    public Map<String, String> getTokenForAdmin() {
        Map<String, String> map = given().when()
                                         .get(API_SERVER + "/sanctum/csrf-cookie")
                                         .then()
                                         .statusCode(204)
                                         .extract()
                                         .cookies();

        return given().contentType(ContentType.JSON)
                      .cookies(map)
                      .header("origin", BASE_URL)
                      .header("x-xsrf-token",
                              map.get("XSRF-TOKEN")
                                 .replace("XSRF-TOKEN=", "")
                                 .replace("%3D", "="))
                   //   .body("{\"email\":\"" + MAIN_ADMIN_EMAIL + "\",\"password\":\"" + MAIN_ADMIN_PASSWORD + "\"}")
                .body(new MainAdmin())
                      .when()
                      .post(API_SERVER + "/api/login")
                      .then()
                      .log()
                      .all()
                      .statusCode(200)
                      .extract()
                      .cookies();
    }

    public RequestSpecification loggedAdminSpec() {
        Map<String, String> map = getTokenForAdmin();
        return new RequestSpecBuilder().addCookies(map)
                                       .setContentType(ContentType.JSON)
                                       .addHeader("origin", BASE_URL)
                                       .addHeader("x-xsrf-token",
                                               map.get("XSRF-TOKEN")
                                                  .replace("XSRF-TOKEN=", "")
                                                  .replace("%3D", "="))
                                       .build();
    }

    public User fewfwe() {
        System.out.println(given().spec(loggedAdminSpec())
                                  .when()
                                  .get(API_SERVER + "/api/users")
                                  .then()
                                  .statusCode(200)
                                  .extract()
                                  .asPrettyString());
        return this;
    }

}
