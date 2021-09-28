package ru.job4j.grabber.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SqlRuDateTimeParser implements DateTimeParser {

    private static final Map<String, String> MONTHS = Map.ofEntries(
            Map.entry("янв", "01"),
            Map.entry("фев", "02"),
            Map.entry("мар", "03"),
            Map.entry("апр", "04"),
            Map.entry("мая", "05"),
            Map.entry("июн", "06"),
            Map.entry("июл", "07"),
            Map.entry("авг", "08"),
            Map.entry("сен", "09"),
            Map.entry("окт", "10"),
            Map.entry("ноя", "11"),
            Map.entry("дек", "12")
    );

    @Override
    public LocalDateTime parse(String parse) {
        String[] data = parse.split(", ");
        String[] time = data[0].split(" ");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d M yy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate localDate;
        LocalTime localTime = LocalTime.parse(data[1], timeFormatter);
        if (time[0].equals("сегодня")) {
            localDate = LocalDate.now();
        } else if (time[0].equals("вчера")) {
            localDate = LocalDate.now().minusDays(1);
        } else {
            localDate = LocalDate.parse(String.format("%s %s %s",
                    time[0], MONTHS.get(time[1]), time[2]), dateTimeFormatter);
        }
        return LocalDateTime.of(localDate, localTime);
    }

    public static void main(String[] args) throws Exception {
        SqlRuDateTimeParser sqlRuDateTimeParser = new SqlRuDateTimeParser();
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();
        Elements row = doc.select("td[style].altCol");
        for (Element td : row) {
            LocalDateTime exp = sqlRuDateTimeParser.parse(td.text());
            System.out.println(exp);
            Element date = td.parent().child(5);
            System.out.println(date.text());
        }
    }
}
