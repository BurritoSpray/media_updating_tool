package net.ddns.goy.tmdb.searchresult;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ddns.goy.tmdb.data.MediaData;
import org.apache.commons.lang3.ArrayUtils;

public class SearchResult{
    @JsonProperty("page")
    private int page;
    @JsonProperty("total_results")
    private int totalResults;
    @JsonProperty("total_pages")
    private int totalPages;
//    @JsonProperty("results")
//    T[] results;

    public SearchResult(){
    }

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

//    public T[] getResults(){
//     return results;
//    }

//    void addResults(T[] resultsToAdd){
//        ArrayUtils.addAll(resultsToAdd, results);
//    }

}
