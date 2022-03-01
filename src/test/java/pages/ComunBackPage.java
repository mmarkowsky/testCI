package pages;

import core.Bodys;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.Random;
import static io.restassured.RestAssured.given;

public class ComunBackPage {

    private Response response;
    private Bodys body = new Bodys();

    public void verificarStatusCode(int status, Response resp) {
        Assert.assertEquals(status, resp.getStatusCode());
    }

    public String randomString() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }

    public Response get(String path) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        return response = given().
                header("Content-Type", "application/json").
                get(path).then().
                extract().response();
    }

    public Response delete(String path) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        return response = given().urlEncodingEnabled(false).
                header("Content-Type", "application/json").
                delete(path).
                then().
                extract().response();
    }

    public Response post(String path,String body) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.useRelaxedHTTPSValidation();
        return response = given().
                header("Content-Type", "application/json").
                body(body).
                post(path).
                then().
                extract().response();
    }

    public Response put(String path,String body) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        return response = given().
                urlEncodingEnabled(false).
                header("Content-Type", "application/json").
                body(body).
                put(path).
                then().
                extract().response();
    }

    public Response patch(String path,String body) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        return response = given().
                urlEncodingEnabled(false).
                header("Content-Type", "application/json").
                body(body).
                patch(path).
                then().
                extract().response();
    }
}