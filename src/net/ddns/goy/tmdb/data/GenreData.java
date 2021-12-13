package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenreData extends MediaData{
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GenreData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
