package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SingleItemResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/api/upload")
public class UploadController {
    public static String uploadDirectory = System.getProperty("user.dir") + "/images";


    @PostMapping(value = "/image",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BaseResponse upload(@RequestParam("images") MultipartFile[] images) {
        SingleItemResponse<String> response = new SingleItemResponse<>();
        StringBuilder files = new StringBuilder();
        for (MultipartFile image : images) {
            Path path = Paths.get(uploadDirectory, image.getOriginalFilename());
            files.append(uploadDirectory+image.getOriginalFilename() + " ");
            try {
                Files.write(path, image.getBytes());
            } catch (IOException e) {
                response.setResult("", response.getMessage());
                return response;
            }
        }
        response.setSuccess(files.toString());
        return response;
    }

}
