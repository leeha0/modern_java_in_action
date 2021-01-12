package chapter6;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chapter5.model.Transaction;

public class Ex1_GroupByTransaction {

    public static void main(String[] args) {
        // 명령형 버전
        List<Transaction> transactions = new ArrayList<>();
        Map<Currency, List<Transaction>> transactionsByCurrencies =
            new HashMap<>();

        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);

            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }

        // 함수형 버전: 무엇을 원하는지 직접 명시
        Map<Currency, List<Transaction>> transactionsByCurrencies2 =
            transactions.stream().collect(groupingBy(Transaction::getCurrency));
    }
}
