package org.zerock.web;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.AbstractView;

@Controller
//@Component("streamView")
public class StreamView{
	private static final Logger logger = LoggerFactory.getLogger(StreamView.class);
	private String movieDir = "movie";
	
	@RequestMapping(value="/movie/{video_name}",method=RequestMethod.GET)
	public void getContentMediaVideo(@PathVariable("video_name")String video_name, HttpServletRequest request
			, HttpServletResponse response) throws Exception{
		String movieName = video_name+".mp4";
		//System.out.println({video_name});
//		System.out.println("test : "+movieName);
		File file = new File(".");
//		System.out.println(file.getAbsolutePath());
		String s = System.getProperty("user.dir");

//	    System.out.println("현재 디렉토리는 " + s + " 입니다");
		RandomAccessFile randomFile = new RandomAccessFile(new File(movieDir, movieName),"r");
		//File randomFile = new File("/");
//		System.out.println();
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
			System.out.println(partSize+" "+rangeEnd+" "+rangeStart);
			logger.debug("accepted range: {}",rangeStart + "-"+rangeEnd+"/"+partSize+"isPart:"+isPart);
			
			response.reset();
			response.setStatus(isPart ? 206 : 200);
			response.setContentType("video/mp4");
			
			
			response.setHeader("Content-Range","bytes "+rangeStart+"-"+rangeEnd+"/"+movieSize);
			response.setHeader("Accept-Ranges", "bytes");
			response.setHeader("Content-Length", ""+partSize);
			OutputStream out = response.getOutputStream();
			randomFile.seek(rangeStart);
			
			int bufferSize = 8*1024;
			byte[] buf = new byte[bufferSize];
			System.out.println("출력 시작");
			do {
				int block = partSize > bufferSize ? bufferSize : (int)partSize;
				int len = randomFile.read(buf, 0, block);
				out.write(buf,0,len);
				partSize -= block;
				System.out.println("len : "+len);
			}while(partSize > 0);
			System.out.println("출력 츨력 끝");
			logger.debug("sent "+movieName + ""+rangeStart + "-"+rangeEnd);
			
		}catch(Exception e) {
			logger.debug("전송이 취소 되었음");
		}finally {
			randomFile.close();
		}
	}
	
	
	@RequestMapping(value="/audio/{video_name}",method=RequestMethod.GET)
	public void getContentMediaAudio(@PathVariable("video_name")String video_name, HttpServletRequest request
			, HttpServletResponse response) throws Exception{
		String movieName = video_name+".mp3";
		//System.out.println({video_name});
//		System.out.println("test : "+movieName);
		File file = new File(".");
//		System.out.println(file.getAbsolutePath());
		String s = System.getProperty("user.dir");

//	    System.out.println("현재 디렉토리는 " + s + " 입니다");
		RandomAccessFile randomFile = new RandomAccessFile(new File(movieDir, movieName),"r");
		//File randomFile = new File("/");
//		System.out.println();
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
			System.out.println(partSize+" "+rangeEnd+" "+rangeStart);
			logger.debug("accepted range: {}",rangeStart + "-"+rangeEnd+"/"+partSize+"isPart:"+isPart);
			
			response.reset();
			response.setStatus(isPart ? 206 : 200);
			response.setContentType("video/mp4");
			
			
			response.setHeader("Content-Range","bytes "+rangeStart+"-"+rangeEnd+"/"+movieSize);
			response.setHeader("Accept-Ranges", "bytes");
			response.setHeader("Content-Length", ""+partSize);
			OutputStream out = response.getOutputStream();
			randomFile.seek(rangeStart);
			
			int bufferSize = 8*1024;
			byte[] buf = new byte[bufferSize];
			System.out.println("출력 시작");
			do {
				int block = partSize > bufferSize ? bufferSize : (int)partSize;
				int len = randomFile.read(buf, 0, block);
				out.write(buf,0,len);
				partSize -= block;
				System.out.println("len : "+len);
			}while(partSize > 0);
			System.out.println("출력 츨력 끝");
			logger.debug("sent "+movieName + ""+rangeStart + "-"+rangeEnd);
			
		}catch(Exception e) {
			logger.debug("전송이 취소 되었음");
		}finally {
			randomFile.close();
		}
	}
}
