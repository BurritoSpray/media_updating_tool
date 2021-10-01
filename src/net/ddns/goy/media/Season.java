package net.ddns.goy.media;

// TODO: Ajouter une fonction sort() pour trier les episode dans la liste en ordre de Episode.episodeNo

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Season {
    private final List<Episode> _episodeList = new ArrayList<Episode>();
    private String _showName;
    private String _filePath;
    private int _seasonNo;


    public Season(String showName, String filePath){
        if(new File(filePath).isDirectory()){
            _showName = showName;
            _filePath = filePath;
        }
        // Ouvre et scan le repertoire de la saison
        File f = new File(filePath);
        String[] files = f.list();
        if(files != null){
            // Trouve les dossier et les fichiers parceque les episode son parfois chacun dans un dossier
            for(String file : files){
                // Ouvre le dossier et scan les fichier a linterieur pour trouver les episodes
                File tempF = new File(filePath + "\\" + file);
                // Parametrage du regex pour les format commun
                var regexResult = Pattern.compile("(?:s|season.)([0-9]+).?(?:e|episode.)([0-9]+)", Pattern.CASE_INSENSITIVE).matcher(tempF.getName());
                // Variable temporaire pour le numeros depisode
                int episodeNo = 0;
                if(regexResult.find()){
                    _seasonNo = Integer.parseInt(regexResult.group(1));
                    episodeNo = Integer.parseInt(regexResult.group(2));
                }
                else {
                    // Si aucun resultat ne match on esseye un autre format pour les episode SEE
                    regexResult = Pattern.compile(".([0-9])([0-9][0-9]).", Pattern.CASE_INSENSITIVE).matcher(tempF.getName());
                    if (regexResult.find()) {
                        _seasonNo = Integer.parseInt(regexResult.group(1));
                        episodeNo = Integer.parseInt(regexResult.group(2));
                    }
                }
                if(episodeNo > 0)
                    _episodeList.add(new Episode(_showName, _seasonNo, episodeNo, tempF.getPath()));

            }

        }

    }

//    // Initialisation d'une saison vide pour lajout manuel d'episode
//    public Season(String showName){
//        _showName = showName;
//        _seasonNo = 0;
//        _filePath = "";
//    }

    public void addEpisode(Episode episode){
        if(!_episodeList.contains(episode)){
            _episodeList.add(episode);
        }
    }

    public String getShowName(){
        return _showName;
    }

    public int getSeasonNo(){return _seasonNo;}

    public String getPath(){
        return _filePath;
    }

    public List<Episode> getEpisodeList(){
        return _episodeList;
    }

    /**
     * Used to know the number of episode contained in the Season object
     *
     * @return size of _episodeList
     */
    public int getEpisodeCount(){
        return _episodeList.size();
    }

    @Override
    public String toString() {
        return String.format("%S : Season %d | %d Episodes", _showName, _seasonNo, this.getEpisodeCount());
    }

}
