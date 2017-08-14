package _001_2017_08_14;

class Game {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    int getScore() {
        int score = 0;
        int currentRoll = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(currentRoll)) {
                score += 10 + strikeBonus(currentRoll);
                currentRoll++;
            } else if (isSpare(currentRoll)) {
                score += 10 + spareBonus(currentRoll);
                currentRoll += 2;
            } else {
                score += sumInFrame(currentRoll);
                currentRoll += 2;
            }
        }
        return score;
    }

    private int sumInFrame(int currentRoll) {
        return rolls[currentRoll] + rolls[currentRoll + 1];
    }

    private int spareBonus(int currentRoll) {
        return rolls[currentRoll + 2];
    }

    private int strikeBonus(int currentRoll) {
        return rolls[currentRoll + 1] + rolls[currentRoll + 2];
    }

    private boolean isStrike(int currentRoll) {
        return rolls[currentRoll] == 10;
    }

    private boolean isSpare(int currentRoll) {
        return rolls[currentRoll] + rolls[currentRoll + 1] == 10;
    }

    void roll(int pins) {
        rolls[currentRoll++] = pins;
    }
}
