package io.imking.common.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import io.imking.common.domain.Attachment;
import io.imking.common.mapping.AttachmentMapper;
import io.imking.utils.SnowflakeWorker.SnowflakeWorkerHloder;

@Service
public class AttachmentService {

	@Value("${spring.upload.path}")
	protected String uploadPath;

	private static final Logger LOGGER = LoggerFactory.getLogger(AttachmentService.class);

	static Map<String, String> FILE_EXT_CONTENT_TYPE = new HashMap<>();
	static {
		FILE_EXT_CONTENT_TYPE.put("bmp", "image/png");
		FILE_EXT_CONTENT_TYPE.put("jpeg", "image/jpeg");
		FILE_EXT_CONTENT_TYPE.put("gif", "image/gif");
		FILE_EXT_CONTENT_TYPE.put("png", "image/png");
		FILE_EXT_CONTENT_TYPE.put("jpg", "image/jpeg");
		FILE_EXT_CONTENT_TYPE.put("dng", "image/jpeg");

	}

	@Autowired
	protected AttachmentMapper attachmentMapper;

	public Attachment insertUploadFile(MultipartFile file) {
		if (null == file) {
			return null;
		}
		String originalFilename = file.getOriginalFilename();
		String extension = FilenameUtils.getExtension( originalFilename );
		if (StringUtils.isEmpty(extension)) {
			return null;
		}
		String dateDir = DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM") ;
		String headFileUrl = String.format("%s/%s", uploadPath,dateDir);
		new File(headFileUrl).mkdirs();
		InputStream in = null;
		OutputStream out = null;
		String fileName = SnowflakeWorkerHloder.nextId() + "." + extension;
		try {
			in = file.getInputStream();
			out = new FileOutputStream(headFileUrl + "/" + fileName);
			IOUtils.copy(file.getInputStream(), out);
		} catch (Exception e) {
			LOGGER.error("insertUploadFile error" , e );
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
		Attachment attachment = new Attachment();
		attachment.setCreateTime(new Date());
		attachment.setFileName( originalFilename )  ;
		String contentType = FILE_EXT_CONTENT_TYPE.get(extension.toLowerCase()) ; 
		
		attachment.setFileType(StringUtils.isEmpty(contentType) ? "image/png" : contentType); 
		attachment.setPath( dateDir + "/" + fileName ); 
		attachment.setSize( file.getSize() );
		attachment.setId( SnowflakeWorkerHloder.nextId());
		insert( attachment ) ;
		
		return attachment ;
	}

	public int deleteByPrimaryKey(Long id) {
		return attachmentMapper.deleteByPrimaryKey(id);
	}

	public int insert(Attachment record) {
		return attachmentMapper.insert(record);
	}

	public int insertSelective(Attachment record) {
		return attachmentMapper.insertSelective(record);
	}

	public Attachment selectByPrimaryKey(Long id) {
		return attachmentMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Attachment record) {
		return attachmentMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Attachment record) {
		return attachmentMapper.updateByPrimaryKey(record);
	}
}
