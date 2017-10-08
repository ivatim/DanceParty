package main;

import java.util.Observable;
import java.util.Random;

public class MusicBox extends Observable implements Runnable {
    private boolean musicOn = true;
    private MusicGenre currentMusic;

    public void run() {
        while (musicOn) {
            currentMusic = MusicGenre.values()[new Random().nextInt(3)];// включается одно из 3х направлений
            System.out.println("now playing: " + currentMusic);
            setChanged();
            notifyObservers(currentMusic);//оповещаем наблюдателей(Dancer)
            try {
                Thread.sleep(5000);// каждые 5 секунд меняется музыка
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //не используемый метод (выключить музыку)
    public void shutDown() {
        musicOn = false;
        System.out.println("stop music party");
    }


}
