package main.java.org.lldProblemStatements.cricinfo;

import java.util.*;

public class Event {
    protected List<Match> matches;
    protected List<Team> teams;
    protected long startDate;
    protected long endDate;
    protected String hostCountry;

    public Event(long startDate, long endDate, String hostCountry) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.hostCountry = hostCountry;
    }

    public long getStartDate() {
        return startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public String getHostCountry() {
        return hostCountry;
    }

    public void addMatch(Match match){
        matches.add(match);
    }

    public void addTeam(Team team){
        teams.add(team);
    }
}
