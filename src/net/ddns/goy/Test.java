package net.ddns.goy;

import net.ddns.goy.tmdb.DataGrabber;
import net.ddns.goy.tmdb.data.DataType;
import net.ddns.goy.tmdb.data.TvShowData;
import net.ddns.goy.tmdb.search.TvSearchResult;

import java.io.IOException;

import static net.ddns.goy.tmdb.data.DataType.TvShow;

public class Test {
    public static void main(String[] args) throws IOException {
        // Ma clee API
        String APIkey = "c9cc33dcd0e82e7a734f00feefff424b";
        // Lucifer
        String RandTvID = "63174";
        // Free Guy
        String RandMovID = "550988";
        DataGrabber grabber = new DataGrabber(APIkey);

        // TEST -----------
        // TV ID-------------------------
        TvShowData tvData = grabber.getDataFromID(RandTvID, DataType.TvShow);
        System.out.println(tvData.getName());
        System.out.println(tvData.getNumberOfEpisodes());
        System.out.println(tvData.getNumberOfSeasons());
        System.out.println(tvData.getCreators()[0].getName());
        //-----------------------------
        // TV Search --------------------------------
        TvSearchResult searchTvData = (TvSearchResult) grabber.getDataFromTitle("shark", TvShow);
        if(searchTvData.getResults() != null){
            System.out.println(searchTvData.getResults().length);
            for(int i = 0; i<searchTvData.getResults().length;i++){
                System.out.println((searchTvData.getResults())[i].getName());
            }

        }
        //---------------------------------------------
    }
}
