package some.thirdparty.usinglibrary;

import some.thirdparty.usinglibrary.domain.User;

public class AssertCollection {

    public static UserAssert assertThat(User actual) {
        return new UserAssert(actual);
    }
}