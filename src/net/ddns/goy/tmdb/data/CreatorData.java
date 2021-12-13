package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatorData extends MediaData{
    @JsonProperty("id")
    private int id;
    @JsonProperty("credit_id")
    private String creditID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private int gender;
    @JsonProperty("profile_path")
    private String profilePath;


    public int getId() {
        return id;
    }

    public String getCreditID() {
        return creditID;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public String getProfilePath() {
        return profilePath;
    }

    @Override
    public String toString() {
        return "CreatorData{" +
                "id=" + id +
                ", creditID='" + creditID + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", profilePath='" + profilePath + '\'' +
                '}';
    }
}
