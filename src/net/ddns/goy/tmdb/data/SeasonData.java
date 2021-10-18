package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe qui contient les donner de une saison
 */
public class SeasonData extends MediaData {
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("air_date")
    private String airDate;
    @JsonProperty("episodes")
    private EpisodeData[] episodes;
    @JsonProperty("name")
    private String name;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("id")
    private int id;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("season_number")
    private int seasonNumber;

    public SeasonData(){
        _mediaType = DataType.Season;
    }

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
}
