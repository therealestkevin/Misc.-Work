package test.test1;

import java.io.IOException;


	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.io.Reader;
	import java.net.URL;
	import java.nio.charset.Charset;

	import org.json.JSONException;
	import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;

	public class gson {

	  private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	  private static String readUrl(String urlString) throws Exception {
		    BufferedReader reader = null;
		    try {
		        URL url = new URL(urlString);
		        reader = new BufferedReader(new InputStreamReader(url.openStream()));
		        StringBuffer buffer = new StringBuffer();
		        int read;
		        char[] chars = new char[1024];
		        while ((read = reader.read(chars)) != -1)
		            buffer.append(chars, 0, read); 

		        return buffer.toString();
		    } finally {
		        if (reader != null)
		            reader.close();
		    }
		}
	  public static void main(String[] args) throws Exception {
	    //JSONObject json = readJsonFromUrl("https://www.googleapis.com/books/v1/volumes?q=isbn:9780679734529&key=AIzaSyB4FziQm9LM2Nahb3SsKbME7_cTq60x2_Q");
	    //String jsonReqText = json.toString();
	    
	   String temp ="https://www.googleapis.com/books/v1/volumes?q=isbn:9780679734529&key=AIzaSyB4FziQm9LM2Nahb3SsKbME7_cTq60x2_Q";
	    
	   System.out.println(readUrl(temp));
	    /*Gson gson = new Gson();
	  OuterURL test = gson.fromJson(jsonReqText, OuterURL.class);
	  System.out.println(test.items.get(0).searchInfo.textSnippet);*/
	 
	  }
	
	
}
