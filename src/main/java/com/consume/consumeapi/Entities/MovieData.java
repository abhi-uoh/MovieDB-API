package com.consume.consumeapi.Entities;

import javax.persistence.Entity;
import java.util.List;

public class MovieData {
    private int page;
    private List<Movie> results;
    public int getPage() {
        return page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
