package ec.com.gesso.test;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.UserProfile;
import ec.com.gesso.security.factory.GessoSecurityFactory;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by Roberto on 04/05/2015.
 */
public class BuildMenuTest {
    @Test
    public void buildMenu(){
        Collection<UserProfile> lstResult = null;
        try {
            lstResult = GessoSecurityFactory.getInstance().getSecurityService().findMenuForUser(1);


            for(UserProfile objResult: lstResult){
                System.out.println(objResult);
            }
        } catch (GessoException e) {
            e.printStackTrace();
        }
    }
}
