package _002_2017_08_20;

class Game {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    int getScore() {
        int score = 0;

        int current = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(current)) {
                score += 10 + strikeBonus(current);
                current += 1;
            } else if (isSpare(current)) {
                score += 10 + spareBonus(current);
                current += 2;
            } else {
                score += sumOfFrame(current);
                current += 2;
            }
        }
        return score;
    }

    private int sumOfFrame(int current) {
        return rolls[current] + rolls[current + 1];
    }

    private int spareBonus(int current) {
        return rolls[current + 2];
    }

    private int strikeBonus(int current) {
        return rolls[current + 1] + rolls[current + 2];
    }

    private boolean isStrike(int current) {
        return rolls[current] == 10;
    }

    private boolean isSpare(int current) {
        return rolls[current] + rolls[current + 1] == 10;
    }
}
