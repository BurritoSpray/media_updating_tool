package net.ddns.goy.tmdb.search.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.ddns.goy.tmdb.search.data.CompanySearchData;

import java.util.Arrays;

public class CompanySearchResult {
    @JsonProperty("page")
    private int page;
    @JsonProperty("results")
    private CompanySearchData[] results;
    @JsonProperty("total_pages")
    private int total_pages;
    @JsonProperty("total_results")
    private int total_results;

    public int getPage() {
        return page;
    }

    public CompanySearchData[] getResults() {
        return results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    @Override
    public String toString() {
        return "CompanySearchResult{" +
                "\npage=" + page +
                ", \nresults=" + Arrays.toString(results) +
                ", \ntotal_pages=" + total_pages +
                ", \ntotal_results=" + total_results +
                "}\n";
    }
}
