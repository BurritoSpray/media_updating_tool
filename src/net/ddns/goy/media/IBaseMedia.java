package net.ddns.goy.media;

public interface IBaseMedia {
    String path = "";

    String getPath();
    void setPath(String path);
    void moveTo(String path);
    void copyTo(String path);
    void delete();



}
