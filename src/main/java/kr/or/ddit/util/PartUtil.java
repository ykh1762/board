package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtil {
	
	public static String getFileNameFromPart(String contentDisposition) {
		// form-data; name="uploadFile"; filename="cony.png"

		String[] arr = contentDisposition.substring(11).split("; ");
		
		String[] arr2 = arr[1].split("\"");
		
		String fileName = arr2[1];
		
		return fileName;
	}

}
