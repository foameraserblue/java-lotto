package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.checkLottoNumber(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private void checkLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45 이하의 숫자만 가능합니다.");
        }
    }

    int getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        if (o.lottoNumber > lottoNumber) {
            return 1;
        } else if (o.lottoNumber < lottoNumber) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }
}
