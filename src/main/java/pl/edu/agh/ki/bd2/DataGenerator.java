package pl.edu.agh.ki.bd2;

public class DataGenerator {
    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        createPlayers();
        createTeams();
        createDrafts();
        createPlaysInRelationships();
        createDraftedInRelationships();
        createTookPartInRelationships();
    }

    private static void createPlayers() {
        System.out.println(solution.createPlayer("Ben Simmons", "20-07-1996", "Australia", "Point Guard"));
        System.out.println(solution.createPlayer("Kevin Durant", "29-09-1988", "USA", "Small Forward"));
        System.out.println(solution.createPlayer("Russell Westbrook", "12-11-1988", "USA", "Point Guard"));
        System.out.println(solution.createPlayer("Kyrie Irving", "23-03-1992", "USA", "Point Guard"));
        System.out.println(solution.createPlayer("Marcin Gortat", "17-02-1984", "Poland", "Center"));
        System.out.println(solution.createPlayer("Jaylen Brown", "24-10-1996", "USA", "Small Forward"));
        System.out.println(solution.createPlayer("Tristan Thompson", "13-03-1991", "Canada", "Power Forward"));
        System.out.println(solution.createPlayer("JaVale McGee", "19-01-1988", "USA", "Center"));
        System.out.println(solution.createPlayer("Bradley Beal", "28-06-1993", "USA", "Shooting Guard"));
        System.out.println(solution.createPlayer("Jeff Green", "28-08-1986", "USA", "Small Forward"));
    }

    private static void createTeams() {
        System.out.println(solution.createTeam("Philadelphia 76ers", "1946", "Eastern"));
        System.out.println(solution.createTeam("Golden State Warriors", "1946", "Western"));
        System.out.println(solution.createTeam("Oklahoma City Thunder", "1967", "Western"));
        System.out.println(solution.createTeam("Boston Celtics", "1946", "Eastern"));
        System.out.println(solution.createTeam("Washington Wizards", "1961", "Eastern"));
        System.out.println(solution.createTeam("Cleveland Cavaliers", "1970", "Eastern"));
    }

    private static void createDrafts() {
        System.out.println(solution.createDraft("2016", "Philadelphia 76ers"));
        System.out.println(solution.createDraft("2007", "Portland Trail Blazers"));
        System.out.println(solution.createDraft("2008", "Chicago Bulls"));
        System.out.println(solution.createDraft("2011", "Cleveland Cavaliers"));
        System.out.println(solution.createDraft("2005", "Milwaukee Bucks"));
        System.out.println(solution.createDraft("2012", "New Orleans Hornets"));
    }

    private static void createPlaysInRelationships() {
        System.out.println(solution.createPlaysInRelationship("Ben Simmons", "Philadelphia 76ers", "2016"));
        System.out.println(solution.createPlaysInRelationship("Kevin Durant", "Golden State Warriors", "2016"));
        System.out.println(solution.createPlaysInRelationship("Russell Westbrook", "Oklahoma City Thunder", "2008"));
        System.out.println(solution.createPlaysInRelationship("Kyrie Irving", "Boston Celtics", "2017"));
        System.out.println(solution.createPlaysInRelationship("Marcin Gortat", "Washington Wizards", "2013"));
        System.out.println(solution.createPlaysInRelationship("Jaylen Brown", "Boston Celtics", "2017"));
        System.out.println(solution.createPlaysInRelationship("Tristan Thompson", "Cleveland Cavaliers", "2011"));
        System.out.println(solution.createPlaysInRelationship("JaVale McGee", "Golden State Warriors", "2016"));
        System.out.println(solution.createPlaysInRelationship("Bradley Beal", "Washington Wizards", "2012"));
        System.out.println(solution.createPlaysInRelationship("Jeff Green", "Cleveland Cavaliers", "2017"));
    }

    private static void createDraftedInRelationships() {
        System.out.println(solution.createDraftedInRelationship("Ben Simmons", "2016", "1", "Philadelphia 76ers"));
        System.out.println(solution.createDraftedInRelationship("Kevin Durant", "2007", "2", "Oklahoma City Thunder"));
        System.out.println(solution.createDraftedInRelationship("Russell Westbrook", "2008", "4", "Oklahoma City Thunder"));
        System.out.println(solution.createDraftedInRelationship("Kyrie Irving", "2011", "1", "Cleveland Cavaliers"));
        System.out.println(solution.createDraftedInRelationship("Marcin Gortat", "2005", "57", "Phoenix Suns"));
        System.out.println(solution.createDraftedInRelationship("Jaylen Brown", "2016", "3", "Boston Celtics"));
        System.out.println(solution.createDraftedInRelationship("Tristan Thompson", "2011", "4", "Cleveland Cavaliers"));
        System.out.println(solution.createDraftedInRelationship("JaVale McGee", "2008", "18", "Washington Wizards"));
        System.out.println(solution.createDraftedInRelationship("Bradley Beal", "2012", "3", "Washington Wizards"));
        System.out.println(solution.createDraftedInRelationship("Jeff Green", "2007", "5", "Boston Celtics"));
    }

    private static void createTookPartInRelationships() {
        System.out.println(solution.createTookPartInRelationship("Philadelphia 76ers", "2016", "1"));
        System.out.println(solution.createTookPartInRelationship("Philadelphia 76ers", "2011", "16"));
        System.out.println(solution.createTookPartInRelationship("Cleveland Cavaliers", "2011", "1"));
        System.out.println(solution.createTookPartInRelationship("Boston Celtics", "2008", "30"));
        System.out.println(solution.createTookPartInRelationship("Cleveland Cavaliers", "2012", "4"));
        System.out.println(solution.createTookPartInRelationship("Golden State Warriors", "2007", "18"));
        System.out.println(solution.createTookPartInRelationship("Golden State Warriors", "2005", "9"));
        System.out.println(solution.createTookPartInRelationship("Washington Wizards", "2016", "13"));
        System.out.println(solution.createTookPartInRelationship("Oklahoma City Thunder", "2008", "4"));
        System.out.println(solution.createTookPartInRelationship("Oklahoma City Thunder", "2007", "2"));
    }
}
