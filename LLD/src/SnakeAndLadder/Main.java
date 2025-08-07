package SnakeAndLadder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Snake> snakes = List.of(
                new Snake(99, 21),
                new Snake(70, 55),
                new Snake(52, 42),
                new Snake(25, 2)
        );

        List<Ladder> ladders = List.of(
                new Ladder(3, 22),
                new Ladder(5, 8),
                new Ladder(11, 26),
                new Ladder(20, 29)
        );

        Board board = new Board(100, snakes, ladders);
        List<Player> players = List.of(new Player("Alice"), new Player("Bob"));
        Dice dice = new Dice(6);

        Game game = new Game(board, players, dice);
        game.start();
    }
}
