package main;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MusicBox musicBox = new MusicBox();
        for (int i = 0; i < 10; i++) {
            new Dancer(musicBox);//создаем рандомное колличество танцоров
        }
        Thread thread = new Thread(musicBox);
        thread.start();//включаем музыку
        thread.join();
    }
}
