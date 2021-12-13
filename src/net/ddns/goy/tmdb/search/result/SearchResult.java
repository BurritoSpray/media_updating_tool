package net.ddns.goy.tmdb.search.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ddns.goy.tmdb.data.MediaData;
import org.apache.commons.lang3.ArrayUtils;

public class SearchResult{
    @JsonProperty("page")
    private int page;
    @JsonProperty("total_results")
    private int total_results;
    @JsonProperty("total_pages")
    private int total_pages;

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public int getTotalResults() {
        return total_results;
    }
}
