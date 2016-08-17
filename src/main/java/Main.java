import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        File input = new File("login.html");
        Document doc = null;
        try {
            doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element content = doc.getElementById("content");
        Elements images = content.getElementsByTag("img");
        for (Element img : images) {
            String linkHref = img.attr("src");
            System.out.println(linkHref);
        }
    }
}
