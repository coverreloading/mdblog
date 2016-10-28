package com.mdblog.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

	Map uploadPicture(String token,MultipartFile uploadFile);
}
