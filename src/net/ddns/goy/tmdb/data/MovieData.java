package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Completer cette section avec les information sur https://developers.themoviedb.org/3/movies/get-movie-details
public class MovieData implements MediaData{
    @JsonProperty("adult")
    private boolean adult;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("budget")
    private int budget;
    @JsonProperty("genres")
    private GenreData[] genres;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("id")
    private int id;
    @JsonProperty("imdb_id")
    private String imdbID;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("popularity")
    private double popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("production_companies")
    private CompanyData[] productionCompanies;
    @JsonProperty("production_countries")
    private CountryData[] productionCountries;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("revenue")
    private int revenue;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("spoken_languages")
    private LanguageData[] spokenLanguages;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tagline")
    private String tagline;
    @JsonProperty("title")
    private String title;
    @JsonProperty("video")
    private boolean video;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;

    public MovieData(){
        _mediaType = DataType.Movie;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public int getBudget() {
        return budget;
    }

    public GenreData[] getGenres() {
        return genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getId() {
        return id;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public CompanyData[] getProductionCompanies() {
        return productionCompanies;
    }

    public CountryData[] getProductionCountries() {
        return productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getRevenue() {
        return revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public LanguageData[] getSpokenLanguages() {
        return spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    @Override
    public DataType getMediaType() {
        return DataType.Movie;
    }
}