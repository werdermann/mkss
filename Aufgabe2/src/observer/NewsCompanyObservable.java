package observer;

import java.util.Observable;

public class NewsCompanyObservable extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }

}