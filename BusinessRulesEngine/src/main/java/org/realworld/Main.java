package org.realworld;

public class Main {
    public static void main(String[] args) {
        final Facts env = new Facts();
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(env);

        businessRuleEngine.addAction(facts -> {
            final String jobTitle = facts.getFacts("jobTitle");

            if ("CEO".equals(jobTitle)) {
                final String name = facts.getFacts("name");
                Mailer.sendEmail("email", "customer" + name);
            }
        });

        businessRuleEngine.run();
    }
}
