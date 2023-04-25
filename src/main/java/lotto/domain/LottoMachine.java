package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.winning.WinningBall;
import lotto.domain.winning.WinningStat;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public int calculateUnitCount(Amount amount) {
        return amount.calculateUnitCount(LOTTO_PRICE);
    }

    /**
     * 돈을 받으면 로또를 만들어주는 책임은 로또 기계에 있다 판단하여 해당로직 작성
     */
    public Lottos makeLottos(Amount amount, LottoStrategy lottoStrategy) {
        return new Lottos(this.calculateUnitCount(amount), lottoStrategy);
    }

    public WinningBall winningBall(String winningNumbers, int bonusBallNumber) {
        return new WinningBall(this.winningLotto(winningNumbers), this.bonusBall(bonusBallNumber));
    }

    private Lotto winningLotto(String winningNumbers) {
        return Lotto.winningLotto(winningNumbers);
    }

    private LottoNumber bonusBall(int bonusBallNumber) {
        return new LottoNumber(bonusBallNumber);
    }

    public WinningStat winningStat(Lottos lottos, WinningBall winningBall) {
        return lottos.rating(winningBall);
    }
}
