package realworld;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(BankTransactionSummarizer summarizer) {
        double result = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {
            result = summarizer.summarize(result, bankTransaction);
        }

        return result;
    }

    public double calculateInMonth(final Month month) {
        return summarizeTransactions((acc, bankTransactions) ->
            bankTransactions.getDate().getMonth() == month ? acc + bankTransactions.getAmount() : acc
        );
    }

    public double calculateTotalAmount() {
        return summarizeTransactions((acc, bankTransactions) ->
                acc + bankTransactions.getAmount());
    }

    public double calculateTotalForCategory(final String category) {
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDescription().equals(category) ? acc + bankTransaction.getAmount() : acc);
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter filter) {
        List<BankTransaction> result = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (filter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }

        return result;
    }

    public List<BankTransaction>findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }
}
