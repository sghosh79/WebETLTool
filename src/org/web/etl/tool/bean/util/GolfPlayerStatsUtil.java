package org.web.etl.tool.bean.util;

import org.web.etl.tool.bean.Player;


//This class provides methods to take HTML data and give you a player object, with name, stats and all
public class GolfPlayerStatsUtil {
	
	public static Player getPlayerFromHtml(String html)
	{
		Player player = new Player();
		String playerName;
		String temp;
		
		//Find the name in the HTML - if you want to use a library, you can, this is what the library is essentially doing
		temp = html.substring(html.indexOf("<title>")+7);
		temp = temp.substring(0, temp.indexOf("Stats"));
		
		playerName = temp;
		player.setName(playerName);	
		
		return player;		
	}

}
