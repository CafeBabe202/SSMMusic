package cn.happyOnion801.SSMMusic.service;

import cn.happyOnion801.SSMMusic.bean.*;
import cn.happyOnion801.SSMMusic.dao.MusicMapper;
import cn.happyOnion801.SSMMusic.dao.SingerMapper;
import cn.happyOnion801.SSMMusic.dao.SingertypeMapper;
import cn.happyOnion801.SSMMusic.utils.FileConfig;
import cn.happyOnion801.SSMMusic.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-30
 * Blog : https://www.happyOnion801.cn
 */
@Service
public class SingerService {

    @Autowired
    SingerMapper singerMapper;
    @Autowired
    MusicMapper musicMapper;
    @Autowired
    SingertypeMapper singertypeMapper;
    @Autowired
    Utils utils;
    @Autowired
    FileConfig fileConfig;

    public boolean saveSinger(Singer singer) {
        singer.setTypeid(getSingerTypeId(singer.getSingerType().getTypename()));
        return singerMapper.insertSelective(singer) == 1;
    }

    public boolean deleteSinger(int id) {
        Singer singer = singerMapper.selectByPrimaryKey(id);
        utils.deleteFile(singer.getSingerphotourl());
        musicMapper.setTypeToOther(id);
        return singerMapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean updateSinger(Singer singer) {
        singer.setTypeid(getSingerTypeId(singer.getSingerType().getTypename()));
        return singerMapper.updateByPrimaryKeySelective(singer) == 1;
    }

    public PageInfo<Singer> showAllSinger(int pageNO) {
        PageHelper.startPage(pageNO, 6);
        List<Singer> singers = singerMapper.selectByExample(null);
        return new PageInfo<>(singers);
    }

    public List<Singer> singerRank(){
        SingerExample singerExample = new SingerExample();
        singerExample.setOrderByClause(" singerHot desc");
        return singerMapper.selectByExample(singerExample);
    }

    public Singer getSingerById(int id){
        return singerMapper.selectByPrimaryKey(id);
    }

    public boolean saveFile(Singer singer, MultipartFile[] files) {
        if (files == null) return false;
        for (MultipartFile file : files) {
            String name = fileConfig.getPicturePath() + File.separator + utils.getID() + file.getOriginalFilename();
            if (name.endsWith(".jpg")) {
                utils.saveFile(name, file);
                singer.setSingerphotourl(name);
            }
        }
        return true;
    }

    public byte[] download() {
        return utils.saveToXls(singerMapper.selectByExample(null));
    }

    private int getSingerTypeId(String singerName) {
        SingertypeExample singertypeExample = new SingertypeExample();
        singertypeExample.createCriteria().andTypenameEqualTo(singerName);
        List<Singertype> singertypes = singertypeMapper.selectByExample(singertypeExample);

        if (singertypes != null && singertypes.size() > 0) {
            return singertypes.get(0).getTypeid();
        }

        Singertype singertype = new Singertype();
        singertype.setTypename(singerName);
        singertypeMapper.insertSelective(singertype);
        singertypes = singertypeMapper.selectByExample(singertypeExample);
        return singertypes.get(0).getTypeid();
    }
}
