package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenreData extends MediaData{
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    public GenreData(){
        _mediaType = DataType.Genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
