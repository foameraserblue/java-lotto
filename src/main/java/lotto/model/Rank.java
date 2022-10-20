package lotto.model;

import java.util.Arrays;

public enum Rank {

    NONE(new Money(0), 0),
    FIFTH(new Money(5_000), 3),
    FOURTH(new Money(50_000), 4),
    THIRD(new Money(1_500_000), 5),
    SECOND(new Money(30_000_000), 5),
    FIRST(new Money(2_000_000_000), 6);

    public static final Rank[] values = values();
    private final Money reward;
    private final int matchCount;

    Rank(Money reward, int matchCount) {
        this.reward = reward;
        this.matchCount = matchCount;
    }

    public static Rank findRank(int correctCount, boolean matchBonus) {
        if (isSecond(correctCount, matchBonus)) {
            return Rank.SECOND;
        }
        return Arrays.stream(values)
                .filter(rank -> rank.matchCount == correctCount)
                .findFirst()
                .orElse(Rank.NONE);
    }

    private static boolean isSecond(int correctCount, boolean matchBonus) {
        return correctCount == SECOND.matchCount && matchBonus;
    }

    public int getReward() {
        return reward.getMoney();
    }

    public int getCorrectCount() {
        return matchCount;
    }
}
