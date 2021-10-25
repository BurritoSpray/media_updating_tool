package net.ddns.goy;

import net.ddns.goy.media.TvShow;
import net.ddns.goy.tmdb.DataGrabber;
import net.ddns.goy.tmdb.data.DataType;
import net.ddns.goy.tmdb.data.MovieData;
import net.ddns.goy.tmdb.data.SeasonData;
import net.ddns.goy.tmdb.data.TvShowData;
import net.ddns.goy.tmdb.search.MovieSearchResult;
import net.ddns.goy.tmdb.search.SearchResult;
import net.ddns.goy.tmdb.search.TvSearchResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        TvShow test = new TvShow("\\\\192.168.2.61\\Plex\\Séries en anglais\\Better Call Saul");
//        ListIterator<Season> iter = test.getSeasonList().listIterator();
//        System.out.println(test.getShowName() + " :");
//        while(iter.hasNext()){
//            System.out.println(iter.next().toString());
//        }
        String path = "\\\\192.168.2.61\\Plex\\Séries en anglais";
        List<TvShow> showList = new ArrayList<>();
        File f = new File(path);
        for(String file : f.list()){
            File tempF = new File(path + "\\" + file);
            if(tempF.isDirectory()){
                showList.add(new TvShow(tempF.getPath()));
            }
        }
        for(TvShow show : showList){
            System.out.printf("%S : ", show.getShowName());
            System.out.println(show);
        }


//                System.out.printf("Season count = %d", test.getSeasonCount());
//        Episode my_episode = new Episode("Z:\\Séries en anglais\\Better Call Saul\\Better Call Saul Season 3 Complete 720p HDTV x264 [i_c]\\Better Call Saul S03E01 Mabel.mkv");
//        System.out.printf("Episode No : %d\nSeason No: %d", my_episode.getEpisodeNo(), my_episode.getSeasonNo());
//        //Episode test = new Episode("test", 1, "American.Gods.S01E01.1080p.BluRay.x264-SHORTBREHD.mkv");
    }

    // Section test pour le code en lien avec l'API TMDB
    public static class Test {
        public static void main(String[] args) {
            try {
                String mediaID = "81356";
                String APIkey = "c9cc33dcd0e82e7a734f00feefff424b";
                DataGrabber dg = new DataGrabber(APIkey);
                TvShowData show = dg.getDataFromID(mediaID, DataType.TvShow);
                System.out.println("Show name: " + show.getName() + "\nEpisode count: " + show.getNumberOfEpisodes() + "\nSeasons: " + show.getNumberOfSeasons());
                for(SeasonData d : show.getSeasons()){
                    System.out.println(d.getName());
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }

        }
    }

    public static class SearchTest {
        public static void main(String[] args) throws IOException {
            // Declaration de variable
            final String APIkey = "c9cc33dcd0e82e7a734f00feefff424b";
            String userInput = "";
            DataType mediaType = DataType.Episode;
            SearchResult<MovieData> mDatas = new MovieSearchResult();
            SearchResult<TvShowData> tvDatas = new TvSearchResult();
            Scanner scan = new Scanner(System.in);
            // Scan entree utilisateur
            int temp = -1;
            while(temp < 0){
                System.out.println("Recherche de media : \n1) Film\n2) Série\n0) Quitter");
                switch(scan.nextInt()) {
                    case 0 -> {
                        return;
                    }
                    case 1 -> {
                        mediaType = DataType.Movie;
                        temp = 1;
                    }
                    case 2 -> {
                        mediaType = DataType.TvShow;
                        temp = 2;
                    }
                    default -> {
                        mediaType = DataType.Episode;
                    }

                }
            }
            switch(mediaType){
                case Movie -> System.out.print("Nom du film: ");
                case TvShow -> System.out.print("Nom de la série: ");
            }
            scan.nextLine();
            userInput = scan.nextLine();
            // utilise l'entree pour faire une recherche
            try {
                DataGrabber grabber = new DataGrabber(APIkey);
                switch (mediaType) {
                    case Movie -> mDatas = grabber.getDataFromTitle(userInput, mediaType);
                    case TvShow -> tvDatas = grabber.getDataFromTitle(userInput, mediaType);
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
                return;
            }
//            DataGrabber grabber = new DataGrabber(APIkey);
//            switch(mediaType) {
//                case Movie -> mDatas = grabber.getDataFromTitle(userInput, mediaType);
//                case TvShow -> tvDatas = grabber.getDataFromTitle(userInput, mediaType);
//            }



            // Numerote et affiche les resultat ou affiche un erreur si aucun resultat
            if (mediaType == DataType.Movie) {
                for (int i = 0; i < mDatas.getResults().length; i++) {
                    System.out.printf("%d) %s \n", i, mDatas.getResults()[i].getTitle());
                }
            } else if (mediaType == DataType.TvShow) {
                for (int i = 0; i < tvDatas.getResults().length; i++) {
                    System.out.printf("%d) %s (%s)\n", i, tvDatas.getResults()[i].getName(), !"".equals(tvDatas.getResults()[i].getFirstAirDate()) ? tvDatas.getResults()[i].getFirstAirDate() : "Date non disponible");
                }
            }

            // L'utilisateur choisi un numero de resultat pour afficher les infos
            System.out.print("Veuiller choisir un resultat: ");
            int choice = scan.nextInt();
            if(mediaType == DataType.TvShow)
                System.out.printf("TV Show name: %s\nFirst air date: %s\nSeason count: %d\nTotal episodes count: %d\nGenre: %s", tvDatas.getResults()[choice].getName(), tvDatas.getResults()[choice].getFirstAirDate(), tvDatas.getResults()[choice].getNumberOfSeasons(),
                        tvDatas.getResults()[choice].getNumberOfEpisodes(),
                        Arrays.stream(tvDatas.getResults()[choice].getGenres()).toList());
            // Si ce n'est pas le bon choix il peux retourner en arriere pour en choisir un autre ou quitter
        }

    }
}

