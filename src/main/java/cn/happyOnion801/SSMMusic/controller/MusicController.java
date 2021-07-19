package cn.happyOnion801.SSMMusic.controller;

import cn.happyOnion801.SSMMusic.bean.Music;
import cn.happyOnion801.SSMMusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-25
 * Blog : https://www.happyOnion801.cn
 */
@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    MusicService musicService;

    @RequestMapping("/toManager")
    public String toMusicManager(Model model, @RequestParam(defaultValue = "1") int pageNO) {
        model.addAttribute("pageInfo", musicService.showAllMusic(pageNO));
        model.addAttribute("musicType", musicService.allMusicType());
        return "admin/musicManager";
    }

    @RequestMapping("/addMusic")
    public String addMusic(Music music, @RequestParam("myFile") MultipartFile[] files) {
        musicService.saveFiles(music, files);
        musicService.saveMusic(music);
        return "redirect:/music/toManager";
    }

    @RequestMapping("/delById")
    @ResponseBody
    public String deleteMusic(int musicId) {
        musicService.deleteMusic(musicId);
        return "yes";
    }

    @RequestMapping("/editMusic")
    public String editMusic(Music music, @RequestParam("myFile") MultipartFile[] files){
        musicService.saveFiles(music,files);
        musicService.updateMusic(music);
        return "redirect:/music/toManager";
    }

}