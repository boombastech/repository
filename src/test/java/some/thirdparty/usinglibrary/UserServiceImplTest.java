package some.thirdparty.usinglibrary;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import some.thirdparty.usinglibrary.domain.User;
import uk.co.boombastech.repository.Repository;
import uk.co.boombastech.repository.search.SearchCriteria;
import uk.co.boombastech.repository.search.SearchResult;
import uk.co.boombastech.repository.search.comparisons.InvalidComparisonTypeException;

import static some.thirdparty.usinglibrary.AssertCollection.assertThat;

public class UserServiceImplTest {

    private UserService userService;

    private Repository<User> userRepository;

    @Before
    public void setup () throws Exception {
        userRepository = new Repository<User>() {
            @Override
            public User create (User item) {
                return null;
            }

            @Override
            public User update (User item) {
                return null;
            }

            @Override
            public void delete (User item) {

            }

            @Override
            public SearchResult<User> retrieve (SearchCriteria<User> searchCriteria) throws InvalidComparisonTypeException {
                return new SearchResult<>(Lists.newArrayList(new User("userId")));
            }
        };
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void shouldName () throws Exception {
        User user = userService.findUserById("userId");
        assertThat(user).hasId("userId").hasUsername("cheese");

    }
}