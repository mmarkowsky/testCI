package apiTest;

import core.Bodys;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ComunBackPage;

public class apiExamplesTest {

    private Bodys body = new Bodys();
    private Response response;
    private ComunBackPage comunBackPage = new ComunBackPage();

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

//        String port = System.getProperty("server.port");
//        if (port == null) {
//            RestAssured.port = Integer.valueOf(8080);
//        }
//        else{
//            RestAssured.port = Integer.valueOf(port);
//        }
//
//        String basePath = System.getProperty("server.base");
//        if(basePath==null){
//            basePath = "/rest-garage-sample/";
//        }
//        RestAssured.basePath = basePath;
//
//        String baseHost = System.getProperty("server.host");
//        if(baseHost==null){
//            baseHost = "http://localhost";
//        }
//        RestAssured.baseURI = baseHost;

    }

    @Test
    public void getRequest() {
        response = comunBackPage.get("/posts");

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }

    @Test
    public void getRequestWithQueryParam() {
        response = comunBackPage.get("/comments?postId=2");

        Assertions.assertEquals(200, response.statusCode());
        //response.then().body("email[3]",is("Meghan_Littel@rene.us"));
        Assertions.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
    }

    @Test
    public void postRequest() {
        response = comunBackPage.post("/posts",body.requestBodyPost);

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("Testando titulo", response.jsonPath().getString("title"));
        Assertions.assertEquals("Testando comentario", response.jsonPath().getString("body"));
        Assertions.assertEquals("18", response.jsonPath().getString("userId"));
        Assertions.assertEquals("101", response.jsonPath().getString("id"));
    }

    @Test
    public void putRequest() {
        response = comunBackPage.put("/posts/1",body.requestBodyPut);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("foo", response.jsonPath().getString("title"));
        Assertions.assertEquals("baz", response.jsonPath().getString("body"));
        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
        Assertions.assertEquals("1", response.jsonPath().getString("id"));
    }

    @Test
    public void deleteRequest() {
        response = comunBackPage.delete("/posts/1");

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void patchRequest() {
        response = comunBackPage.patch("/posts/1", body.requestBodyPatch);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("bax", response.jsonPath().getString("title"));
        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
        Assertions.assertEquals("1", response.jsonPath().getString("id"));
    }

    @Test
    public void validarDTOPost() {
        response = comunBackPage.post("/posts",body.requestBodyPost);

        Post postAtual = response.as(Post.class);
        Post postEsperado = new Post("Testando titulo", "Testando comentario","18");

        Assertions.assertEquals(postEsperado.getTitle(), postAtual.getTitle());
        Assertions.assertEquals(postEsperado.getBody(), postAtual.getBody());
        Assertions.assertEquals(postEsperado.getUserId(), postAtual.getUserId());

        //System.out.println(response.jsonPath().getString("title"));
        //System.out.println(response.path("$"));
        //System.out.println(postAtual.getTitle());
    }
}
