package net.ddns.goy.tmdb.search.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanySearchData {
    @JsonProperty("id")
    private int id;
    @JsonProperty("logo_path")
    private String logo_path;
    @JsonProperty("name")
    private String name;

    public int getId() {
        return id;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CompanySearchData{" +
                "\nid=" + id +
                ", \nlogo_path='" + logo_path + '\'' +
                ", \nname='" + name + '\'' +
                "}\n";
    }
}
