package com.image.buisnes;


import java.io.IOException;

public interface ImageService {
    String uploadImage();
    public String saveImage(String base64Image) ;
     void saveImagePathToDatabase(String filePath) ;
    }
