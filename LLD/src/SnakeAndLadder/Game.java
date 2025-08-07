package SnakeAndLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;

    public Game(Board board, List<Player> playerList, Dice dice) {
        this.board = board;
        this.players = new LinkedList<>(playerList);
        this.dice = dice;
    }

    public void start() {
        while (true) {
            Player currentPlayer = players.poll();
            int roll = dice.roll();
            System.out.println(currentPlayer.getName() + " rolled a " + roll);

            int nextPos = currentPlayer.getPosition() + roll;
            if (nextPos > board.getSize()) {
                System.out.println("Invalid move. Staying at position " + currentPlayer.getPosition());
            } else {
                int finalPos = board.getNextPosition(nextPos);
                if (finalPos != nextPos) {
                    System.out.println(currentPlayer.getName() + " encountered a " +
                            (finalPos < nextPos ? "snake!" : "ladder!"));
                }
                currentPlayer.setPosition(finalPos);
                System.out.println(currentPlayer.getName() + " moved to " + finalPos);
            }

            if (currentPlayer.getPosition() == board.getSize()) {
                System.out.println("🎉 " + currentPlayer.getName() + " wins the game!");
                break;
            }

            players.offer(currentPlayer);
        }
    }
}
