package com.c820ftjavareact.ecommerce.controller;


import com.c820ftjavareact.ecommerce.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/productC")
@CrossOrigin(origins = "https://c8-20-ft-javareact-5a91pzs32-villanos.vercel.app/")
public class CloudinaryController {
    @Autowired
    CloudinaryService cloudinaryService;
    @PostMapping("/upload")
    public ResponseEntity<Map> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        Map result = cloudinaryService.upload(multipartFile);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}") //piblic_id=id
    public  ResponseEntity<Map> delete(@PathVariable("id") String id)throws IOException{
        Map result= cloudinaryService.delete(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}