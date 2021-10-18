package net.ddns.goy.tmdb;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.ddns.goy.tmdb.data.DataType;
import net.ddns.goy.tmdb.data.MediaData;
import net.ddns.goy.tmdb.data.MovieData;
import net.ddns.goy.tmdb.data.TvShowData;
import net.ddns.goy.tmdb.search.SearchResult;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DataGrabber {
    // Declaration du mapper JSON pour parser le contenu des requetes web
    private final ObjectMapper mapper = new ObjectMapper();
    public DataGrabber(){
        // Configuration du mapper
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Fonction pour obtenir les infos sur un media a partir de son ID TMDB
     * @param mediaID
     * @param mediaType
     * @param APIkey
     * @return MediaData
     * @throws IOException
     */
    public MediaData getData(String mediaID, DataType mediaType, String APIkey) throws IOException {
        URL _url;
        String json;

        // Dependament du DataType le liens sera different
        switch(mediaType){
            // Si le Type est un film
            case Movie -> _url = new URL(String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s&language=en-US", mediaID, APIkey));
            // Si le type est une serie
            case TvShow -> _url = new URL(String.format("https://api.themoviedb.org/3/tv/%s?api_key=%s&language=en-US", mediaID, APIkey));
            // Pas encore implementer
            case Episode -> _url = new URL("");
            // Lien vide
            default -> _url = new URL("");
        }

        try{
            // Tentative d'obtention des donnee
            json = JsonGrabber(_url);
        }catch(Exception e){
            // Si une erreur a lieu lerreur est imprimer dans la console et json est vide
            System.out.println("Error: " + e.getMessage());
            json = "";
        }


        // TODO: Faire des test avec object mapper pour trouver la maniere la plus optimale
        //Test --------------------------------------------------
        // Option 1 : Fonctionne bien pour l'instant
        MediaData data;
        switch(mediaType){
            case TvShow -> data = mapper.readValue(json, TvShowData.class);
            case Movie -> data = mapper.readValue(json, MovieData.class);
            default -> data = new MediaData();
        }
        return data;
    }

    /**
     * Fonction pour chercher un media a partir du nom
     *
     * @param title Titre de media a rechercher
     * @param type Type de media a rechercher
     * @param APIkey Clee API V3 de TMDB
     * @return un objet SearchResult
     */
    public SearchResult searchData(String title, DataType type, String APIkey) throws IOException {
        // Lien de base pret a etre formater
        String baseUrl = "https://api.themoviedb.org/3/search/%s?api_key=%s&query=%s&page=%s";
        // Lien partiellement formater
        String formatedURL = String.format(baseUrl, "%s", APIkey, title, "%s");
        // Lien formater au complet
        String finalUrl = "";
        SearchResult datas = null;
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
                finalUrl = String.format(formatedURL, "movie");
                //baseUrl = String.format(baseUrl, "movie");
            }
            default -> finalUrl = "";
        }
        // Obtient le contenu de la page en String
        String json = JsonGrabber(new URL(String.format(finalUrl, 1)));
        // Cree l'objet en fonction du type donnee
//        switch(type){
//            case TvShow -> datas = (TvSearchResult)mapper.readValue(json, TvSearchResult.class);
//            //case Season -> datas = (SeasonData[])mapper.readValue(json, SeasonData[].class);
//            //case Episode -> datas = (EpisodeData[])mapper.readValue(json, EpisodeData[].class);
//            case Movie -> datas = mapper.readValue(json, MovieSearchResult.class);
//        }
//        if(datas.getTotalPages() > 1){
//            for(int i = 2; i < datas.getTotalPages(); i++){
//                json = JsonGrabber(new URL(String.format(finalUrl, i)));
//                datas.addResults(mapper.readValue(json, c));
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
