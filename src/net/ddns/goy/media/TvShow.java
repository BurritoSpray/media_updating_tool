package net.ddns.goy.media;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TvShow {
    private final List<Season> _seasonList = new ArrayList<Season>();
    private final String _showName;
    private final String _folderPath;

    // Class declaration with folder parameter
    // Using the given path it will parse recursively folders to find matching name convention and identify files
    public TvShow(String folderPath){
        // Exemple: American.Gods.S01E01.1080p.BluRay.x264-SHORTBREHD.mkv
        _folderPath = folderPath;
        // Declaration de la variable mainFolder qui contien lemplacement de la serie
        File mainFolder = new File(folderPath);
        _showName = mainFolder.getName();
        // Scan de la liste des dossiers et fichiers dans le dossier principale
        String[] filesAndFolders = mainFolder.list();
        for(String fileName : filesAndFolders){
            // Verifie si lobjet est un dossier ou un fichier
            File tempF = new File(folderPath + "\\" + fileName);
            // Si l'objet est un dossier on verifie si il contient une saison et on l'ajoute a _seasonList
            if(tempF.isDirectory()){
                // Utiliser un regex pour identifier les dossier contenant une saison
                var regexResult = Pattern.compile("(.+?).(?:(s[0-9]+)|season.([0-9]+)).?(e[0-9]+)?", Pattern.CASE_INSENSITIVE).matcher(tempF.getName());
                if(regexResult.find()){
                    //_showName = regexResult.group(1);
                    _seasonList.add(new Season(_showName, tempF.getPath()));
                }
            }
            // Si l'objet n'est pas un dossier sa veut dire que la saison est rependu au travers des episode
            else{
                // TODO: Ajouter une fonction qui les fichier et cree les saison manuellement pour les fichier mal classer
                var regexResult = Pattern.compile("", Pattern.CASE_INSENSITIVE).matcher(tempF.getName());

            }
        }
        // TODO: Trier les saison apres les avoir scanner

    }

    // Returns the number of seasons
    public int getSeasonCount(){
        return _seasonList.size();
    }

    // Returns the total episode count for the TvShow
    public int getEpisodeCount(){
        int episodeCount = 0;
        for(Season season : _seasonList){
            episodeCount += season.getEpisodeCount();
        }
        return episodeCount;
    }

    // Returns the name of the show
    public String getShowName(){
        return _showName;
    }

    // Returns the path of the TvShow
    public String getPath(){
        return _folderPath;
    }

    public List<Season> getSeasonList(){
        return _seasonList;
    }

    // Verifies if there is any missing content according to IMDB.com
    public boolean checkForMissingContent(){
        // TODO: Fill this function
        return false;
    }

    // Saves the object to a file for restoring or comparing scan results
    public boolean save(String savingPath, String fileName){
        // TODO: Fill this function
        return false;
    }

    @Override
    public String toString() {
        return String.format("Seasons: %d | Episodes: %d", this.getSeasonCount(), this.getEpisodeCount());
    }
}
