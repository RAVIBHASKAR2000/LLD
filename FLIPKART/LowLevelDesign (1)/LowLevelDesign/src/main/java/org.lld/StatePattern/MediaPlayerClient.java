package main.java.org.lld.StatePattern;

public class MediaPlayerClient {

    public static void main(String[] args){
        MediaPlayerState stopState = new MediaPlayerStopState();
        MediaPlayerContext mediaPlayer = new MediaPlayerContext(stopState);

        mediaPlayer.displayCurrentState();

        mediaPlayer.setPlayerContext(new MediaPlayerPlayingState());

        mediaPlayer.displayCurrentState();
        mediaPlayer.playMedia();
        mediaPlayer.stopMedia();
        mediaPlayer.pauseMedia();

    }

}
