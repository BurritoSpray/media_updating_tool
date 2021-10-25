package net.ddns.goy.tmdb.search;

import net.ddns.goy.tmdb.data.MediaData;
import net.ddns.goy.tmdb.data.MovieData;
import org.apache.commons.lang3.ArrayUtils;

public final class MovieSearchResult extends SearchResult<MovieData>{

    public MovieSearchResult(){

    }

//    @Override
//    public MovieData[] getResults() {
//        return (MovieData[]) results;
//    }
//    @Override
//    public void addResults(MediaData[] resultsToAdd){
//        results = ArrayUtils.addAll(resultsToAdd, getResults());
//    }
}
