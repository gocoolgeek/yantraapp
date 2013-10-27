import com.restfb.Facebook;
import com.restfb.types.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jeygokul
 * Date: 10/27/13
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class FetchObjectsResults {
    @Facebook
    User me;

    // If the Facebook property name doesn't match
    // the Java field name, specify the Facebook field name in the annotation.

    @Facebook("friends")
    List<User> friends;
}