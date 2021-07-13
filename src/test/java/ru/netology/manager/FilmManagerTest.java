package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AddFilm;
import ru.netology.manager.FilmManager;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {
    FilmManager manager = new FilmManager();
    AddFilm first = new AddFilm(1, 1, "first", 150);
    AddFilm second = new AddFilm(2, 2, "second", 200);
    AddFilm third = new AddFilm(3, 3, "third", 100);
    AddFilm forth = new AddFilm(4, 4, "forth", 250);
    AddFilm fifth = new AddFilm(5, 5, "fifth", 50);

    @Test
    public void ShouldAddFilmAndShowResultsBackwards(){

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);

        AddFilm[] expected = new AddFilm[]{forth, third, second, first};
        AddFilm[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldShowLastResultsWithNewLimit(){
        FilmManager manager = new FilmManager(3);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fifth);

        AddFilm[] expected = new AddFilm[]{fifth, third, second};
        AddFilm[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

    }

}