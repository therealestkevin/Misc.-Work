package test.test1;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

public class mainTest {
    public static void main (String[]args){
       String urlString = "https://www.googleapis.com/books/v1/volumes?q=isbn:9780679734505&key=AIzaSyB4FziQm9LM2Nahb3SsKbME7_cTq60x2_Q";
       String resultString="";
        try {
            BufferedReader reader = null;
            try {
                URL url = new URL(urlString);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder buffer = new StringBuilder();
                int read;
                char[] chars = new char[1024];
                while ((read = reader.read(chars)) != -1)
                    buffer.append(chars, 0, read);

                resultString = buffer.toString();
            } finally {
                if (reader != null)
                    reader.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        OuterURL bob = new Gson().fromJson(resultString,OuterURL.class);

        String selfLink = bob.items.get(0).selfLink;
        String resultString2="";
        try {
            BufferedReader reader = null;
            try {
                URL url = new URL(selfLink);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder buffer = new StringBuilder();
                int read;
                char[] chars = new char[1024];
                while ((read = reader.read(chars)) != -1)
                    buffer.append(chars, 0, read);

                resultString2 = buffer.toString();
            } finally {
                if (reader != null)
                    reader.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resultString2);
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(resultString2).getAsJsonObject();
        JsonObject obj2 = obj.get("volumeInfo").getAsJsonObject();
        JsonElement subTitle = obj2.get("subtitle");
        JsonElement descrip = obj2.get("description");
        System.out.println(descrip.getAsString());
        System.out.println(subTitle.getAsString());
        JsonElement categories = obj2.get("categories");
        String[] elements = new Gson().fromJson(categories.toString(),String[].class);
        System.out.println(Arrays.toString(elements));

    }

}
