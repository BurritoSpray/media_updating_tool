package net.ddns.goy.tmdb;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.ddns.goy.tmdb.data.DataType;
import net.ddns.goy.tmdb.data.MediaData;
import net.ddns.goy.tmdb.data.TvShowData;
import net.ddns.goy.tmdb.search.SearchResult;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DataGrabberV2 {
    // Declaration du mapper JSON pour parser le contenu des requetes web
    private final ObjectMapper mapper = new ObjectMapper();
    public DataGrabberV2(){
        // Configuration du mapper
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Fonction pour obtenir les infos sur un media a partir de son ID TMDB
     * @param mediaID
     * @param dataType
     * @param APIkey
     * @return data
     * @throws IOException
     */
    public MediaData getData(String mediaID, DataType dataType, String APIkey, Class<? extends MediaData> c) throws IOException {
        URL url;
        String json;

        // Dependament du DataType le liens sera different
        switch(dataType){
            // Si le Type est un film
            case Movie -> url = new URL(String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s&language=en-US", mediaID, APIkey));
            // Si le type est une serie
            case TvShow -> url = new URL(String.format("https://api.themoviedb.org/3/tv/%s?api_key=%s&language=en-US", mediaID, APIkey));
            // Pas encore implementer
            case Episode -> url = new URL("");
            // Lien vide
            default -> url = new URL("");
        }

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
        MediaData data = mapper.readValue(json, c);
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
        // Lien formater au complet
        String finalUrl = "";
        int page = 1;
        int totalPages = 0;
        switch(type){
            case TvShow -> finalUrl = String.format(baseUrl, "tv", APIkey, title, "%d");
            case Movie -> finalUrl = String.format(baseUrl, "movie", APIkey, title, "%d");
        }
        // Obtient le contenu de la page en String
        String json = JsonGrabber(new URL(String.format(finalUrl, page)));
        // on obtient le nombre de page total pour commencer
        SearchResult data = mapper.readValue(json, SearchResult.class);
        if(data.getTotalPages() > 1){
            totalPages = data.getTotalPages();
            for(page+=1;totalPages >= page; page++){
                json = JsonGrabber(new URL(String.format(finalUrl, page)));
                data.addResults(mapper.readValue(json, SearchResult.class).getResults());
            }
        }
        // Cree l'objet en fonction du type donnee
        // Retourne le resultat de la requete
        return data;
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
