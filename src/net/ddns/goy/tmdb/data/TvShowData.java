package net.ddns.goy.tmdb.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe qui contient les donnee d'une serie
 * Correspond a GET /tv/{tv_id}
 */
public class TvShowData extends MediaData {
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("created_by")
    private CreatorData[] creators;
    @JsonProperty("episode_run_time")
    private int[] episodeRunTime;
    @JsonProperty("first_air_date")
    private String firstAirDate;
    @JsonProperty("genres")
    private GenreData[] genres = {};
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("id")
    private int id;
    @JsonProperty("in_production")
    private boolean inProduction;
    @JsonProperty("languages")
    private String[] languages;
    @JsonProperty("last_air_date")
    private String lastAirDate;
    @JsonProperty("last_episode_to_air")
    private EpisodeData lastEpisodeToAir;
    @JsonProperty("name")
    private String name;
    @JsonProperty("networks")
    private NetworkData[] networks;
    @JsonProperty("number_of_episodes")
    private int numberOfEpisodes;
    @JsonProperty("number_of_seasons")
    private int numberOfSeasons;
    @JsonProperty("origin_country")
    private String[] originCountry;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_name")
    private String originalName;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("popularity")
    private int popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("production_companies")
    private CompanyData[] productionCompanies;
    @JsonProperty("production_countries")
    private CountryData[] productionCountries;
    @JsonProperty("seasons")
    private SeasonData[] seasons;
    @JsonProperty("spoken_languages")
    private LanguageData[] spokenLanguages;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tagline")
    private String tagline;
    @JsonProperty("type")
    private String type;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;

    // Constructeur par defaut de la classe
    public TvShowData(){
        _mediaType = DataType.TvShow;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public CreatorData[] getCreators() {
        return creators;
    }

    public int[] getEpisodeRunTime() {
        return episodeRunTime;
    }

    public String getFirstAirDate() {
        return firstAirDate;
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

    public boolean isInProduction() {
        return inProduction;
    }

    public String[] getLanguages() {
        return languages;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public EpisodeData getLastEpisodeToAir() {
        return lastEpisodeToAir;
    }

    public String getName() {
        return name;
    }

    public NetworkData[] getNetworks() {
        return networks;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public String[] getOriginCountry() {
        return originCountry;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getOverview() {
        return overview;
    }

    public int getPopularity() {
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

    public SeasonData[] getSeasons() {
        return seasons;
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

    public String getType() {
        return type;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }
}