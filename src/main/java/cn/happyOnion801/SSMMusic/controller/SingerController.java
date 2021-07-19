package cn.happyOnion801.SSMMusic.controller;

import cn.happyOnion801.SSMMusic.bean.Singer;
import cn.happyOnion801.SSMMusic.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-30
 * Blog : https://www.happyOnion801.cn
 */
@Controller
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    SingerService singerService;

    @RequestMapping("/saveSinger")
    public String saveSinger(Singer singer, @RequestParam("myFile") MultipartFile[] files) {
        singerService.saveFile(singer, files);
        singerService.saveSinger(singer);
        return "redirect:/singer/toSingerManager";
    }

    @RequestMapping("/delSingerById")
    public String delSingerById(int singerId) {
        singerService.deleteSinger(singerId);
        return "redirect:/singer/toSingerManager";
    }

    @RequestMapping("/editSinger")
    public String editSinger(Singer singer, @RequestParam("myFile") MultipartFile[] files) {
        singerService.saveFile(singer, files);
        singerService.updateSinger(singer);
        return "redirect:/singer/toSingerManager";
    }

    @RequestMapping("/toSingerManager")
    public String toSingerManger(Model model, @RequestParam(defaultValue = "1") int pageNO) {
        model.addAttribute("info", singerService.showAllSinger(pageNO));
        return "admin/singerManager";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", "singer.xls");
        return new ResponseEntity<>(singerService.download(), httpHeaders, HttpStatus.OK);
    }
}
