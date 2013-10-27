import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.User;
import org.junit.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jeygokul
 * Date: 10/27/13
 * Time: 8:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class BirthdayReminderTest {

    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code
        System.out.println("@BeforeClass - oneTimeSetUp");
    }

    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
        System.out.println("@AfterClass - oneTimeTearDown");
    }

    @Before
    public void setUp() {
        System.out.println("@Before - setUp");
    }

    @After
    public void tearDown() {
        System.out.println("@After - tearDown");
    }

    @Test
    public void testFacebookLogin() {
        FacebookClient facebookClient = null;
        User user = null;
        try{
            facebookClient = new DefaultFacebookClient("CAACEdEose0cBAD0akG22vaYXXbC3pbGBTN9ZCaOSPuwNhyEeggPvp9j1nIUTpKdI8lQBOxdQrT6e029g9mCkYO5M5XeZA0yPdCUcNZBhQw44mHD7dvtJzeV5XngAULUqbu6ZC8zhhiJJq0Ixc2fGDeyTNe1ZBW3WQ7plZAcnoUVZBv0tsJXvtqf9ny3nHEBzxGiXX0lInv3TgZDZD");
            User me = facebookClient.fetchObject("me",User.class);

            Connection<NamedFacebookType> friendsData =
                    facebookClient.fetchConnection("me/friends",
                            NamedFacebookType.class);
            List<NamedFacebookType> friendsList = friendsData.getData();
            Iterator<NamedFacebookType> itr = friendsList.iterator();
            while(itr.hasNext()){
                NamedFacebookType namedFacebookType = itr.next();
                User friend = facebookClient.fetchObject(namedFacebookType.getId(),User.class);
                System.out.println("Name : "+friend.getName()+" Birthday : "+friend.getBirthday());
            }
        }finally{

        }
    }
}
