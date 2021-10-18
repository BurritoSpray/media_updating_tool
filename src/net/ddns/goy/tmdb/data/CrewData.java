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

    public CrewData(){
        _mediaType = DataType.Crew;
    }

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
}
