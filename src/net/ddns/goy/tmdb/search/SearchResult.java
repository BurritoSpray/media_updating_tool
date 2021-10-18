package net.ddns.goy.tmdb.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ddns.goy.tmdb.data.MediaData;
import net.ddns.goy.tmdb.data.TvShowData;
import org.apache.commons.lang3.ArrayUtils;

public interface SearchResult{
/*    @JsonProperty("page")
    private int page;
    @JsonProperty("total_results")
    private int totalResults;
    @JsonProperty("total_pages")
    private int totalPages;
    private MediaData[] results;*/

    public int getPage();

    public int getTotalPages();

    public int getTotalResults();

    public MediaData[] getResults();

    public void addResults(MediaData[] resultsToAdd);
}
