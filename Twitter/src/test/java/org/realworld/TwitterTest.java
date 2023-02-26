package org.realworld;

import org.junit.jupiter.api.Test;

public class TwitterTest {

    @Test
    void 로그인_요청이_주어지면_로그인이_되어야_한다() {
        // given
        Twitter twitter = new Twitter();

        // when
        SenderEndPoint senderEndPoint = twitter.login(1, new ReceiverEndPoint());

        // then
    }

    @Test
    void 유효하지_않은_로그인_요청이_주어지면_로그인이_안되어야_한다() {

    }
}
