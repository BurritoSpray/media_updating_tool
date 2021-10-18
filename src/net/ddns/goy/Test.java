package net.ddns.goy;

import net.ddns.goy.tmdb.DataGrabberV2;
import net.ddns.goy.tmdb.data.DataType;
import net.ddns.goy.tmdb.data.TvShowData;
import net.ddns.goy.tmdb.search.SearchResult;

import java.io.IOException;
import java.util.Iterator;

import static net.ddns.goy.tmdb.data.DataType.TvShow;

public class Test {
    public static void main(String[] args) throws IOException {
        // Ma clee API
        String APIkey = "c9cc33dcd0e82e7a734f00feefff424b";
        // Lucifer
        String RandTvID = "63174";
        // Free Guy
        String RandMovID = "550988";
        DataGrabberV2 grabber = new DataGrabberV2();

        // TEST -----------
        // TV ID-------------------------
        TvShowData tvData = (TvShowData) grabber.getData(RandTvID, DataType.TvShow, APIkey, TvShowData.class);
        System.out.println(tvData.getName());
        System.out.println(tvData.getNumberOfEpisodes());
        System.out.println(tvData.getNumberOfSeasons());
        System.out.println(tvData.getCreators()[0].getName());
        //-----------------------------
        // TV Search --------------------------------
        SearchResult searchTvData = grabber.searchData("shark", TvShow, APIkey);
        if(searchTvData.getResults() != null){
            System.out.println(searchTvData.getResults().length);
            for(int i = 0; i<searchTvData.getResults().length;i++){
                System.out.println((searchTvData.getResults())[i].getName());
            }

        }
        //---------------------------------------------
    }
}
