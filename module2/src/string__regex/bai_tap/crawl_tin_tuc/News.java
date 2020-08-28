package string__regex.bai_tap.crawl_tin_tuc;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//data-utm="Cate_TheGioi|Cover|1"
//<h3 class='news-item__title'>
public class News {
    public static void main(String[] args) {
        Scanner scanner=null;
        try {
            URL url=new URL("https://dantri.com.vn/the-gioi.htm");
           scanner=new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String html=scanner.next();
            html = html.replaceAll("\\R+", "");
            html=html.replaceAll("\\s+"," ");
            System.out.println(html);
            Pattern pattern=Pattern.compile("<h3 class='news-item__title'>(.*?)title=\"(.*?)\"");
            Matcher matcher=pattern.matcher(html);
            while (matcher.find()){
                System.out.println(matcher.group(2));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (scanner!=null){
                scanner.close();
            }
        }

    }
}
