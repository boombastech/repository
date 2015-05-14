package some.thirdparty.usinglibrary;

import some.thirdparty.usinglibrary.domain.User;
import uk.co.boombastech.repository.Repository;
import uk.co.boombastech.repository.search.SearchCriteria;
import uk.co.boombastech.repository.search.SearchResult;
import uk.co.boombastech.repository.search.comparisons.ComparisonType;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {

    private final Repository<User> userRepository;

    @Inject
    public UserServiceImpl (Repository<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById (String userId) {
        UserSearchCriteria userSearchCriteria = new UserSearchCriteria();

        userSearchCriteria.withId(userId);

        SearchResult<User> userSearchResult = userRepository.retrieve(userSearchCriteria);

        if (userSearchResult.isUniqueResult()) {
            return userSearchResult.getFirst();
        }

        throw new RuntimeException("userId is not valid: " + userId);
    }

    @Override
    public User registerNewUser (String email, String password) {
        UserSearchCriteria criteria = new UserSearchCriteria().withEmail(email);
        if (userRepository.retrieve(criteria).isUniqueResult()) {
            throw new RuntimeException("User with email already exists: " + email);
        }

        User user = new User("userId");
        return userRepository.create(user);
    }

    public static class UserSearchCriteria extends SearchCriteria<User> {
        @Override
        public Class<User> getItemClass () {
            return User.class;
        }

        public UserSearchCriteria withId(String userId) {
            this.withComparison("id", ComparisonType.equalTo, userId);
            return this;
        }

        public UserSearchCriteria withEmail (String email) {
            this.withComparison("email", ComparisonType.equalTo, email);
            return this;
        }
    }
}