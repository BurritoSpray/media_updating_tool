package net.ddns.goy.tmdb.search.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ddns.goy.tmdb.search.data.TvSearchData;

public final class TvSearchResult extends SearchResult{
    @JsonProperty("results")
    TvSearchData[] results;

    public TvSearchData[] getResults() {
        return results;
    }
}
