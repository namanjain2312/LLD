package SnakeAndLadder;

import java.util.Random;

public class Dice {
    private final int faces;
    private final Random random;

    public Dice(int faces) {
        this.faces = faces;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(faces) + 1; // 1 to faces
    }
}
