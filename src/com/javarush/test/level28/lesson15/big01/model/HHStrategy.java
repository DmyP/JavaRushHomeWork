package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String USERAGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36";
    private static final String REFERRER = "http://www.google.com.ua";
    private static final int TIMEOUT = 5 * 1000;
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> list = new ArrayList<>();

        int i = 0;
        while (true) {
            try {
                Document document = getDocument(searchString, i++);
                Elements elements = document.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy");
                if (elements.size() > 0) {
                    for (Element element : elements) {
                        Vacancy vvacancyc = new Vacancy();
                        vvacancyc.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy" + "-title").attr("href"));
                        vvacancyc.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy" + "-title").text());
                        vvacancyc.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy" + "-address").text());
                        vvacancyc.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy" + "-employer").text());
                        Elements sal = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy" + "-compensation");
                        if (sal.size() == 0) vvacancyc.setSalary("");
                        else vvacancyc.setSalary(sal.text());
                        vvacancyc.setSiteName(document.title());
                        list.add(vvacancyc);
                    }
                }
            } catch (IOException e) {}
            return list;
        }
    }

    protected  Document getDocument(String searchString, int page) throws IOException{
        String url = String.format(URL_FORMAT, searchString, page);
        try {
            Document doc = Jsoup.connect(url).userAgent(USERAGENT).referrer(REFERRER).timeout(TIMEOUT).get();
            return doc;
        }
        catch (IOException e) {
            return null;
        }
    }
}
