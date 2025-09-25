package main.java.org.lld.StatePattern;

public class MediaPlayerPauseState implements MediaPlayerState {
    @Override
    public void play() {
        System.out.println("Playing the media!");
    }

    @Override
    public void pause() {
        System.out.println("Media is already paused!");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the media player!");
    }

    public void display(){
        System.out.println("Current state of the media player is Paused!");
    }
}
