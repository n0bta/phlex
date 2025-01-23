package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Phlex {
    private static final String BASE_URL = "https://lawphil.net";
    public static final String[] MONTHS = {"jan", "feb", "mar", "apr", "may", "jun",
            "jul", "aug", "sep", "oct", "nov", "dec"};
    @SuppressWarnings("unused")
    public static final int MAX_YEAR = 2024;
    @SuppressWarnings("unused")
    public static final int MIN_YEAR = 1910;

    public static String buildUrl(int year, String month) {
        //noinspection SpellCheckingInspection
        return BASE_URL +
                "/judjuris" +
                "/juri" +
                year +
                '/' +
                month +
                year +
                '/' +
                month +
                year +
                ".html";
    }

    public static List<PhlexCase> getCases(Document document) {
        Elements xy = document.select("tr.xy");
        if (xy.isEmpty()) {
            xy = document.getElementsByTag("tr");
        }
        List<PhlexCase> cases = new ArrayList<>();
        for (Element element : xy) {
            PhlexCase phlexCase = new PhlexCase();

            // number
            Element caseNumberLink = element.selectFirst("td:nth-child(1) a");
            if (caseNumberLink != null && !caseNumberLink.text().isEmpty()) {
                phlexCase.setNumber(caseNumberLink.text());
            } else {
                continue;
            }

            // html url
            phlexCase.setHtmlUrl(caseNumberLink.attr("abs:href"));

            // date
            Element date = element.selectFirst("td:nth-child(1)");
            if (date != null) {
                phlexCase.setDate(date.ownText());
            }

            // title
            Elements title = element.select("td:nth-child(2)");
            if (!title.isEmpty()) {
                phlexCase.setTitle(title.text());
            }

            // pdf url
            Element pdfLink = element.selectFirst("td:nth-child(3) a");
            if (pdfLink != null) {
                phlexCase.setPdfUrl(pdfLink.attr("abs:href"));
            }

            cases.add(phlexCase);
        }
        return cases;
    }

    public static List<PhlexCase> getCases(int year, String month) throws IOException {
        return Phlex.getCases(Jsoup.connect(Phlex.buildUrl(year, month)).get());
    }
}
