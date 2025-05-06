package StructuralDesignPattern.AdapterPattern;


public class AudioPlayer implements MediaPlayer {
    private MediaAdapter adapter;

    public void play(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3: " + fileName);
        } else {
            adapter = new MediaAdapter();
            adapter.play(fileType, fileName);
        }
    }
}