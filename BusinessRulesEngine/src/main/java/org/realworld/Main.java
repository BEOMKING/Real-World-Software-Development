package org.realworld;

public class Main {
    public static void main(String[] args) {
        final var env = new Facts();
        final var businessRuleEngine = new BusinessRuleEngine(env);

        businessRuleEngine.addAction(facts -> {
            var forecastedAmount = 0.0;
            var dealStage = Stage.valueOf(facts.getFacts("stage"));
            var amount = Double.parseDouble(facts.getFacts("amount"));

            switch (dealStage) {
                case LEAD:
                    forecastedAmount = amount * 0.2;
                    break;
                case EVALUATING:
                    forecastedAmount = amount * 0.5;
                    break;
                case INTERESTED:
                    forecastedAmount = amount * 0.8;
                    break;
                case CLOSED:
                    forecastedAmount = amount;
                    break;
            }

            facts.addFacts("forecastedAmount", String.valueOf(forecastedAmount));
        });

        businessRuleEngine.run();
    }
}
