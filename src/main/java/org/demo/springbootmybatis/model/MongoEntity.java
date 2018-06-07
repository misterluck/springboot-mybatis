package org.demo.springbootmybatis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * Created by zhaol on 2018/5/24.
 */
@Document(collection = "entity")
public class MongoEntity {
    @Id
    private String id;
    private String images;
    private String videos;
    private String audios;

    public MongoEntity() {
    }

    public MongoEntity(String id, String images, String videos, String audios) {
        this.id = id;
        this.images = images;
        this.videos = videos;
        this.audios = audios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getAudios() {
        return audios;
    }

    public void setAudios(String audios) {
        this.audios = audios;
    }

    @Override
    public String toString() {
        return "MongoEntity{" + "id='" + id + '\'' + ", images='" + images + '\'' + ", videos='" + videos + '\'' + ", audios='" + audios + '\'' + '}';
    }
}
