package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrewData extends MediaData{
    @JsonProperty("id")
    private int id;
    @JsonProperty("credit_id")
    private String creditID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("departement")
    private String departement;
    @JsonProperty("job")
    private String job;
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

    public String getDepartement() {
        return departement;
    }

    public String getJob() {
        return job;
    }

    public String getProfilePath() {
        return profilePath;
    }

    @Override
    public String toString() {
        return "CrewData{" +
                "id=" + id +
                ", creditID='" + creditID + '\'' +
                ", name='" + name + '\'' +
                ", departement='" + departement + '\'' +
                ", job='" + job + '\'' +
                ", profilePath='" + profilePath + '\'' +
                '}';
    }
}
