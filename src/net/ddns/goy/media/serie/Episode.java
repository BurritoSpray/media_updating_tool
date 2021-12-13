package net.ddns.goy.media.serie;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Episode {

    // Declaration des variables prive
    private int _episodeNo;
    private int _seasonNo;
    private String _showName;
    private String _filePath;

    // Initialisation de la classe
    public Episode(String filePath){
        File f = new File(filePath);
        var regexResult = Pattern.compile("(.+)(s[0-9]+)(e[0-9]+)(.+$)", Pattern.CASE_INSENSITIVE).matcher(f.getName());
        if(regexResult.find()){
            _showName = regexResult.group(1);
            _episodeNo = Integer.parseInt(regexResult.group(2).replaceAll("[a-zA-Z]",""));
            _seasonNo = Integer.parseInt(regexResult.group(3).replaceAll("[a-zA-Z]", ""));
            _filePath = f.getPath();
        }
    }

    /*
    *
    *   La classe Episode prend un fichier ou un dossier contenant un fichier et scan son nom pour determiner:
    *   Le numero depisode et la saison si elle n'est pas fournis lors de l'initialisation
    *
     */

    // Initialisation avec les parametre showName, seasonNo, filePath
    public Episode(String showName, int seasonNo, int episodeNo, String filePath) {
        // Assignation des valeurs
        _showName = showName;
        _filePath = filePath;
        _seasonNo = seasonNo;
        _episodeNo = episodeNo;

        // Determination du numero depisode
//        File f = new File(filePath);
//        var regexResult = Pattern.compile("e\\d\\d", Pattern.CASE_INSENSITIVE).matcher(f.getName());
//        if(regexResult.find()){
//            _episodeNo = Integer.parseInt(regexResult.group(0).replaceAll("[a-zA-Z]", ""));
//        }

    }

    public int getEpisodeNo(){
        return _episodeNo;
    }

    public int getSeasonNo(){
        return _seasonNo;
    }

    public String getShowName(){
        return _showName;
    }

    public String getFilePath(){
        return _filePath;
    }

}
