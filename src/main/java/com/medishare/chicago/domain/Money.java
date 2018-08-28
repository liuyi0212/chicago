package com.medishare.chicago.domain;

import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.io.Serializable;
import java.util.Locale;

/**
 * @author: liuy
 * @date: 2018/8/2
 * @time: 上午9:45
 * @descripttion: com.medishare.chicago.domain
 */
public class Money implements Serializable, Comparable<Money> {

    private static final long serialVersionUID = 1L;

    final static protected String DEFAULT_CURRENCY = "CNY";
    final static protected MonetaryAmountFormat fmt = MonetaryFormats.getAmountFormat(Locale.CHINA);;

    protected org.javamoney.moneta.Money m;
    protected String memo;
    protected String amountStr;

    public Money(double amt) {
        m = org.javamoney.moneta.Money.of(amt, DEFAULT_CURRENCY);
    }

    public double getAmount() {
        return m.getNumber().doubleValueExact();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String toString() {
        return fmt.format(m);
    }

    @Override
    public int compareTo(Money o) {
        return this.m.compareTo(o.m);
    }

    public Money substract(Money o) {
        org.javamoney.moneta.Money m1 = org.javamoney.moneta.Money.of(this.getAmount(), DEFAULT_CURRENCY);
        org.javamoney.moneta.Money m2 = org.javamoney.moneta.Money.of(o.getAmount(), DEFAULT_CURRENCY);
        org.javamoney.moneta.Money m3 = m1.subtract(m2);
        return new Money(m3.getNumber().doubleValue());
    }

    public Money add(Money o) {
        org.javamoney.moneta.Money m1 = org.javamoney.moneta.Money.of(this.getAmount(), DEFAULT_CURRENCY);
        org.javamoney.moneta.Money m2 = org.javamoney.moneta.Money.of(o.getAmount(), DEFAULT_CURRENCY);
        org.javamoney.moneta.Money m3 = m1.add(m2);
        return new Money(m3.getNumber().doubleValue());
    }
}
