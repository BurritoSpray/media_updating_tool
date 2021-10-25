package net.ddns.goy.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe qui contient les donner de une saison
 */
public class SeasonData extends TvShowData{
    @JsonProperty("air_date")
    public String _airDate;
    @JsonProperty("episode_count")
    public int _episodeCount;
    @JsonProperty("id")
    public int _id;
    @JsonProperty("name")
    public String _name;
    @JsonProperty("overview")
    public String _overview;
    @JsonProperty("poster_path")
    public String _posterPath;
    @JsonProperty("season_number")
    public int _seasonNumber;

    public SeasonData(){
        _mediaType = DataType.Season;
    }
}
