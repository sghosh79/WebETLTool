package org.web.etl.tool;

import java.io.IOException;

import org.web.etl.tool.extract.WebpageWorker;

public class ScrapeWebDataTool {
	
	public static void main(String[] args) throws IOException{
		String htmlPage;
		
		htmlPage = WebpageWorker.downloadPage("http://espn.go.com/golf/player/_/id/3670/martin-kaymer");
		
		System.out.println(htmlPage);
		
	}
	
	public static void downloadAndUpdate(){
		
	}

}
