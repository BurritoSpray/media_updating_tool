package net.ddns.goy.tmdb;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.ddns.goy.tmdb.data.DataType;
import net.ddns.goy.tmdb.data.MediaData;
import net.ddns.goy.tmdb.data.MovieData;
import net.ddns.goy.tmdb.data.TvShowData;
import net.ddns.goy.tmdb.search.MovieSearchResult;
import net.ddns.goy.tmdb.search.SearchResult;
import net.ddns.goy.tmdb.search.TvSearchResult;

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

    // Construction de la classe avec la clee
    public DataGrabber(String APIKey){
        // Configuration du mapper
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.APIKey = APIKey;
    }


    /**
     * Fonction pour obtenir les infos sur un media a partir de son ID TMDB
     * @param mediaID
     * @param dataType
     * @return data
     * @throws IOException
     */
    public <T extends MediaData<T>> T getDataFromID(String mediaID, DataType dataType) throws IOException {
        URL url;
        String json;

        // Dependament du DataType le liens sera different
        url = switch(dataType){
            // Si le Type est un film
            case Movie -> new URL(String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s&language=en-US", mediaID, this.APIKey));
            // Si le type est une serie
            case TvShow -> new URL(String.format("https://api.themoviedb.org/3/tv/%s?api_key=%s&language=en-US", mediaID, this.APIKey));
            // Pas encore implementer
            case Episode -> new URL("");
            // Lien vide
            default -> new URL("");
        };

        try{
            // Tentative d'obtention des donnee
            json = JsonGrabber(url);
        }catch(Exception e){
            // Si une erreur a lieu lerreur est imprimer dans la console et json est vide
            System.out.println("Error: " + e.getMessage());
            json = "";
        }


        // TODO: Faire des test avec object mapper pour trouver la maniere la plus optimale
        //Test --------------------------------------------------
        // Option 1 : Fonctionne bien pour l'instant
        T data;
        data = switch(dataType){
            case TvShow -> (T)mapper.readValue(json, TvShowData.class);
            case Movie -> (T) mapper.readValue(json, MovieData.class);
            default -> null;
        };
        return data;
    }

    /**
     * Fonction pour chercher un media a partir du nom
     *
     * @param title Titre de media a rechercher
     * @param type Type de media a rechercher
     * @return un objet SearchResult
     */
    public <T extends MediaData<T>> SearchResult<T> getDataFromTitle(String title, DataType type) throws IOException {
        // Lien de base pret a etre formater
        String baseUrl = "https://api.themoviedb.org/3/search/%s?api_key=%s&query=%s&page=%s";
        // Lien partiellement formater
        String formatedURL = String.format(baseUrl, "%s", this.APIKey, title, "%s");
        // Lien formater au complet
        String finalUrl = "";

        switch(type){
            case TvShow -> {
                finalUrl = String.format(formatedURL, "tv", "%d");
                //baseUrl = String.format(baseUrl, "tv");
            }
            case Season -> {
                finalUrl = String.format(formatedURL, "season");
                //baseUrl = String.format(baseUrl, "season");
            }
            case Episode -> {
                finalUrl = String.format(formatedURL, "episode");
                //baseUrl = String.format(baseUrl, "episode");
            }
            case Movie -> {
                finalUrl = String.format(formatedURL, "movie", "%d");
                //baseUrl = String.format(baseUrl, "movie");
            }
            default -> finalUrl = "";
        }
        // Obtient le contenu de la page en String
        String json = JsonGrabber(new URL(String.format(finalUrl, 1)));
        // Cree l'objet en fonction du type donnee
        SearchResult<T> datas;
        datas = switch(type){
            case TvShow -> (SearchResult<T>)mapper.readValue(json, TvSearchResult.class);
            //case Season -> datas = (SeasonData[])mapper.readValue(json, SeasonData[].class);
            //case Episode -> datas = (EpisodeData[])mapper.readValue(json, EpisodeData[].class);
            case Movie -> (SearchResult<T>)mapper.readValue(json, MovieSearchResult.class);
            case Season -> null;
            case Episode -> null;
            case Crew -> null;
            case Company -> null;
            case Country -> null;
            case Genre -> null;
            case Language -> null;
            case Creator -> null;
            case Network -> null;
        };
        // Verifie les pages pour obtenir tout les resultats
//        if(datas.getTotalPages() > 1){
//            for(int i = 2; i < datas.getTotalPages(); i++){
//                json = JsonGrabber(new URL(String.format(finalUrl, i)));
//                // TODO: 2021-10-24 Check moi sa
//                //datas.addResults(mapper.readValue(json, ));
//            }
//        }
        // Retourne le resultat de la requete
        return datas;
    }

    /**
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
