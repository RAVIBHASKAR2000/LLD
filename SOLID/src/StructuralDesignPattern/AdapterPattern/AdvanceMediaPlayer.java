package StructuralDesignPattern.AdapterPattern;

public class AdvanceMediaPlayer {
    public void playMp4(String fileName) {
        System.out.println("Playing MP4: " + fileName);
    }

    public void playVlc(String fileName) {
        System.out.println("Playing VLC: " + fileName);
    }
}
