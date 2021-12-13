package lesson13.Tests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lesson13.Object.Order;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestHttp extends Order {
    public final String URL = "https://petstore.swagger.io/v2/";

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(URL)
            .setBasePath("store")
            .setContentType(ContentType.JSON)
            .build();

    ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(5000L))
            .build();

    @BeforeMethod
    public void setupMethod() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        basePath = "store";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new RequestLoggingFilter(), new RequestLoggingFilter());
    }


    @Test(priority = 1)
    public void checkHTTPGETStatus() {
        given()
                .spec(requestSpecification)
                .when()
        .get("/inventory")
                .then()
                .spec(responseSpecification)
        .statusCode(equalTo(200))
                .log()
                .all();
    }

    @Test(priority = 2)
    public void checkPOSTrequest() {
        Order order = new Order();
        order.setId(10);
        order.setPetId(25);
        order.setQuantity(7);
        order.setShipDate("2021-12-13T20:41:48.594Z");
        order.setStatus("placed");
        order.setComplete(true);
        String jsonObject = new Gson().toJson(order);

        given()
                .spec(requestSpecification)
        .body(jsonObject)
                .when()
        .post("/order")
                .then()
                .spec(responseSpecification)
        .log()
                .all();
    }
}
