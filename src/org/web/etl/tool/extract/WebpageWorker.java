package org.web.etl.tool.extract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WebpageWorker {	

	public static String downloadPage(String inputURL) throws IOException{	
		
		StringBuffer sb = new StringBuffer(); 			//We use StringBuffer to capture a large String.  It is more efficient.
		URL url = new URL(inputURL);					//Create a URL object
		BufferedReader in = null;						//Create a BufferedReader object - this will read the raw code from the internet)
		in = new BufferedReader(new InputStreamReader(url.openStream()));		
		String inputLine;
		
		while ((inputLine = in.readLine()) != null)
		{
			sb.append(inputLine);
		}		
				
		return sb.toString();							//Convert the StringBuffer into a String when returning		
	}
	
}
