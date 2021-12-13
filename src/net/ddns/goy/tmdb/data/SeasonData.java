package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Arrays;

/**
 * Classe qui contient les donner de une saison
 */
public class SeasonData extends MediaData {
    @JsonProperty("_id")
    private final String _id = "";
    @JsonProperty("air_date")
    private final String airDate = "";
    @JsonProperty("episodes")
    private final EpisodeData[] episodes = {};
    @JsonProperty("name")
    private final String name = "";
    @JsonProperty("overview")
    private final String overview = "";
    @JsonProperty("id")
    private final int id = 0;
    @JsonProperty("poster_path")
    private final String posterPath = "";
    @JsonProperty("season_number")
    private final int seasonNumber = 0;

    public String get_id() {
        return _id;
    }

    public String getAirDate() {
        return airDate;
    }

    public EpisodeData[] getEpisodes() {
        return episodes;
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

    public String getPosterPath() {
        return posterPath;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    @Override
    public String toString() {
        return "SeasonData{" +
                "_id='" + _id + '\'' +
                ", airDate='" + airDate + '\'' +
                ", episodes=" + Arrays.toString(episodes) +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", id=" + id +
                ", posterPath='" + posterPath + '\'' +
                ", seasonNumber=" + seasonNumber +
                '}';
    }
}
