package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryData extends MediaData{
    @JsonProperty("iso_3166_1")
    private String iso3166_1;
    @JsonProperty("name")
    private String name;

    public CountryData(){
        _mediaType = DataType.Country;
    }

    public String getIso3166_1() {
        return iso3166_1;
    }

    public String getName() {
        return name;
    }
}
