package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryData extends MediaData{
    @JsonProperty("iso_3166_1")
    private String iso3166_1;
    @JsonProperty("name")
    private String name;


    public String getIso3166_1() {
        return iso3166_1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CountryData{" +
                "iso3166_1='" + iso3166_1 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
