package chapter5;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import chapter5.model.Trader;
import chapter5.model.Transaction;

public class Ex18_TraderAndTransaction {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        // 2011 년도 트랜젝션을 오름차순 정렬
        List<Transaction> tr2011 = transactions.stream()
            .filter(transaction -> transaction.getYear() == 2011)
            .sorted(comparing(Transaction::getValue))
            .collect(toList());
        System.out.println(tr2011.toString());

        // 거래자가 근무하는 모든 도시 나열
        List<String> cities1 = transactions.stream()
            .map(transaction -> transaction.getTrader().getCity())
            .distinct()
            .collect(toList());
        System.out.println(cities1.toString());

        Set<String> cities2 = transactions.stream()
            .map(transaction -> transaction.getTrader().getCity())
            .collect(toSet());
        System.out.println(cities2.toString());

        // 케임브리지에서 근무하는 모든 거래자를 오름차순 정렬
        List<Trader> traders = transactions.stream()
            .map(Transaction::getTrader)
            .filter(trader -> trader.getCity().equals("Cambridge"))
            .distinct()
            .sorted(comparing(Trader::getName))
            .collect(toList());
        System.out.println(traders.toString());

        // 모든 거래자 이름을 오름차순 정렬 후 연결
        String traderStr1 = transactions.stream()
            .map(transaction -> transaction.getTrader().getName())
            .distinct()
            .sorted()
            .reduce("", (n1, n2) -> n1 + n2); // 새로운 문자열 객체를 만들어 비효율적
        System.out.println(traderStr1);

        String traderStr2 = transactions.stream()
            .map(transaction -> transaction.getTrader().getName())
            .distinct()
            .sorted()
            .collect(joining()); // 내부적으로 StringBuilder를 사용하여 효율적으로 문자열 연결
        System.out.println(traderStr2);

        // 밀라노에 거래자가 있는지 확인
        boolean milanBased = transactions.stream()
            .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        // 케임브리즈의 모든 거래자 트랜젝션 출력
        transactions.stream()
            .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
            .map(Transaction::getValue)
            .forEach(System.out::println);

        // 트랜젝션 최대 값
        Optional<Integer> highestValue = transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::max);
        System.out.println(highestValue.orElse(0));

        // 트랜젝션 최소 값
        Optional<Transaction> smallestTransaction1 = transactions.stream()
            .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(smallestTransaction1.orElse(null));

        Optional<Transaction> smallestTransaction2 = transactions.stream()
            .min(comparing(Transaction::getValue)); // 스트림에서 Comparator를 인수로 하는 min, max 메서드 제공
        System.out.println(smallestTransaction2.orElse(null));
    }
}
