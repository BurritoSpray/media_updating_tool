package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageData extends MediaData{
    @JsonProperty("english_name")
    private String englishName;
    @JsonProperty("iso_639_1")
    private String iso639_1;
    @JsonProperty("name")
    private String name;


    public String getEnglishName() {
        return englishName;
    }

    public String getIso639_1() {
        return iso639_1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "LanguageData{" +
                "englishName='" + englishName + '\'' +
                ", iso639_1='" + iso639_1 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
