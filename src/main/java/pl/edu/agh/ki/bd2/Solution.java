package pl.edu.agh.ki.bd2;

public class Solution {
    private final GraphDatabase graphDatabase = GraphDatabase.createDatabase();

    public void databaseStatistics() {
        System.out.println(graphDatabase.runCypher("CALL db.labels()"));
        System.out.println(graphDatabase.runCypher("CALL db.relationshipTypes()"));
        System.out.println(graphDatabase.runCypher("CALL db.schema()"));
    }

    public void findRelationshipsForAllPlayers() {
        System.out.println(findAllRelationshipsForPlayer("Ben Simmons"));
        System.out.println(findAllRelationshipsForPlayer("Kevin Durant"));
        System.out.println(findAllRelationshipsForPlayer("Russell Westbrook"));
        System.out.println(findAllRelationshipsForPlayer("Kyrie Irving"));
        System.out.println(findAllRelationshipsForPlayer("Marcin Gortat"));
        System.out.println(findAllRelationshipsForPlayer("Jaylen Brown"));
        System.out.println(findAllRelationshipsForPlayer("Tristan Thompson"));
        System.out.println(findAllRelationshipsForPlayer("JaVale McGee"));
        System.out.println(findAllRelationshipsForPlayer("Bradley Beal"));
        System.out.println(findAllRelationshipsForPlayer("Jeff Green"));
    }

    public void findRelationshipsForAllTeams() {
        System.out.println(findAllRelationshipsForTeam("Philadelphia 76ers"));
        System.out.println(findAllRelationshipsForTeam("Golden State Warriors"));
        System.out.println(findAllRelationshipsForTeam("Oklahoma City Thunder"));
        System.out.println(findAllRelationshipsForTeam("Boston Celtics"));
        System.out.println(findAllRelationshipsForTeam("Washington Wizards"));
        System.out.println(findAllRelationshipsForTeam("Cleveland Cavaliers"));
    }

    public void findRelationshipsForAllDrafts() {
        System.out.println(findAllRelationshipsForDraft("2016"));
        System.out.println(findAllRelationshipsForDraft("2007"));
        System.out.println(findAllRelationshipsForDraft("2008"));
        System.out.println(findAllRelationshipsForDraft("2011"));
        System.out.println(findAllRelationshipsForDraft("2005"));
        System.out.println(findAllRelationshipsForDraft("2012"));
    }

    public String createPlayer(String name, String birthDate, String county, String position) {
        String query = String.format("CREATE (p:Player {name: '%s', birthDate: '%s', country: '%s', position: '%s'}) " +
                "RETURN p", name, birthDate, county, position);
        return graphDatabase.runCypher(query);
    }

    public String createTeam(String name, String foundedIn, String conference) {
        String query = String.format("CREATE (t:Team {name: '%s', foundedIn: '%s', conference: '%s'}) RETURN t", name, foundedIn, conference);
        return graphDatabase.runCypher(query);
    }

    public String createDraft(String year, String firstSelectionBy) {
        String query = String.format("CREATE (d:Draft {year: '%s', firstSelectionBy: '%s'}) RETURN d", year, firstSelectionBy);
        return graphDatabase.runCypher(query);
    }

    public String createPlaysInRelationship(String player, String team, String year) {
        String query = String.format("MATCH (p:Player), (t:Team) WHERE p.name = '%s' AND t.name = '%s' " +
                "CREATE (p) -[r:PLAYS_IN {since: '%s'}]->(t) RETURN r", player, team, year);
        return graphDatabase.runCypher(query);
    }

    public String createDraftedInRelationship(String player, String draftYear, String number, String team) {
        String query = String.format("MATCH (p:Player), (d:Draft) WHERE p.name = '%s' AND d.year = '%s' " +
                "CREATE (p) -[r:DRAFTED_IN {number: '%s', team: '%s'}]->(d) RETURN r", player, draftYear, number, team);
        return graphDatabase.runCypher(query);
    }

    public String createTookPartInRelationship(String team, String draftYear, String firstPickNumber) {
        String query = String.format("MATCH (t:Team), (d:Draft) WHERE t.name = '%s' AND d.year = '%s' " +
                "CREATE (t) -[r:TOOK_PART_IN {firstPickNumber: '%s'}]->(d) RETURN r", team, draftYear, firstPickNumber);
        return graphDatabase.runCypher(query);
    }

    public String findAllRelationshipsForPlayer(String player) {
        String query = String.format("MATCH (p:Player)-[r]-() WHERE p.name = '%s' RETURN r", player);
        return graphDatabase.runCypher(query);
    }

    public String findAllRelationshipsForTeam(String team) {
        String query = String.format("MATCH (t:Team)-[r]-() WHERE t.name = '%s' RETURN r", team);
        return graphDatabase.runCypher(query);
    }

    public String findAllRelationshipsForDraft(String draftYear) {
        String query = String.format("MATCH (d:Draft)-[r]-() WHERE d.year = '%s' RETURN r", draftYear);
        return graphDatabase.runCypher(query);
    }

    public String findRoutesForTeamAndPlayer(String team, String player) {
        String query = String.format("MATCH path = (t:Team)-[r*..5]-(p:Player) WHERE t.name = '%s' AND p.name = '%s' RETURN path", team, player);
        return graphDatabase.runCypher(query);
    }

    public String findRoutesForTeamAndDraft(String team, String draftYear) {
        String query = String.format("MATCH path = (t:Team)-[r*..5]-(d:Draft) WHERE t.name = '%s' AND d.year = '%s' RETURN path", team, draftYear);
        return graphDatabase.runCypher(query);
    }

    public String findRoutesForPlayerAndDraft(String player, String draftYear) {
        String query = String.format("MATCH path = (p:Player)-[r*..5]-(d:Draft) WHERE p.name = '%s' AND d.year = '%s' RETURN path", player, draftYear);
        return graphDatabase.runCypher(query);
    }
}
