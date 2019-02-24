package org.demo.springbootmybatis.service.impl;

import com.github.tobato.fastdfs.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.GroupState;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.AppendFileStorageClient;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.github.tobato.fastdfs.service.GenerateStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;
import org.apache.commons.io.IOUtils;
import org.demo.springbootmybatis.service.FastDFSExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhaol on 2018/7/11.
 */
@Service
public class FastDFSExampleServiceImpl implements FastDFSExampleService {
    @Autowired
    private TrackerClient trackerClient;
    @Autowired
    private FdfsWebServer fdfsWebServer;

    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    /*@Autowired
    private GenerateStorageClient generateStorageClient;
    @Autowired
    private AppendFileStorageClient appendFileStorageClient;*/


    @Override
    public void contextLoads() {
        List<GroupState> groupStates = trackerClient.listGroups();
        for (GroupState groupState : groupStates) {
            System.out.println(groupState);
        }
        System.out.println(fdfsWebServer.getWebServerUrl());
    }

    @Override
    public void uploadFile() {
        try {
            File file = new File("D:\\TEMP\\pictures\\test1.jpg");
            InputStream inputStream = new FileInputStream(file);
            StorePath storePath = fastFileStorageClient.uploadFile(inputStream, file.length(), "jpg", null);
            System.out.println(storePath.getGroup()+"\n"+storePath.getPath()+"\n"+storePath.getFullPath());
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void downloadFile() {
        StorePath storePath = StorePath.praseFromUrl("http://10.19.19.54:8080/group1/M00/00/00/ChMTNltMB26AByi8AAFMTuSGrdA317.jpg");
        System.out.println(storePath.getGroup()+"\n"+storePath.getPath()+"\n"+storePath.getFullPath());
        DownloadByteArray downloadByteArray = new DownloadByteArray();
        byte[] data = fastFileStorageClient.downloadFile(storePath.getGroup(), storePath.getPath(), downloadByteArray);
        try {
            IOUtils.write(data, new FileOutputStream("D:/TEMP/"+UUID.randomUUID().toString()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFile() {
        StorePath storePath = StorePath.praseFromUrl("group1/M00/00/00/ChMTNltHGNaAZniOAAFMTuSGrdA936.jpg");
        //System.out.println(storePath.getGroup()+"\n"+storePath.getPath()+"\n"+storePath.getFullPath());
        fastFileStorageClient.deleteFile(storePath.getGroup(), storePath.getPath());
    }


}
