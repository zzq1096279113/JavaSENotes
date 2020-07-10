package exer;

import java.lang.reflect.Method;

/**
 * @author zzq
 * @creat 2020-06-04 10:49
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Class<User> userClass = User.class;
        User user = userClass.getDeclaredConstructor().newInstance();
        Method show = userClass.getDeclaredMethod("show");
        show.setAccessible(true);
        show.invoke(user);
    }
}
