package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyData extends MediaData{
    @JsonProperty("description")
    private String description;
    @JsonProperty("headquarters")
    private String headquarters;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("id")
    private int id;
    @JsonProperty("logo_path")
    private String logoPath;
    @JsonProperty("name")
    private String name;
    @JsonProperty("origin_country")
    private String originCountry;
    @JsonProperty("parent_company")
    private CompanyData parentCompany;

    public CompanyData(){
        _mediaType = DataType.Company;
    }

    public String getDescription() {
        return description;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getId() {
        return id;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public CompanyData getParentCompany() {
        return parentCompany;
    }
}
