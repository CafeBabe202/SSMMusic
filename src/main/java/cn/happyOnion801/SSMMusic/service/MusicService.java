package cn.happyOnion801.SSMMusic.service;

import cn.happyOnion801.SSMMusic.bean.*;
import cn.happyOnion801.SSMMusic.dao.MusicMapper;
import cn.happyOnion801.SSMMusic.dao.MusictypeMapper;
import cn.happyOnion801.SSMMusic.dao.SingerMapper;
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
 * Date : 2021-06-28
 * Blog : https://www.happyOnion801.cn
 */
@Service
public class MusicService {
    @Autowired
    private MusicMapper musicMapper;
    @Autowired
    private MusictypeMapper musictypeMapper;
    @Autowired
    private SingerMapper singerMapper;
    @Autowired
    private FileConfig fileConfig;
    @Autowired
    Utils utils;

    public PageInfo<Music> showAllMusic(int pageNO) {
        PageHelper.startPage(pageNO, 6);
        List<Music> musics = musicMapper.selectAll();
        return new PageInfo<>(musics);
    }

    public List<Music> discoverMusic() {
        MusicExample musicExample = new MusicExample();
        musicExample.setOrderByClause(" rand() limit 6");
        return musicMapper.selectByExample(musicExample);
    }

    public List<Music> newMusicRank() {
        MusicExample musicExample = new MusicExample();
        musicExample.setOrderByClause(" time limit 8");
        return musicMapper.selectByExample(musicExample);
    }

    public List<Music> musicRank() {
        MusicExample musicExample = new MusicExample();
        musicExample.setOrderByClause(" musicHot desc limit 10");
        return musicMapper.selectByExample(musicExample);
    }

    public List<Musictype> allMusicType() {
        return musictypeMapper.selectByExample(null);
    }

    public List<Music> getMusicListBySingerId(int id) {
        MusicExample musicExample = new MusicExample();
        musicExample.createCriteria().andSingeridEqualTo(id);
        return musicMapper.selectByExample(musicExample);
    }

    public PageInfo<Music> getMusicListByTypeId(int id, int pageNO) {
        PageHelper.startPage(pageNO, 6);
        MusicExample musicExample = new MusicExample();
        musicExample.createCriteria().andMusictypeidEqualTo(id);
        return new PageInfo<>(musicMapper.selectByExample(musicExample));
    }

    public boolean saveMusic(Music music) {
        setMusicSingerId(music);
        return musicMapper.insertSelective(music) == 1;
    }

    public Musictype getMusicTypeByTypeId(int typeId) {
        return musictypeMapper.selectByPrimaryKey(typeId);
    }

    public int saveFiles(Music music, MultipartFile[] files) {
        if (files == null) return 0;
        int res = 0;
        for (MultipartFile file : files) {
            String name = utils.getID() + file.getOriginalFilename();
            if (name.endsWith(".mp3") && utils.saveFile(fileConfig.getMusicPath() + File.separator + name, file)) {
                music.setSongurl(fileConfig.getMusicPath() + File.separator + name);
                res++;
            } else if (name.endsWith(".jpg") && utils.saveFile(fileConfig.getPicturePath() + File.separator + name, file)) {
                music.setMusicphotourl(fileConfig.getPicturePath() + File.separator + name);
                res++;
            }
        }
        return res;
    }

    public boolean deleteMusic(int id) {
        Music music = musicMapper.selectByPrimaryKey(id);
        utils.deleteFile(music.getSongurl());
        utils.deleteFile(music.getMusicphotourl());
        return musicMapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean updateMusic(Music music) {
        setMusicSingerId(music);
        Music m = musicMapper.selectByPrimaryKey(music.getMusicid());
        if (m.getMusicphotourl() != null && m.getMusicphotourl().equals(music.getMusicphotourl()))
            utils.deleteFile(m.getMusicphotourl());
        if (m.getSongurl() != null && m.getSongurl().equals(music.getSongurl()))
            utils.deleteFile(m.getSongurl());
        return musicMapper.updateByPrimaryKeySelective(music) == 1;
    }

    private void setMusicSingerId(Music music) {
        Singer singer = getSingerByName(music.getSingerName());
        if (singer == null) {
            singer = new Singer();
            singer.setSingername(music.getSingerName());
            saveSinger(singer);
        }
        singer = getSingerByName(music.getSingerName());
        music.setSingerid(singer.getSingerid());
    }

    private Singer getSingerByName(String name) {
        SingerExample singerExample = new SingerExample();
        singerExample.createCriteria().andSingernameEqualTo(name);
        List<Singer> singers = singerMapper.selectByExample(singerExample);
        if (singers != null && singers.size() > 0)
            return singers.get(0);
        return null;
    }

    private boolean saveSinger(Singer singer) {
        return singerMapper.insertSelective(singer) == 1;
    }

}
