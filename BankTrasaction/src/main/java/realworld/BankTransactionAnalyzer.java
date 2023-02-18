package realworld;

import java.io.IOException;

public class BankTransactionAnalyzer {

    public static void main(String[] args) throws IOException {
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        bankStatementAnalyzer.analyze("file", new BankStatementCSVParser());
    }ƒ
}
