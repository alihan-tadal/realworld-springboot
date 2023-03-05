package com.example.realworldspringboot;

import com.example.realworldspringboot.domain.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    void except_user_has_protected_no_args_constructor() {
        class ChildUser extends User {
            public ChildUser() {
                super();
            }
        }
        final var childUser = new ChildUser();
        assertThat(childUser).isInstanceOf(User.class);
    }
}
