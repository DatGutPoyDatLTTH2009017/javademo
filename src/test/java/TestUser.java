import com.example.demo4.entity.User;
import org.junit.jupiter.api.Test;

public class TestUser {
    @Test
    public void TestCreateUser(){
        User user = new User();
        user.setFullName("lee thanh dat");
        user.setUsername("dat");
        user.setEmail("dat@gmail.com");
        user.setPasswordHash("123");
        user.setStatus(1);

        MySqlUserModel mySqlUserModel = new MySqlUserModel();
        boolean result = mySqlUserModel.save(user);
        System.out.println(result);
    }
}
