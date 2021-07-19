package cn.happyOnion801.SSMMusic.service;

import cn.happyOnion801.SSMMusic.bean.Message;
import cn.happyOnion801.SSMMusic.bean.MessageExample;
import cn.happyOnion801.SSMMusic.bean.Video;
import cn.happyOnion801.SSMMusic.bean.VideoExample;
import cn.happyOnion801.SSMMusic.dao.MessageMapper;
import cn.happyOnion801.SSMMusic.dao.VideoMapper;
import cn.happyOnion801.SSMMusic.utils.FileConfig;
import cn.happyOnion801.SSMMusic.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-29
 * Blog : https://www.happyOnion801.cn
 */
@Service
public class VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    Utils utils;
    @Autowired
    FileConfig fileConfig;

    public PageInfo<Video> showAllVideo(int pageNO) {
        PageHelper.startPage(pageNO, 6);
        List<Video> videos = videoMapper.selectByExample(null);
        return new PageInfo<>(videos);
    }

    public int saveFiles(Video video, MultipartFile[] files) {
        if (files == null) return 0;
        int res = 0;
        for (MultipartFile file : files) {
            String name = utils.getID() + file.getOriginalFilename();
            if (name.endsWith(".jpg") && utils.saveFile(fileConfig.getPicturePath() + File.separator + name, file)) {
                video.setVideophoto(fileConfig.getPicturePath() + File.separator + name);
                res++;
            } else if (name.endsWith(".m4v") && utils.saveFile(fileConfig.getVideoPath() + File.separator + name, file)) {
                video.setVideourl(fileConfig.getVideoPath() + File.separator + name);
                res++;
            }
        }
        return res;
    }

    public boolean saveVideo(Video video) {
        return videoMapper.insertSelective(video) == 1;
    }

    public boolean deleteVideo(int id) {
        Video video = videoMapper.selectByPrimaryKey(id);
        utils.deleteFile(video.getVideourl());
        utils.deleteFile(video.getVideophoto());
        return videoMapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean update(Video video) {
        Video v = videoMapper.selectByPrimaryKey(video.getVideoid());
        if (v.getVideophoto() != null && v.getVideophoto().equals(video.getVideophoto()))
            utils.deleteFile(v.getVideophoto());
        if (v.getVideourl() != null && v.getVideourl().equals(video.getVideourl()))
            utils.deleteFile(v.getVideourl());
        return videoMapper.updateByPrimaryKeySelective(video) == 1;
    }

    public List<Video> randomVideo(int num) {
        VideoExample videoExample = new VideoExample();
        videoExample.setOrderByClause(" rand() limit " + num);
        return videoMapper.selectByExample(videoExample);
    }

    public PageInfo<Video> getVideoInfo(int pageNO) {
        PageHelper.startPage(pageNO, 8);
        return new PageInfo<>(videoMapper.selectByExample(null));
    }

    public Video getVideoById(int id) {
        return videoMapper.selectByPrimaryKey(id);
    }

    public List<Message> getMessageByVideoId(int id) {
        MessageExample example = new MessageExample();
        example.createCriteria().andVideoidEqualTo(id);
        example.setOrderByClause(" messageTime desc limit 6");
        return messageMapper.selectByExample(example);
    }

    public boolean saveMessage(Message message) {
        return messageMapper.insertSelective(message) == 1;
    }
}
