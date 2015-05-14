package some.thirdparty.usinglibrary;

import org.assertj.core.api.AbstractAssert;

public class DifferentUserAssert extends AbstractAssert<DifferentUserAssert, UserService> {

    protected DifferentUserAssert (UserService actual) {
        super(actual, UserAssert.class);
    }

    public DifferentUserAssert hasId (String expectedId) {
        isNotNull();


        return this;
    }

    public DifferentUserAssert hasUsername (String expectedUsername) {
        isNotNull();

        return this;
    }
}