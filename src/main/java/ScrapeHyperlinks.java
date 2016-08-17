import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ScrapeHyperlinks {
 
  public static void main(String[] args) {
    ArrayList<String> imagesArr = new ArrayList<String>();
    try {
      // fetch the document over HTTP
      Document doc = Jsoup.connect("http://giphy.com/search/cat").get();
      
      // get the page title
      String title = doc.title();
      System.out.println("title: " + title);
      
      // get all links in page
      Elements images = doc.select("img[src]");
      for (Element image : images) {
        imagesArr.add(image.attr("data-animated"));
        // get the value from the href attribute
        //System.out.println("\nimg: " + image.attr("data-animated"));
        //System.out.println("text: " + image.text());
      }
    } catch (IOException e) {
    e.printStackTrace();
    }
    System.out.println(imagesArr.toString());

    //----------------------------------------------
    String json = new Gson().toJson(imagesArr);

    try {

      //FileWriter file = new FileWriter("c:\\test.json");
      FileWriter file = new FileWriter("images.json");
      file.write(json);
      file.flush();
      file.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    //----------------------------------------------

  }
}