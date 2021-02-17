package com.cit.board.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cit.file.model.FileDto;

public class ExtractFiles {
	public static List<FileDto> makeFileList(String content) {
		List<String> imagePath = extractImageSrc(content, "<img[^>]*src=[\\\"']?([^>\\\"']+)[\\\"']?[^>]*>");
		List<String> imageName = extracImageName(imagePath);
		List<FileDto> fList = new ArrayList<FileDto>();
		
		for(int i =0; i<imagePath.size(); i++) {
			FileDto fdto = new FileDto();
			fdto.setPath(imagePath.get(i));
			fdto.setcName(imageName.get(i));
			
			fList.add(fdto);
		}
		return fList;
	}
	
	public static List<String> extractImageSrc(String content, String reg) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(content);
		List<String> imagePath = new ArrayList<String>();
		
		while(matcher.find()) {
			imagePath.add(matcher.group(1).trim());
		};
		return imagePath;
		
	}
	
	public static List<String> extracImageName(List<String> imagePath) {
		List<String> imageName = new ArrayList<String>();
		
		for(String image : imagePath) {
			int lastIndex = image.lastIndexOf("/");
			String result = image.substring(lastIndex+1);
			imageName.add(result);
		}
		return imageName;
	}
}
