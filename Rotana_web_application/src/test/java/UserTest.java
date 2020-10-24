import edu.miu.cs.dao.user.IUserDao;
import edu.miu.cs.dao.user.UserDao;
import edu.miu.cs.domain.User;


public class UserTest {
//
    public static void main(String[] args) {
        User user = new User();
        user.setFirstName("Bisrat");
        user.setLastName("KIdane");
        user.setGender("Female");
        user.setEmail("bsur91@gmail.com");
        user.setAccess("user");
        user.setPassword("12345");
        IUserDao userDao = new UserDao();
        userDao.create(user);
    }

}
