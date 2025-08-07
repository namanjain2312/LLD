package SnakeAndLadder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private final int size;
    private final Map<Integer, Integer> jumpMap;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.jumpMap = new HashMap<>();

        for (Snake snake : snakes) {
            jumpMap.put(snake.getStart(), snake.getEnd());
        }
        for (Ladder ladder : ladders) {
            jumpMap.put(ladder.getStart(), ladder.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public int getNextPosition(int currentPosition) {
        return jumpMap.getOrDefault(currentPosition, currentPosition);
    }

}
