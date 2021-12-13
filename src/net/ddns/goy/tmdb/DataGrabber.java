package net.ddns.goy.tmdb;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.ddns.goy.media.serie.Season;
import net.ddns.goy.tmdb.data.*;
import net.ddns.goy.tmdb.search.result.CompanySearchResult;
import net.ddns.goy.tmdb.search.result.MovieSearchResult;
import net.ddns.goy.tmdb.search.result.TvSearchResult;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DataGrabber {
    // Declaration du mapper JSON pour parser le contenu des requetes web
    private final ObjectMapper mapper = new ObjectMapper();
    // Clee API pour faire les requete
    private final String APIKey;
    private final String movieDataURL = "https://api.themoviedb.org/3/movie/%s?api_key=%s&language=en-US";
    private final String tvShowDataURL = "https://api.themoviedb.org/3/tv/%s?api_key=%s&language=en-US";
    private final String episodeDataURL = "https://api.themoviedb.org/3/tv/%s/season/%s/episode/%s?api_key=c9cc33dcd0e82e7a734f00feefff424b";
    private final String seasonDataURL = "https://api.themoviedb.org/3/tv/%s/season/%s?api_key=%s&language=en-US";

    // Constructeur de la classe avec le APIKey
    public DataGrabber(String APIKey){
        // Configuration du mapper
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.APIKey = APIKey;
    }

    // Fonction pour obtenir les donnees d'un film
    public MovieData getMovieByID(String mediaID){
        try {
            return mapper.readValue(new URL(String.format(this.movieDataURL, mediaID, this.APIKey)), MovieData.class);
        } catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            return new MovieData();
        }
    }

    // Fonction pour obtenir les donnees d'une serie
    public TvShowData getTvShowByID(String mediaID){
        try{
            return mapper.readValue(new URL(String.format(this.tvShowDataURL, mediaID, this.APIKey)), TvShowData.class);
        }catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            return new TvShowData();
        }
    }

    // Fonction pour obtenir les donnees d'une saison a partir de son ID
    public SeasonData getSeasonByID(String mediaID, int season){
        try{
            return mapper.readValue(new URL(String.format(this.seasonDataURL, mediaID, season, this.APIKey)), SeasonData.class);
        }catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            return new SeasonData();
        }
    }

    // Fonction pour obtenir les donnees d'un episode
    public EpisodeData getEpisodeByID(String mediaID, int season, int episode){
        try{
            return mapper.readValue(new URL(String.format(this.episodeDataURL, mediaID, season, episode)), EpisodeData.class);
        }catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            return new EpisodeData();
        }
    }

    // Fonction pour faire une recher de film a partir du titre
    // TODO: 2021-12-12 Ajouter le APIKey dans la creation du searchResult pour pouvoir querry les autre pages directement dans l'objet
    public MovieSearchResult searchMovieByTitle(String title){
        String movieBaseURL = "https://api.themoviedb.org/3/search/movie?api_key=%s&query=%s&page=%s";
        try {
            return mapper.readValue(new URL(String.format(movieBaseURL, this.APIKey, title, 1)), MovieSearchResult.class);
        }catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            return new MovieSearchResult();
        }
    }

    // Fonction pour faire une recherche de tvShow a partir du titre
    public TvSearchResult searchTvShowByTitle(String title){
        String tvShowBaseURL = "https://api.themoviedb.org/3/search/tv?api_key=%s&query=%s&page=%s";
        try{
            return mapper.readValue(new URL(String.format(tvShowBaseURL, this.APIKey, title, 1)), TvSearchResult.class);
        }catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            return new TvSearchResult();
        }
    }

    // Fonction pour faire une recherche par nom de compagnie
    public CompanySearchResult searchCompanyByTitle(String title){
        String episodeBaseURL = "https://api.themoviedb.org/3/search/company?api_key=%s&query=%s&page=%s";
        try{
            return mapper.readValue(new URL(String.format(episodeBaseURL, this.APIKey, title, 1)), CompanySearchResult.class);
        }catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            return new CompanySearchResult();
        }
    }

}
