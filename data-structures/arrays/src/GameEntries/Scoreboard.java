package GameEntries;

public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void addEntry(GameEntry entry) {
        int newScore = entry.getScore();

        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) numEntries++;

            int currentLowerScoreIndex = numEntries - 1;

            // this operation will take O(n) for the shifting and O(1) for the replacement.
            while (currentLowerScoreIndex > 0 && board[currentLowerScoreIndex - 1].getScore() < newScore) {
                board[currentLowerScoreIndex] = board[currentLowerScoreIndex - 1];
                currentLowerScoreIndex--;
            }
            board[currentLowerScoreIndex] = entry;
        }
    }

}
