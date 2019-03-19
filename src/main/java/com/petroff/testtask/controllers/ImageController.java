package com.petroff.testtask.controllers;

import com.petroff.testtask.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.GET)
    public String uploadImage(){
        return "imageUploader.html";
    }

    @PostMapping("/uploadImage")
    @ResponseBody
    public String submit(@RequestParam("imageFile") MultipartFile imageFile) {
        return imageService.uploadImage(imageFile);
    }


}
