package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class EpisodeData extends MediaData {
    @JsonProperty("air_date")
    private String airDate;
    @JsonProperty("crew")
    private CrewData[] crew;
    @JsonProperty("episode_number")
    private int episodeNumber;
    @JsonProperty("name")
    private String name;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("id")
    private int id;
    @JsonProperty("production_code")
    private String productionCode;
    @JsonProperty("season_number")
    private int seasonNumber;
    @JsonProperty("still_path")
    private String stillPath;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;

    public String getAirDate() {
        return airDate;
    }

    public CrewData[] getCrew() {
        return crew;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public int getId() {
        return id;
    }

    public String getProductionCode() {
        return productionCode;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public String getStillPath() {
        return stillPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    @Override
    public String toString() {
        return "EpisodeData{" +
                "airDate='" + airDate + '\'' +
                ", crew=" + Arrays.toString(crew) +
                ", episodeNumber=" + episodeNumber +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", id=" + id +
                ", productionCode='" + productionCode + '\'' +
                ", seasonNumber=" + seasonNumber +
                ", stillPath='" + stillPath + '\'' +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}
