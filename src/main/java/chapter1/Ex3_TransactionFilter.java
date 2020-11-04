package chapter1;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Ex3_TransactionFilter {

    public static void traditionalFilter(List<Transaction> transactions) {
        Map<Transaction.Currency, List<Transaction>> transactionsByCurrencies =
                new HashMap<>();

        // 외부 반복
        for (Transaction transaction : transactions) {
            if (transaction.getPrice() > 1000) {
                Transaction.Currency currency = transaction.getCurrency();
                List<Transaction> transactionsForCurrency =
                        transactionsByCurrencies.get(currency);

                if (transactionsForCurrency == null) {
                    transactionsForCurrency = new ArrayList<>();
                    transactionsByCurrencies.put(currency, transactionsForCurrency);
                }
                transactionsForCurrency.add(transaction);
            }
        }
    }

    public static void modernFilter(List<Transaction> transactions) {
        // 내부 반복
        Map<Transaction.Currency, List<Transaction>> transactionsByCurrencies =
                transactions.stream()
                        .filter((Transaction t) -> t.getPrice() > 1000)
                        .collect(groupingBy(Transaction::getCurrency));

    }

    static class Transaction {
        int price;
        Currency currency;

        public int getPrice() {
            return price;
        }

        public Currency getCurrency() {
            return currency;
        }

        static class Currency {

        }
    }
}
