package StructuralDesignPattern.AdapterPattern;


public class Main {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("mp3", "beat.mp3");
        player.play("mp4", "movie.mp4");
        player.play("vlc", "clip.vlc");
        player.play("avi", "file.avi");  // Unsupported
    }
}