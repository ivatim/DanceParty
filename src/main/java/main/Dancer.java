package main;

import java.util.*;

public class Dancer implements Observer {
    private Set<MusicGenre> abilities;// набор умений танцора (умений танцевать под разную музыку)
    private MusicBox musicBox;// cсылка на Observable объект

    public Dancer(MusicBox musicBox) {
        this.musicBox = musicBox;
        this.musicBox.addObserver(this);// запись танцора в список наблюдателей(ст метод Observable)
        abilities = new HashSet<MusicGenre>();
        for (int i = 0; i < MusicGenre.values().length - 1/*число попыток записать в HashSet рандомное умение*/; i++) {
            abilities.add(MusicGenre.values()[new Random().nextInt(3)]);// создаем танцору рандомное колличество умений
        }
        System.out.println("im coming");
    }

    public void goOut() {
        musicBox.deleteObserver(this);
        System.out.println("im going home");
    }
    //Observer функция - реагирует на изменение музыки в Observable
    public void update(Observable o, Object arg) {
        MusicGenre musicGenre = (MusicGenre) arg;
        if (abilities.contains(musicGenre)) {
            System.out.println("im dancing " + musicGenre);
        } else {
            System.out.println("im drinking vodka");
        }
    }
}
