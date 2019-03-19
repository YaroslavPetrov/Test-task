package com.petroff.testtask.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService{


    @Override
    public String uploadImage(MultipartFile imageFile) {
        String folder = "\\images\\";
        Path folderPath = Paths.get(folder);
        if(Files.notExists(folderPath)){
            try {
                Files.createDirectory(folderPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(folder + imageFile.getOriginalFilename());
            Files.write(path, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return folder + imageFile.getOriginalFilename();
    }
}
