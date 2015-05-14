package some.thirdparty.usinglibrary;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import some.thirdparty.usinglibrary.domain.User;

public class HasUserId extends TypeSafeMatcher<User> {

    private final String expectedUserId;

    public HasUserId (String expectedUserId) {
        this.expectedUserId = expectedUserId;
    }

    @Override
    protected boolean matchesSafely (User user) {
        return user.getId().equals(expectedUserId);
    }

    @Override
    public void describeTo (Description description) {
        description.appendText("user with id: ").appendValue(expectedUserId);
    }

    @Override
    protected void describeMismatchSafely (User item, Description mismatchDescription) {
        mismatchDescription.appendText("got user with id: ").appendValue(item.getId());
    }

    public static HasUserId hasUserId(String expectedUserId) {
        return new HasUserId(expectedUserId);
    }
}