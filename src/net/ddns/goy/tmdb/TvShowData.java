package net.ddns.goy.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe qui contient les donnee d'une serie
 */
public class TvShowData extends MediaData {
    @JsonProperty("name")
    public String _name;
    @JsonProperty("imdbID")
    public String _imdbID;
    @JsonProperty("number_of_episodes")
    public int _numberOfEpisodes;
    @JsonProperty("number_of_seasons")
    public int _numberOfSeasons;
    @JsonProperty("seasons")
    public SeasonData[] _seasons;

    public TvShowData(){
        _mediaType = DataType.TvShow;
    }

//    public TvShowData(String title, String imdbID, int numberOfEpisodes, int numberOfSeasons, SeasonData[] seasons){
//        _title = title;
//        _imdbID = imdbID;
//        _numberOfEpisodes = numberOfEpisodes;
//        _numberOfSeasons = numberOfSeasons;
//        _seasons = seasons;
//    }

}
