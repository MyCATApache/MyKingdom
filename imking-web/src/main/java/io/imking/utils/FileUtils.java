package io.imking.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

public class FileUtils {
	 
	/**
	 * 文件下载
	 * @param fileName
	 * @param filePath
	 * @param response
	 * @throws IOException
	 */
	public static void download(String fileName, String filePath, HttpServletResponse response) throws IOException{
		//设置响应头
		response.setCharacterEncoding("uft-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));
		
		BufferedInputStream bufferedInput = null;
		BufferedOutputStream bufferedOutput = null;
		try{
			File file = new File(filePath);
			
			if(file.exists() && file.isFile()){
				bufferedInput = new BufferedInputStream(new FileInputStream(file));
				bufferedOutput = new BufferedOutputStream(response.getOutputStream());
				
				//循环写入输出流
				byte[] b = new byte[1024];
				int count;
				while((count = bufferedInput.read(b)) > 0){
					bufferedOutput.write(b,0,count);
				}
				bufferedInput.close();
				bufferedOutput.close();
			}
		}	
		finally{
			if(bufferedInput != null){
				bufferedInput.close();
			}
			if(bufferedOutput != null){
				bufferedOutput.close();
			}
		}

	}
	
	
	/**
	 * 删除文件
	 * @param filePath
	 * @return
	 */
	public static boolean delFile(String filePath){
		File file = new File(filePath);
		if(file.exists() && file.isFile()){
			file.delete();
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * 上传文件
	 * @param multipartFile
	 * @param fileName
	 * @param uploadRootPath
	 * @param filePath
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String fileUpload(MultipartFile multipartFile,String uploadRootPath,String filePath) throws IllegalStateException, IOException{
		
 		//创建文件目录
 		File file = new File(uploadRootPath + filePath); 
		if (!file.exists()){
			file.mkdirs();
		}
		String originalFilename = multipartFile.getOriginalFilename();
		String fileExtName = originalFilename.substring(originalFilename.lastIndexOf("."));
		String saveName = Calendar.getInstance().getTimeInMillis() + new Random().nextInt(100000) + fileExtName;
		filePath = filePath + saveName;
		multipartFile.transferTo(new File(uploadRootPath + filePath));
		
		return saveName;
	}
	
	
	/**
	 * 验证文件合法性
	 * @param multipartFile
	 * @return
	 * @throws IOException
	 */
	public static String checkFile(MultipartFile multipartFile,int maxUploadFileSzie) throws IOException{
		
		//判断文件大小
		if (multipartFile == null || multipartFile.getSize() == 0){
			return "上传的文件为空";
		}
		
		//最大文件大小
		if(multipartFile.getSize() > maxUploadFileSzie*1024*1024L){
			return "上传的文件不能大于" + maxUploadFileSzie + "M";
		}
		
		//判断文件名
		if(!multipartFile.getOriginalFilename().contains(".")){
			return "上传的文件名格式不正确";
		}
		
		return "";
	}
	
	
	
	/**
	 * 验证文件合法性
	 * @param multipartFile
	 * @return
	 * @throws IOException
	 */
	public static JSONObject checkFileReturnJSONObject(MultipartFile multipartFile,int maxUploadFileSzie) throws IOException{
		
		JSONObject jsonObject = new JSONObject(); 
		//判断文件大小
		if (multipartFile == null || multipartFile.getSize() == 0){
			jsonObject.put("code", "000");
 			jsonObject.put("msg", "上传的文件为空");
 			return jsonObject;
		}
		
		//最大文件大小
		if(multipartFile.getSize() > maxUploadFileSzie*1024*1024L){
			jsonObject.put("code", "000");
 			jsonObject.put("msg", "上传的文件不能大于" + maxUploadFileSzie + "M");
 			return jsonObject;
		}
		
		//判断文件名
		if(!multipartFile.getOriginalFilename().contains(".")){
			jsonObject.put("code", "000");
 			jsonObject.put("msg", "上传的文件名格式不正确");
 			return jsonObject;
		}
		
		return null;
	}
	
	
	/**
	 * 读取配置文件
	 * @param FileName 文件名
	 * @param propertyname 属性名
	 * @return
	 * @throws IOException
	 */
	public static String getProperty(String FileName,String propertyname) throws IOException{
		 Properties props = new Properties();
		 props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(FileName));
		 return props.getProperty(propertyname);
	}
}
