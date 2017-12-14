package pl.edu.agh.ki.bd2;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.databaseStatistics();
        System.out.println("Ben Simmons");
        System.out.println(solution.findAllRelationshipsForPlayer("Ben Simmons"));
        System.out.println("Philadelphia 76ers");
        System.out.println(solution.findAllRelationshipsForTeam("Philadelphia 76ers"));
        System.out.println("2016");
        System.out.println(solution.findAllRelationshipsForDraft("2016"));

        System.out.println(solution.findRoutesForTeamAndPlayer("Philadelphia 76ers", "Ben Simmons"));
        System.out.println(solution.findRoutesForTeamAndDraft("Golden State Warriors", "2007"));
        System.out.println(solution.findRoutesForPlayerAndDraft("Russell Westbrook", "2008"));

        //solution.findRelationshipsForAllTeams();
        //solution.findRelationshipsForAllDrafts();
    }
}
