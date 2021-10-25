package net.ddns.goy.tmdb.data;

import net.ddns.goy.tmdb.data.DataType;

public class MediaData<T extends MediaData<T>> {
    DataType _mediaType;

    public DataType getMediaType(){return _mediaType;}
}
