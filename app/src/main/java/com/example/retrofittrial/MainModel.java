package com.example.retrofittrial;

import java.util.List;

public class MainModel {

    private List<Result> result;

    public List<Result> getResults() {
        return result;
    }

    public void setResults(List<Result> results) {
        this.result = results;
    }

    @Override
    public String toString() {
        return "MainModel{" +
                "results=" + result +
                '}';
    }

    public class Result{
        private int id;
        private String title;
        private String image;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        }
    }
}