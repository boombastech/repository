package some.thirdparty.usinglibrary;

import org.assertj.core.api.AbstractAssert;
import some.thirdparty.usinglibrary.domain.User;

public class UserAssert extends AbstractAssert<UserAssert, User> {

    protected UserAssert (User actual) {
        super(actual, UserAssert.class);
    }

    public UserAssert hasId(String expectedId) {
        isNotNull();

        if (!actual.getId().equals(expectedId)) {
            failWithMessage("Expected to be %s, but was %s", expectedId, actual.getId());
        }

        return this;
    }

    public UserAssert hasUsername(String expectedUsername) {
        isNotNull();

        if (!actual.getUsername().equals(expectedUsername)) {
            failWithMessage("Expected username to be %s, but was %s", expectedUsername, actual.getUsername());
        }

        return this;
    }
}