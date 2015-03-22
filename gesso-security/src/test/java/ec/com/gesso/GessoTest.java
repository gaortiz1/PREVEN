package ec.com.gesso;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ec.com.gesso.test.PersonTest;
import ec.com.gesso.test.UserTest;

@RunWith(Suite.class)
@SuiteClasses(value = { UserTest.class, PersonTest.class })
public class GessoTest {

}
