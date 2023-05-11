package com.image.buisnes;

import com.image.persistence.Repo.ImageRepo;
import com.image.persistence.models.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    @Value("${driver.image}")
    private  String filePath;
    private final ImageRepo imageRepo;
    @Override
    public String uploadImage() {
        return null;
    }


    public String saveImage(String base64Image) {
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);
        String fileName = generateFileName();
        File imageFile = new File(filePath);
        if (!imageFile.exists())
            imageFile.mkdir();
        String uuid = generateFolder();
        String fullPath = filePath + uuid+"/"+ fileName;
        File FullPath = new File(fullPath);
        try (FileOutputStream outputStream = new FileOutputStream(FullPath)) {
            outputStream.write(imageBytes);
            saveImagePathToDatabase(uuid);
        }
     catch (IOException e) {
       e.printStackTrace();
    }
        return uuid;
    }

    private String generateFileName() {
        return "image_" + System.currentTimeMillis() + ".png";
    }
    private String generateFolder(){
        String uuid =UUID.randomUUID().toString();
        String folderPath = filePath + uuid;
        File imageFolder = new File(folderPath);
        if (!imageFolder.exists())
            imageFolder.mkdir();
        return uuid;
    }

    public void saveImagePathToDatabase(String filePath) {
        imageRepo.saveAndFlush(new Image(filePath));
    }
}
