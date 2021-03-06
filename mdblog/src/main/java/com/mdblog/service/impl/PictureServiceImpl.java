package com.mdblog.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


import com.alibaba.fastjson.JSON;
import com.mdblog.mapper.ArticleMapper;
import com.mdblog.po.Article;
import com.mdblog.po.ReleaseArticle;
import com.mdblog.po.ResponResult;
import com.mdblog.service.PictureService;
import com.mdblog.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mdblog.utils.IDUtils;
import com.mdblog.utils.FtpUtil;


/**
 * 图片上传服务
 * <p>Title: PictureServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p>
 * @author	入云龙
 * @date	2015年9月4日下午2:50:42
 * @version 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {

	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@Autowired
	private UserService userService;
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public Map uploadPicture(String token, MultipartFile uploadFile) {
		// 万物根本 返回json包含(success,message,url)
		Map resultMap = new HashMap();
		// 验证用户session
		Long userId = userService.getUserIdByToken(token);
		if (userId == -1) {
			resultMap.put("success", 0);
			resultMap.put("message", "文件上传失败");
			return resultMap;
		}
		try {
			//生成一个新的文件名
			//取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			//生成新文件名
			//UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//图片上传
			String imagePath ="/"+ userId + new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
					FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
			//返回结果
			if(!result) {
				resultMap.put("success", 0);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
			String url =IMAGE_BASE_URL + imagePath + "/" + newName;
			resultMap.put("success", 1);
			resultMap.put("message","上传成功123123");
			resultMap.put("url", url);

			return resultMap;

		} catch (Exception e) {
			resultMap.put("success", 0);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
	}

	@Override
	public Map uploadRAPicture(String token ,Long articleId, MultipartFile uploadFile) {
		// 万物根本 返回json包含(success,message,url)
		Map resultMap = new HashMap();
		// 验证用户session
		Long userId = userService.getUserIdByToken(token);
		if (userId == -1) {
			resultMap.put("success", 0);
			resultMap.put("message", "文件上传失败");
			return resultMap;
		}
		try {
			//生成一个新的文件名
			//取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			//生成新文件名
			//UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//图片上传
			String imagePath ="/"+ userId + new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
					FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
			//返回结果
			if(!result) {
				resultMap.put("success", 0);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
			String url =IMAGE_BASE_URL + imagePath + "/" + newName;
			resultMap.put("success", 1);
			resultMap.put("message","上传成功123123");
			resultMap.put("url", url);
//TODO 未测试
			// 取Articlt 存放url
			Article articleFromDB = articleMapper.selectByPrimaryKey(articleId);
			articleFromDB.setaPic(url);
			articleMapper.updateByPrimaryKey(articleFromDB);

			//System.out.println(JSON.toJSONString(resultMap));
			//System.out.println(resultMap.toString());
			return resultMap;

		} catch (Exception e) {
			resultMap.put("success", 0);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
	}
}
