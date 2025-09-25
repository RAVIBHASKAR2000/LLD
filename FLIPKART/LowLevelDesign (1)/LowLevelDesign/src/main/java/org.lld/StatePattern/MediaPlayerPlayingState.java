package main.java.org.lld.StatePattern;

public class MediaPlayerPlayingState implements MediaPlayerState {
    @Override
    public void play() {
        System.out.println("The media player is already playing!");
    }

    @Override
    public void pause() {
        System.out.println("The media player is paused!");
    }

    @Override
    public void stop() {
        System.out.println("The media player is stopped!");
    }

    @Override
    public void display(){
        System.out.println("Current state of the media player is Playing!");
    }
}
