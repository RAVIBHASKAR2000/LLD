package main.java.org.lld.StatePattern;

public class MediaPlayerStopState implements MediaPlayerState {
    @Override
    public void play() {
        System.out.println("Playing the media from the beginning!");
    }

    @Override
    public void pause() {
        System.out.println("Media can be paused only when it is playing!");
    }

    @Override
    public void stop() {
        System.out.println("Media is already stopped!");
    }

    @Override
    public void display(){
        System.out.println("Current state of the media player is Stopped!");
    }
}
