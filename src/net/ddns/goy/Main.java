package net.ddns.goy;

import net.ddns.goy.media.TvShow;
import net.ddns.goy.tmdb.DataGrabber;
import net.ddns.goy.tmdb.DataType;
import net.ddns.goy.tmdb.SeasonData;
import net.ddns.goy.tmdb.TvShowData;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                DataGrabber dg = new DataGrabber();
                TvShowData show = (TvShowData) dg.getData(mediaID, DataType.TvShow, APIkey);
                System.out.println("Show name: " + show._name + "\nEpisode count: " + show._numberOfEpisodes + "\nSeasons: " + show._numberOfSeasons);
                for(SeasonData d : show._seasons){
                    System.out.println(d._name);
                }
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }

        }
    }
}
