package cn.happyOnion801.SSMMusic.controller;

import cn.happyOnion801.SSMMusic.bean.Video;
import cn.happyOnion801.SSMMusic.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-25
 * Blog : https://www.happyOnion801.cn
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @RequestMapping("/toVideoManager")
    public String toVideoManager(Model model, @RequestParam(defaultValue = "1") int pageNO) {
        model.addAttribute("info", videoService.showAllVideo(pageNO));
        return "admin/videoManager";
    }

    @RequestMapping("/saveVideo")
    public String addVideo(Video video, @RequestParam("myFile") MultipartFile[] files) {
        videoService.saveFiles(video, files);
        videoService.saveVideo(video);
        return "redirect:/video/toVideoManager";
    }

    @RequestMapping("/delVideoById")
    public String delVideoById(int videoId) {
        videoService.deleteVideo(videoId);
        return "redirect:/video/toVideoManager";
    }

    @RequestMapping("/editVideo")
    public String editVideo(Video video, @RequestParam("myFile") MultipartFile[] files) {
        videoService.saveFiles(video, files);
        videoService.update(video);
        return "redirect:/video/toVideoManager";
    }
}

