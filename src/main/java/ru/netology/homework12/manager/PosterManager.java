package ru.netology.homework12.manager;

public class PosterManager {
    private String[] films = new String[0];
    private int maxLimit;

    public PosterManager() {
        maxLimit = 5;
    }

    public PosterManager(int maxLimit) {
        if (maxLimit > 0) {
            this.maxLimit = maxLimit;
        } else {
            this.maxLimit = 5;
        }
    }

    public void setFilms(String[] films) {
        this.films = films;
    }

    public String[] getFilms() {
        return films;
    }

//    public void setMaxLimit(int maxLimit) {
//        this.maxLimit = maxLimit;
//    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void addNewFilm(String newFilm) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = newFilm;
        films = tmp;
    }

    public String[] findAll() {
        String[] result = new String[films.length];
        int index = 0;
        for (String film : films) {
            result[index] = film;
            index++;
        }
        return result;
    }

    public String[] findLast() {
        int resultLength;
        if (maxLimit < films.length) {
            resultLength = maxLimit;
        } else {
            resultLength = films.length;
        }

        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - i - 1];
        }

        return result;
    }
}
