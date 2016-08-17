
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
 
public class ScrapeHyperlinks {
 
  public static void main(String[] args) {
    try {
      // fetch the document over HTTP
      Document doc = Jsoup.connect("http://giphy.com/search/michael").get();
      
      // get the page title
      String title = doc.title();
      System.out.println("title: " + title);
      
      // get all links in page
      Elements links = doc.select("img[data-animated]");
      for (Element link : links) {
        // get the value from the href attribute
        System.out.println("\nimg: " + link.attr("data-animated"));
        System.out.println("text: " + link.text());
      }
    } catch (IOException e) {
    e.printStackTrace();
    }
  }
}