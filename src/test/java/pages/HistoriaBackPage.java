package pages;

import io.restassured.response.Response;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class HistoriaBackPage {
    private Response response;
    private ComunBackPage comunBackPage = new ComunBackPage();
    private String path;

    public void enviarUrl(String url) {
        path = url;
    }

    public Response enviarIdPost(int i) {
        return response = comunBackPage.get(path+i);
    }

    public void verificarInformacoesPost() {
        List<String> body = response.jsonPath().getList("$");
        for (int i = 0; i < body.size(); i++) {
            String postId  = response.jsonPath().getString("["+i+"].postId");
            assertEquals(postId, "3");
        }
        assertThat(body.size(), equalTo(5));
    }
}