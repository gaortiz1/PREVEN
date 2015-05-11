package ec.com.gesso.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Roberto on 02/05/2015.
 */

@Controller
@RequestMapping("/")
public class PortalController {

    @RequestMapping
    public String getIndexPage() {
        return "login";
    }
}
