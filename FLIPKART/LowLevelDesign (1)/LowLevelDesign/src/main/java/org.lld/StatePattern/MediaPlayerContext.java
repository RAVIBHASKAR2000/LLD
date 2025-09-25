package main.java.org.lld.StatePattern;

public class MediaPlayerContext {
    MediaPlayerState mediaPlayerState;

    public MediaPlayerContext(MediaPlayerState mps){
        this.mediaPlayerState = mps;
    }
    public void setPlayerContext(MediaPlayerState mps){
        this.mediaPlayerState = mps;
    }
    public void playMedia(){ mediaPlayerState.play(); }
    public void pauseMedia(){ mediaPlayerState.pause(); }
    public void stopMedia(){ mediaPlayerState.stop(); }
    public void displayCurrentState(){ mediaPlayerState.display(); }

}
