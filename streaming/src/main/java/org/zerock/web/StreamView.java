package org.zerock.web;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

@Component("StreamView")
public class StreamView extends AbstractView{
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(StreamView.class);
	@Value("#{dir['movieDir']}") private String movieDir;
	
	@Override
	protected void renderMergedOutputModel(Map<String,Object> map, HttpServletRequest request
			, HttpServletResponse response) throws Exception{
		String movieName = (String)map.get("movieName");
		
		RandomAccessFile randomFile = new RandomAccessFile(new File(movieDir, movieName),"r");
		
		long rangeStart = 0;
		long rangeEnd=0;
		boolean isPart = false;
		
		try {
			long movieSize = randomFile.length();
			String range = request.getHeader("range");
			logger.debug("range:{}",range);
			
			if(range!=null) {
				if(range.endsWith("-")) {
					range = range+(movieSize-1);
				}
				int idxm = range.trim().indexOf("-");
				rangeStart = Long.parseLong(range.substring(6, idxm));
				rangeEnd = Long.parseLong(range.substring(idxm+1));
				if(rangeStart>0) {
					isPart = true;
				}
			}
			else {
				rangeStart = 0;
				rangeEnd = movieSize-1;
			}
			
			long partSize = rangeEnd - rangeStart +1;
			logger.debug("accepted range: {}",rangeStart + "-"+rangeEnd+"/"+partSize+"isPart:"+isPart);
			
			response.reset();
			response.setStatus(isPart ? 206 : 200);
			response.setContentType("video/mp4");
			response.setHeader("Content-Range","bytes"+rangeStart+"-"+rangeEnd+"/"+movieSize);
			response.setHeader("Accept-Ranges", "bytes");
			response.setHeader("Content-Length", ""+partSize);
			OutputStream out = response.getOutputStream();
			randomFile.seek(rangeStart);
			
			int bufferSize = 8*1024;
			byte[] buf = new byte[bufferSize];
			do {
				int block = partSize > bufferSize ? bufferSize : (int)partSize;
				int len = randomFile.read(buf, 0, block);
				out.write(buf,0,len);
				partSize -= block;
			}while(partSize > 0);
			logger.debug("sent "+movieName + ""+rangeStart + "-"+rangeEnd);
			
		}catch(IOException e) {
			logger.debug("������ ��� �Ǿ���");
		}finally {
			randomFile.close();
		}
	}
}