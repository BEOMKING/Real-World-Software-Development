package org.realworld;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BusinessRuleEngineTest {
    @Test
    void addAction_메서드는_액션이_주어지면_액션을_추가한다() {
        // given
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        // when
        businessRuleEngine.addAction(() -> {});
        businessRuleEngine.addAction(() -> {});

        // then
        assertThat(2).isEqualTo(businessRuleEngine.count());
    }

    @Test
    void count_메서드는_액션의_개수를_리턴한다() {
        // given
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        // when
        final int result = businessRuleEngine.count();

        // then
        assertThat(0).isEqualTo(result);
    }

    @Test
    void run_메서드는_엔진을_실행시킨다() {
        // given
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
        final Action mockAction = mock(Action.class);

        // when
        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        // then
        verify(mockAction).execute();
    }
}
