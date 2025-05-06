package StructuralDesignPattern.AdapterPattern;

public class MediaAdapter implements  MediaPlayer{
    private AdvanceMediaPlayer advancedPlayer = new AdvanceMediaPlayer();
    public void play(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        } else if (fileType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(fileName);
        } else {
            System.out.println("Format not supported: " + fileType);
        }
    }
}
