package ru.netology.manager;

import ru.netology.domain.AddFilm;

public class FilmManager {
    private int managerLimit = 10;
    private AddFilm[] films = new AddFilm[0];


    public FilmManager(int managerLimit) {
        this.managerLimit = managerLimit;
    }

    public FilmManager() {

    }

    public void add(AddFilm film) {
        // создаём новый массив размером на единицу больше
        int length = films.length + 1;
        AddFilm[] tmp = new AddFilm[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(films, 0, tmp, 0, films.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public AddFilm[] getAll() {

        int resultLength;
        if (films.length < managerLimit){
           resultLength = films.length;
        }
        else {
            resultLength = managerLimit;
        }
        AddFilm[] result = new AddFilm[resultLength];
        for (int i = 0; i < resultLength; i++){
            int index = films.length - i - 1;
            result[i] = films[index];
            }
        return result;
    }
}


//          ??? resultLength;
//        if ??? {
//            resultLength = ???
//        } else {
//            resultLength = ???
//        }
//  ??? result = new ???[resultLength];
//        for (???) {
// заполняем result из массива что лежит в поле
// в обратном порядке
//        }

//Film[] result = new Film[10];
// перебираем массив в прямом порядке
// но кладём в результаты в обратном
//for (int i = 0; i < result.length; i++) {
//  int index = films.length - i - 1;
// result[i] = films[index];
//}
//return result;