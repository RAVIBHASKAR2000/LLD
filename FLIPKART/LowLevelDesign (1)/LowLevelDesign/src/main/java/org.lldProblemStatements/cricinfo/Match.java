package main.java.org.lldProblemStatements.cricinfo;

import java.util.*;

public abstract class Match {
//    protected ScoreCard scoreCard;
    protected List<String> commentary;
//    protected Stats gameStats;
    protected Team firstTeam;
    protected Team secondTeam;
    protected String venue;
//    protected Score currentScore;
    protected boolean isRunning;
    public Match(){
        //
    }
}

class T20Match extends Match{
    private final Format format = Format.T20_MATCH;

}

class TestMatch extends Match{
    private final Format format = Format.TEST_MATCH;
}

class ODIMatch extends Match{
    private final Format format = Format.ODI_MATCH;
}
