package net.ddns.goy.tmdb.search.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class TvSearchData {
    @JsonProperty("poster_path")
    private String poster_path;
    @JsonProperty("popularity")
    private double popularity;
    @JsonProperty("id")
    private int id;
    @JsonProperty("backdrop_path")
    private String backdrop_path;
    @JsonProperty("vote_average")
    private double vote_average;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("first_air_date")
    private String firstair_date;
    @JsonProperty("origin_country")
    private String[] origin_country;
    @JsonProperty("genre_ids")
    private int[] genre_ids;
    @JsonProperty("original_language")
    private String original_language;
    @JsonProperty("vote_count")
    private int vote_count;
    @JsonProperty("name")
    private String name;
    @JsonProperty("original_name")
    private String original_name;

    public String getPoster_path() {
        return poster_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public int getId() {
        return id;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public double getVote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public String getFirstair_date() {
        return firstair_date;
    }

    public String[] getOrigin_country() {
        return origin_country;
    }

    public int[] getGenre_ids() {
        return genre_ids;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public int getVote_count() {
        return vote_count;
    }

    public String getName() {
        return name;
    }

    public String getOriginal_name() {
        return original_name;
    }

    @Override
    public String toString() {
        return "TvShowSearchData{" +
                "\nposter_path='" + poster_path + '\'' +
                ", \npopularity=" + popularity +
                ", \nid=" + id +
                ", \nbackdrop_path='" + backdrop_path + '\'' +
                ", \nvote_average=" + vote_average +
                ", \noverview='" + overview + '\'' +
                ", \nfirstair_date='" + firstair_date + '\'' +
                ", \norigin_country=" + Arrays.toString(origin_country) +
                ", \ngenre_ids=" + Arrays.toString(genre_ids) +
                ", \noriginal_language='" + original_language + '\'' +
                ", \nvote_count=" + vote_count +
                ", \nname='" + name + '\'' +
                ", \noriginal_name='" + original_name + '\'' +
                "}\n";
    }
}
