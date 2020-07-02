package com.hgx.spring.security.oauth2.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hgx
 * @date 2020/7/2 19:55
 * @Description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OAuth2ServerApplicationTests {

    @Test
    public void testPasswordEncoder() {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }


}
