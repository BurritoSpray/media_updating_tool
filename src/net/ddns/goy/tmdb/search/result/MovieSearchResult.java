package net.ddns.goy.tmdb.search.result;


import com.fasterxml.jackson.annotation.JsonProperty;
import net.ddns.goy.tmdb.search.data.MovieSearchData;

public final class MovieSearchResult extends SearchResult{

    @JsonProperty("results")
    private MovieSearchData[] results;

    public MovieSearchData[] getResults() {return results;}

}
