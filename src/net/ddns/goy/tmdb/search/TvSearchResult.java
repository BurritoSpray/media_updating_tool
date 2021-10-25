package net.ddns.goy.tmdb.search;

import net.ddns.goy.tmdb.data.MediaData;
import net.ddns.goy.tmdb.data.TvShowData;
import org.apache.commons.lang3.ArrayUtils;

public final class TvSearchResult extends SearchResult<TvShowData>{

    public TvSearchResult(){

    }

//    @Override
//    public TvShowData[] getResults() {
//        return (TvShowData[])results;
//    }
//
//    @Override
//    void addResults(MediaData[] resultsToAdd) {
//        results = ArrayUtils.addAll(resultsToAdd, getResults());
//    }
}
