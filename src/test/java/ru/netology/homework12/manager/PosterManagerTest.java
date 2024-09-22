package ru.netology.homework12.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PosterManagerTest {
    PosterManager poster = new PosterManager();

    @Test
    public void shouldAddOneNewFilm() {
        poster.addNewFilm("FilmOne");
        String[] expected = {"FilmOne"};

        String[] actual = poster.getFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTwoNewFilms() {
        poster.addNewFilm("FilmOne");
        poster.addNewFilm("FilmTwo");

        String[] expected = {"FilmOne", "FilmTwo"};
        String[] actual = poster.getFilms();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFilms() {
        poster.setFilms(new String[]{"FilmOne", "FilmTwo", "FilmThree"}); //могу ли я установить фильмы как начальные условия?

        String[] actual = poster.findAll();
        String[] expected = {"FilmOne", "FilmTwo", "FilmThree"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 5",
            "0, 5",
            "1, 1",
            "2, 2"
    })
    public void shouldSetMaxLimit(int maxLimit, int expected) {
        PosterManager posterWithConst = new PosterManager(maxLimit);

        int actual = posterWithConst.getMaxLimit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsIfDefaultConstructorAndUnderLimit() {
        poster.setFilms(new String[]{"FilmOne", "FilmTwo", "FilmThree"});

        String[] actual = poster.findLast();
        String[] expected = {"FilmThree", "FilmTwo", "FilmOne"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsIfDefaultConstructorAndLimitLimit() {
        poster.setFilms(new String[]{"FilmOne", "FilmTwo", "FilmThree", "FilmFour", "FilmFive"});

        String[] actual = poster.findLast();
        String[] expected = {"FilmFive", "FilmFour", "FilmThree", "FilmTwo", "FilmOne"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsIfDefaultConstructorAndHighLimit() {
        poster.setFilms(new String[]{"FilmOne", "FilmTwo", "FilmThree", "FilmFour", "FilmFive", "FilmSix", "FilmSeven"});

        String[] actual = poster.findLast();
        String[] expected = {"FilmSeven", "FilmSix", "FilmFive", "FilmFour", "FilmThree"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfNotDefaultConstructor() {
        PosterManager posterWithConst = new PosterManager(2);
        posterWithConst.setFilms(new String[]{"FilmOne", "FilmTwo", "FilmThree", "FilmFour"});

        String[] actual = posterWithConst.findLast();
        String[] expected = {"FilmFour", "FilmThree"};

        Assertions.assertArrayEquals(expected, actual);
    }
}
