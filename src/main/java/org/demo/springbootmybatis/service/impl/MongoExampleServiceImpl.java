package org.demo.springbootmybatis.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.demo.springbootmybatis.model.MongoEntity;
import org.demo.springbootmybatis.service.MongoExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 *
 * Created by zhaol on 2018/5/24.
 */
@Service
public class MongoExampleServiceImpl implements MongoExampleService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public void save() {
        MongoEntity entity = new MongoEntity("123456", "images", "videos", "audios");
        //mongoTemplate.save(entity);
        mongoTemplate.save(entity, "entity");
    }

    @Override
    public void find() {
        Query query = new Query(Criteria.where("id").is("123456"));
        //返回query中查询的所有内容
        //List<MongoEntity> list = mongoTemplate.find(query, MongoEntity.class, "");
        //返回query中查询到的第一条记录
        MongoEntity entity = mongoTemplate.findOne(query, MongoEntity.class, "entity");
        System.out.println(entity.toString());
    }

    @Override
    public void modify() {
        Query query=new Query(Criteria.where("id").is("123456"));
        Update update= new Update();
        update.set("images", "http://dev.local/myfirstimage.png");
        update.set("videos", "http://dev.local/myfirstvideo.mp4");
        update.set("audios", "http://dev.local/myfirstaudio.mp3");
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, MongoEntity.class, "");
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query, update, MongoEntity.class);
    }

    @Override
    public void remove() {
        Query query=new Query(Criteria.where("id").is("123456"));
        mongoTemplate.remove(query, MongoEntity.class);
    }

    @Override
    public void gridFsSave() {
        Resource file = new ClassPathResource("application.properties");
        try {
            //DBObject dbObject = new BasicDBObject("id", "130210312");
            gridFsTemplate.store(file.getInputStream(), file.getFilename(), "properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void gridFsFind() {
        Query query = new Query(Criteria.where("filename").is(""));
        //List<GridFSDBFile> files = gridFsTemplate.find(query);
        GridFSDBFile file = gridFsTemplate.findOne(query);

        file.getLength();
        file.getFilename();

        //获取所有的文件
        //GridFsResource[] files = gridFsTemplate.getResources("*");
    }

    @Override
    public void gridFsModify() {

    }

    @Override
    public void gridFsRemove() {

    }


}
