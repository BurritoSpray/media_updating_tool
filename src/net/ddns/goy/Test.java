package net.ddns.goy;

import net.ddns.goy.tmdb.DataGrabber;
import net.ddns.goy.tmdb.data.*;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        // Ma clee API
        String APIkey = "c9cc33dcd0e82e7a734f00feefff424b";
        // Lucifer
        String RandTvID = "63174";
        // Free Guy
        String RandMovID = "550988";
        DataGrabber grabber = new DataGrabber(APIkey);

        // Test Film
        MovieData md = grabber.getMovieData(RandMovID);
        System.out.println("Movie name : " + md.getOriginalTitle());

//        String TvShowTestID = "71446"; // La casa de papel
//        TvShowData tvShowData = grabber.getTvShowData(TvShowTestID);
//        System.out.println("TV Show name : " + tvShowData.getName());
//        System.out.println("Episode count : " + tvShowData.getNumberOfEpisodes());
//        System.out.println("Season count : " + tvShowData.getNumberOfSeasons());
//        for(TvShowSeasonData s : tvShowData.getSeasons()){
//            for(int i = 1; i < s.getEpisode_count(); i++){
//                if(s.getSeason_number() != 0) {
//                    EpisodeData ed = grabber.getEpisodeData(TvShowTestID, s.getSeason_number(), i);
//                    System.out.println(ed);
//                }
//            }
//        }







//        int sCount = 0;
//        for(SeasonData sd : tvShowData.getSeasons()){
//            sCount++;
//            int eCount = 0;
//            for(EpisodeData ed : sd.getEpisodes()){
//                eCount++;
//                System.out.println("S"+ sCount + "E" + eCount + " : " + ed.getName());
//            }
//        }

        // TEST -----------
        // TV ID-------------------------
//        TvShowData tvData = grabber.getDataFromID(RandTvID, DataType.TvShow);
//        System.out.println(tvData.getName());
//        System.out.println(tvData.getNumberOfEpisodes());
//        System.out.println(tvData.getNumberOfSeasons());
//        System.out.println(tvData.getCreators()[0].getName());
        //-----------------------------
        // TV Search --------------------------------
//        TvSearchResult searchTvData = (TvSearchResult) grabber.getDataFromTitle("shark", TvShow);
//        if(searchTvData.getResults() != null){
//            System.out.println(searchTvData.getResults().length);
//            for(int i = 0; i<searchTvData.getResults().length;i++){
//                System.out.println((searchTvData.getResults())[i].getName());
//            }

        //}
        //---------------------------------------------
    }
}
