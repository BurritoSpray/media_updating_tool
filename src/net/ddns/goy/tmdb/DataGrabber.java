package net.ddns.goy.tmdb;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.ddns.goy.tmdb.data.*;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class DataGrabber {
    // Declaration du mapper JSON pour parser le contenu des requetes web
    private final ObjectMapper mapper = new ObjectMapper();
    // Clee API pour faire les requete
    private final String APIKey;
    private final String movieDataURL = "https://api.themoviedb.org/3/movie/%s?api_key=%s&language=en-US";
    private final String tvShowDataURL = "https://api.themoviedb.org/3/tv/%s?api_key=%s&language=en-US";
    private final String episodeDataURL = "https://api.themoviedb.org/3/tv/%s/season/%s/episode/%s?api_key=c9cc33dcd0e82e7a734f00feefff424b";

    // ConstructEUR de la classe avec le APIKey
    public DataGrabber(String APIKey){
        // Configuration du mapper
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.APIKey = APIKey;
    }

    // Fonction pour obtenir les donnees d'un film
    public MovieData getMovieData(String mediaID){
        String json;
        try {
            //json = JsonGrabber(new URL(String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s&language=en-US", mediaID, this.APIKey)));
            return mapper.readValue(new URL(String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s&language=en-US", mediaID, this.APIKey)), MovieData.class);
            //return mapper.readValue(json, MovieData.class);
        } catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            return new MovieData();
        }
    }

    // Fonction pour obtenir les donnees d'une serie
    public TvShowData getTvShowData(String mediaID){
        String json;
        try{
            json = this.JsonGrabber(new URL(String.format(this.tvShowDataURL, mediaID, this.APIKey)));
            return mapper.readValue(json, TvShowData.class);
        }catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            return new TvShowData();
        }
    }

    // Fonction pour obtenir les donnees d'un episode
    public EpisodeData getEpisodeData(String mediaID, int season, int episode){
        String json;
        try{
            json = this.JsonGrabber(new URL(String.format(this.episodeDataURL, mediaID, season, episode)));
            return mapper.readValue(json, EpisodeData.class);
        }catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            return new EpisodeData();
        }
    }

//    /**
//     * Fonction pour chercher un media a partir du nom
//     *
//     * @param title Titre de media a rechercher
//     * @param type Type de media a rechercher
//     * @return un objet SearchResult
//     */
//    public <T extends MediaData<T>> SearchResult<T> getDataFromTitle(String title, DataType type) throws IOException {
//        // Lien de base pret a etre formater
//        String baseUrl = "https://api.themoviedb.org/3/search/%s?api_key=%s&query=%s&page=%s";
//        // Lien partiellement formater
//        String formatedURL = String.format(baseUrl, "%s", this.APIKey, title, "%s");
//        // Lien formater au complet
//        String finalUrl = "";
//
//        switch(type){
//            case TvShow -> {
//                finalUrl = String.format(formatedURL, "tv", "%d");
//                //baseUrl = String.format(baseUrl, "tv");
//            }
//            case Season -> {
//                finalUrl = String.format(formatedURL, "season");
//                //baseUrl = String.format(baseUrl, "season");
//            }
//            case Episode -> {
//                finalUrl = String.format(formatedURL, "episode");
//                //baseUrl = String.format(baseUrl, "episode");
//            }
//            case Movie -> {
//                finalUrl = String.format(formatedURL, "movie", "%d");
//                //baseUrl = String.format(baseUrl, "movie");
//            }
//            default -> finalUrl = "";
//        }
//        // Obtient le contenu de la page en String
//        String json = JsonGrabber(new URL(String.format(finalUrl, 1)));
//        // Cree l'objet en fonction du type donnee
//        SearchResult<T> datas;
//        datas = switch(type){
//            case TvShow -> (SearchResult<T>)mapper.readValue(json, TvSearchResult.class);
//            //case Season -> datas = (SeasonData[])mapper.readValue(json, SeasonData[].class);
//            //case Episode -> datas = (EpisodeData[])mapper.readValue(json, EpisodeData[].class);
//            case Movie -> (SearchResult<T>)mapper.readValue(json, MovieSearchResult.class);
//            case Season -> null;
//            case Episode -> null;
//            case Crew -> null;
//            case Company -> null;
//            case Country -> null;
//            case Genre -> null;
//            case Language -> null;
//            case Creator -> null;
//            case Network -> null;
//        };
//        // Verifie les pages pour obtenir tout les resultats
////        if(datas.getTotalPages() > 1){
////            for(int i = 2; i < datas.getTotalPages(); i++){
////                json = JsonGrabber(new URL(String.format(finalUrl, i)));
////                // TODO: 2021-10-24 Check moi sa
////                //datas.addResults(mapper.readValue(json, ));
////            }
////        }
//        // Retourne le resultat de la requete
//        return datas;
//    }

    /**
     * COMPLETEMENT INUTILE!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Fonction qui prend le contenu d'une page web et la transforme en String
     *
     * @param url Lien URL TMDB API 3 Exemple: https://api.themoviedb.org/3/movie/76341?api_key=<<api_key>>
     * @return Contenu de la page web en type String
     * @throws IOException Erreur de connection ou de URL
     */
    private String JsonGrabber(URL url) throws IOException {
        // Cree une connection avec le url
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        // Utilisation d'un buffer pour lire le contenu de la page
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        // Valeur temporaire
        String inputLine;
        // Buffer
        StringBuffer content = new StringBuffer();
        // Lecture du contenu jusqua la derniere ligne
        while((inputLine = in.readLine()) != null){
            content.append(inputLine);
        }
        // Fermeture de la connection
        in.close();
        con.disconnect();
        // retourne le contenu de la page sous forme de String
        return content.toString();
    }

}
