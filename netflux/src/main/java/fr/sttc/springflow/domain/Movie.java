package fr.sttc.springflow.domain;


import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String id;
    @NotNull
    private String title;

    public Movie(String title) {
        this.title = title;
        this.id = UUID.randomUUID().toString();
    }
}
