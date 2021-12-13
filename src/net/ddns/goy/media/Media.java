package net.ddns.goy.media;

public abstract class Media implements IBaseMedia {
    public Media(String path){

    }
    public String _filePath;
    public String _showName;

    public String getPath() {
        return _filePath;
    }
    public String getShowName() {
        return _showName;
    }
}
