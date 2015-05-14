package some.thirdparty.usinglibrary;

import some.thirdparty.usinglibrary.domain.User;

import java.util.List;

public interface UserService {
    User findUserById (String user);
    User registerNewUser(String email, String password);
}