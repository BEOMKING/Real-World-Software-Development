package realworld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {

    public static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);

        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        System.out.println("Total Amount " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transactions in January " + bankStatementProcessor.selectInMonth(Month.JANUARY));
        System.out.println("Transactions in Category " + bankStatementProcessor.calculateTotalForCategory("Foodƒ"));
    }
}
