package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

    private String title;
    private String body;
    private String userId;

    public Post(@JsonProperty("titulo") String titulo,
                @JsonProperty("comentario") String comentario,
                @JsonProperty("userId") String userId) {
        this.title = titulo;
        this.body = comentario;
        this.userId = userId;
    }
}
