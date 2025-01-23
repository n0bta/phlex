package org.example;

public class PhlexCase {
    private String number;
    private String date;
    private String title;
    private String htmlUrl;
    private String pdfUrl;

    public PhlexCase() {
    }

    public PhlexCase(String number, String date, String title, String htmlUrl, String pdfUrl) {
        this.number = number;
        this.date = date;
        this.title = title;
        this.htmlUrl = htmlUrl;
        this.pdfUrl = pdfUrl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    @Override
    public String toString() {
        return "PhlexCase{" +
                "number='" + number + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", pdfUrl='" + pdfUrl + '\'' +
                '}';
    }
}
