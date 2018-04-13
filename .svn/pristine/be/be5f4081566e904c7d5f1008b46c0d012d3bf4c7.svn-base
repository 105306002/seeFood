import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WordCounter {
	private String urlStr;
    private String content;
    private String retVal = "";
    
    public WordCounter(String urlStr){
    	this.urlStr = urlStr;
    }
    
    private String fetchContent() throws IOException{
    	if(urlStr.equals("Invalid url")){
    		return "";
    	}else{
    		try
    		{
	    		URL url = new URL(this.urlStr);
	        	
	        	HttpURLConnection conn = (HttpURLConnection)url.openConnection();//通道
	        	conn.connect();
	        	//Document doc = Jsoup.connect(urlStr).get();
	        	
	        	InputStream in = conn.getInputStream();
	        	BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
	        	
	        	String line = null;
	        	//String docu = String.valueOf(doc);
	        	while((line = br.readLine()) != null)
	        	{
	        		retVal = retVal + line + "\n";
	        	}
	        	
    		}//取得網頁內容
        	catch (Exception e)
			{
				for (int i = urlStr.length() - 1; i >= 0; i--)
				{
					char u = '/';
					if (urlStr.charAt(i) == u)
					{
						urlStr = urlStr.substring(0, i);
						break;
					}
				}
			}
        	//buffer是一格一格的
    		return retVal;
        	
        	
    	}
    	
    }
    
    public int countKeyword(String keyword) throws IOException{
    	
    	if(urlStr.equals("Invalid url")){
    		return 0;
    	}else{
    		if(content == null)
        		content = fetchContent();
        	
        	content = content.toUpperCase();
        	keyword = keyword.toUpperCase();
        	
        	int retVal = 0;
        	int fromIdx = 0;
        	int found = -1;
        	
        	while((found = content.indexOf(keyword, fromIdx)) != -1){
        		retVal ++;
        		fromIdx = found + keyword.length();
        	}
        	return retVal;
    	}
    	
    }
}
