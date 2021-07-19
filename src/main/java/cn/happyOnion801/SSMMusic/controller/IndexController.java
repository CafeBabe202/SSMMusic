package cn.happyOnion801.SSMMusic.controller;

import cn.happyOnion801.SSMMusic.bean.Message;
import cn.happyOnion801.SSMMusic.bean.Music;
import cn.happyOnion801.SSMMusic.bean.Singer;
import cn.happyOnion801.SSMMusic.bean.User;
import cn.happyOnion801.SSMMusic.service.MusicService;
import cn.happyOnion801.SSMMusic.service.SingerService;
import cn.happyOnion801.SSMMusic.service.VideoService;
import cn.happyOnion801.SSMMusic.utils.Utils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-07-01
 * Blog : https://www.happyOnion801.cn
 */
@Controller
public class IndexController {

    @Autowired
    MusicService musicService;
    @Autowired
    SingerService singerService;
    @Autowired
    VideoService videoService;
    @Autowired
    Utils utils;

    @RequestMapping("/user/toIndex")
    public String toIndex(Model model) {
        List<Music> newMusic = musicService.newMusicRank();
        List<Music> discoverMusic = musicService.discoverMusic();
        List<Music> musicRank = musicService.musicRank();

        model.addAttribute("discoverMusicList", discoverMusic);
        model.addAttribute("newMusicList", newMusic);
        model.addAttribute("musicRankList", musicRank);
        model.addAttribute("singerRankList", singerService.singerRank());

        model.addAttribute("discoverMusicJson", utils.toJson(discoverMusic));
        model.addAttribute("newMusicJson", utils.toJson(newMusic));
        model.addAttribute("musicRank", utils.toJson(musicRank));

        return "/main/index";
    }

    @RequestMapping("/user/toAdminLogin")
    public String toAdminLogin() {
        return "/admin/AdminLogin";
    }

    @RequestMapping("/music/getMusicBySingerId")
    public String getMusicBySingerId(Model model, @RequestParam(defaultValue = "1") int sid) {
        Singer singer = singerService.getSingerById(sid);
        model.addAttribute("singerRankList", singerService.singerRank());
        if (singer == null) {
            model.addAttribute("msg", "没有这个歌手唉!");
        } else {
            List<Music> musicListBySingerId = musicService.getMusicListBySingerId(sid);
            if (musicListBySingerId == null || musicListBySingerId.isEmpty()) {
                model.addAttribute("msg", "这个歌手没有音乐哦");
            } else {
                model.addAttribute("singerMusicList", musicListBySingerId);
                model.addAttribute("singerMusicJson", utils.toJson(musicListBySingerId));
            }
        }
        return "main/search";
    }

    @RequestMapping("/music/genres")
    public String genres(Model model, @RequestParam(defaultValue = "1") int nowTypeId, @RequestParam(defaultValue = "1") int pageNO) {

        PageInfo<Music> pageInfo = musicService.getMusicListByTypeId(nowTypeId, pageNO);

        model.addAttribute("musicTypeList", musicService.allMusicType());
        model.addAttribute("nowTypeMusicInfo", pageInfo);
        model.addAttribute("nowType", musicService.getMusicTypeByTypeId(nowTypeId));
        model.addAttribute("musicJson", utils.toJson(pageInfo.getList()));
        return "main/genres";
    }

    @RequestMapping("/video")
    public String video(Model model, @RequestParam(defaultValue = "1") int pageNO) {
        model.addAttribute("randVideoList", videoService.randomVideo(3));
        model.addAttribute("videoInfo", videoService.getVideoInfo(pageNO));
        return "main/video";
    }

    @RequestMapping("/video/play")
    public String play(Model model, @RequestParam(defaultValue = "1") int videoid) {
        model.addAttribute("video", videoService.getVideoById(videoid));
        model.addAttribute("message", videoService.getMessageByVideoId(videoid));
        model.addAttribute("randomVideoList", videoService.randomVideo(10));
        return "main/video-detail";
    }

    @RequestMapping("/video/fbMsg")
    public String fb(HttpSession session, Message message) {
        User user = (User) session.getAttribute("user");
        message.setUser(user);
        message.setUid(user.getUid());
        message.setMessagetime(new Date(System.currentTimeMillis()));
        videoService.saveMessage(message);
        return "redirect:/video";
    }
}