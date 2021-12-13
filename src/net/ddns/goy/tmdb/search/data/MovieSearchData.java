package net.ddns.goy.tmdb.search.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class MovieSearchData {
    @JsonProperty("poster_path")
    private String poster_path;
    @JsonProperty("adult")
    private boolean adult;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("release_date")
    private String release_date;
    @JsonProperty("genre_ids")
    private int[] genre_ids;
    @JsonProperty("id")
    private int id;
    @JsonProperty("original_title")
    private String original_title;
    @JsonProperty("original_language")
    private String original_language;
    @JsonProperty("title")
    private String title;
    @JsonProperty("backdrop_path")
    private String backdrop_path;
    @JsonProperty("popularity")
    private double popularity;
    @JsonProperty("vote_count")
    private int vote_count;
    @JsonProperty("video")
    private boolean video;
    @JsonProperty("vote_average")
    private double vote_average;

    public String getPoster_path() {
        return poster_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public int[] getGenre_ids() {
        return genre_ids;
    }

    public int getId() {
        return id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public int getVote_count() {
        return vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVote_average() {
        return vote_average;
    }

    @Override
    public String toString() {
        return "MovieSearchData{" +
                "\nposter_path='" + poster_path + '\'' +
                ", \nadult=" + adult +
                ", \noverview='" + overview + '\'' +
                ", \nrelease_date='" + release_date + '\'' +
                ", \ngenre_ids=" + Arrays.toString(genre_ids) +
                ", \nid=" + id +
                ", \noriginal_title='" + original_title + '\'' +
                ", \noriginal_language='" + original_language + '\'' +
                ", \ntitle='" + title + '\'' +
                ", \nbackdrop_path='" + backdrop_path + '\'' +
                ", \npopularity=" + popularity +
                ", \nvote_count=" + vote_count +
                ", \nvideo=" + video +
                ", \nvote_average=" + vote_average +
                '}';
    }
}
