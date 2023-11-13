import GameEntries.GameEntry;
import GameEntries.Scoreboard;

public class Main {
    public static void main(String[] args) {
        int capacity = 5;
        Scoreboard scoreboard = new Scoreboard(capacity);

        GameEntry gameEntry1 = new GameEntry("Allan", 293);
        GameEntry gameEntry2 = new GameEntry("Junior", 400);
        GameEntry gameEntry3 = new GameEntry("Beth", 9209);
        GameEntry gameEntry4 = new GameEntry("Bran", 200);

        scoreboard.addEntry(gameEntry1);
        scoreboard.addEntry(gameEntry2);
        scoreboard.addEntry(gameEntry3);
        scoreboard.addEntry(gameEntry4);

        for (int i = 0; i < (capacity - 1); i++) {
            GameEntry currentGameEntry = scoreboard.getBoard()[i];
            System.out.println(currentGameEntry.getName() + " - " + currentGameEntry.getScore());
        }

    }
}