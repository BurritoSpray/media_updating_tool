package net.ddns.goy.tmdb.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ddns.goy.tmdb.data.MediaData;
import net.ddns.goy.tmdb.data.TvShowData;
import org.apache.commons.lang3.ArrayUtils;

public class SearchResult{
    @JsonProperty("page")
    private int page;
    @JsonProperty("total_results")
    private int totalResults;
    @JsonProperty("total_pages")
    private int totalPages;
    private MediaData[] results;

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public MediaData[] getResults() {return results;}

    public void addResults(MediaData[] resultsToAdd){results = ArrayUtils.addAll(this.results, resultsToAdd);}
}
