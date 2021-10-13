package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Post;
import ru.job4j.grabber.utils.Parse;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    @Override
    public List<Post> list(String link) {
        List<Post> rsl = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(link).get();
            Elements row = doc.select(".postslisttopic");
            for (Element ed : row) {
                if (ed.text().contains("Важно")) {
                    continue;
                }
                Post post = new Post();
                System.out.println(post.getId());
                post.setTitle(ed.child(0).text());
                post.setLink(ed.child(0).attr("href"));
                SqlRuDateTimeParser sql = new SqlRuDateTimeParser();
                LocalDateTime date = sql.parse(ed.parent().children().get(5).text());
                post.setCreated(date);
                rsl.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override

    public Post detail(String link) {
        return null;
    }

    public static String loadString(String url) throws Exception {
        Document doc = Jsoup.connect(url).get();
        Elements row = doc.select(".msgBody");
        Element message = row.get(1);

        Elements row1 = doc.select(".msgFooter");
        Element date = row1.get(0);

        String[] dateArray = date.text().split(", ");
        String[] dateArray2 = dateArray[1].split(" ");
        String day = dateArray[0] + ", " + dateArray2[0];

        return message.text() + " ДАТА СООБЩЕНИЯ: " + day;
    }


    public static void main(String[] args) throws Exception {
        String exp = loadString("https://www.sql.ru/forum/1325330/lidy-be-fe-senior-cistemnye-analitiki-qa-i-devops-moskva-do-200t");
        System.out.println(exp);
    }
}
