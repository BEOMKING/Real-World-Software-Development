package org.realworld;

public class Main {
    public static void main(String[] args) {
        final var env = new Facts();
        final var businessRuleEngine = new BusinessRuleEngine(env);

        businessRuleEngine.addAction(facts -> {
            var forecastedAmount = 0.0;
            var dealStage = Stage.valueOf(facts.getFacts("stage"));
            var amount = Double.parseDouble(facts.getFacts("amount"));

            if (Stage.LEAD.equals(dealStage)) {
                forecastedAmount = amount * 0.2;
            } else if (Stage.EVALUATING.equals(dealStage)) {
                forecastedAmount = amount * 0.5;
            } else if (Stage.INTERESTED.equals(dealStage)) {
                forecastedAmount = amount * 0.8;
            } else {
                forecastedAmount = amount;
            }

            facts.addFacts("forecastedAmount", String.valueOf(forecastedAmount));
        });

        businessRuleEngine.run();
    }
}
