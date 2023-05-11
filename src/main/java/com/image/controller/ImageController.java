package com.image.controller;

import com.image.buisnes.ImageService;
import com.image.buisnes.dto.ImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    @PostMapping("/upload")
    public String uploadImage(@RequestBody ImageDto image){

        return  imageService.saveImage(image.getImagePath());
    }
}
