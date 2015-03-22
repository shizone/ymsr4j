package ymsr4j;

import org.junit.Test;
import ymsr4j.ymsr4j.model.Incenses;
import ymsr4j.ymsr4j.model.User;
import ymsr4j.ymsr4j.model.Users;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class YmsrTest {

    @Test
    public void testIncensesGet() throws Exception {
        Incenses actual = Ymsr.incenses(1);
        assertThat(actual.getIncenses().size(), is(greaterThan(0)));
        System.out.println(actual);
    }

    @Test
    public void testIncensesPost() throws Exception {
        Properties p = new Properties();
        p.load(getClass().getResourceAsStream("/token.properties"));
        int actual = Ymsr.incenses(p.getProperty("token"));
        assertThat(actual, isOneOf(201, 409));
    }

    @Test
    public void testUsers() throws Exception {
        Users actual = Ymsr.users("shizone");
        assertThat(actual.getUser().getNickname(), is("shizone"));
        assertThat(actual.getUser().getName(), is("razon"));
        System.out.println(actual);
    }

    @Test
    public void testUsersIncenses() throws Exception {
        Incenses actual = Ymsr.usersIncenses("shizone");
        assertThat(actual.getIncenses().size(), is(greaterThan(0)));
        assertThat(actual.getIncenses().get(0).getUser().getNickname(), is("shizone"));
        assertThat(actual.getIncenses().get(0).getUser().getName(), is("razon"));
        System.out.println(actual);
    }
}