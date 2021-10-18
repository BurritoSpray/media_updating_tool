package net.ddns.goy.tmdb;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DataGrabber {

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

        System.out.println(json);
        // Declaration du mapper JSON pour parser le contenu de la requete web
        ObjectMapper mapper = new ObjectMapper();
        // TODO: Faire des test avec object mapper pour trouver la maniere la plus optimale
        //Test --------------------------------------------------
        // Option 1
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MediaData data;
        switch(mediaType){
            case TvShow -> data = mapper.readValue(json, TvShowData.class);
            case Movie -> data = mapper.readValue(json, MovieData.class);
            default -> data = new MediaData();
        }
        // TODO: Nettoyer le code
        //TvShowData tvShow = mapper.readValue(json, TvShowData.class);
        //System.out.println("Show name: " + tvShow._name + "\nSeason count: " + tvShow._numberOfSeasons);


        //-------------------------------------------------------
//        JsonNode jsonNode = mapper.readTree(json);
//        System.out.println(jsonNode.get("name") + " \nSeasons: " + jsonNode.get("seasons"));
        return data;
    }

    /**
     * Fonction qui prend le contenu d'une page web et la transforme en String
     *
     * @param url
     * @return Contenu de la page web en type String
     * @throws IOException
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
