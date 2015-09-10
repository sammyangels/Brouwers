package be.vdab.web;

import be.vdab.exceptions.KanTemperatuurNietLezenException;
import be.vdab.services.WeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("weer")
class WeerController {
    private static final String VIEW = "weer/temperatuur";
    private final WeerService weerService;

    @Autowired
    WeerController(WeerService weerService) {
        this.weerService = weerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{plaats}/temperatuur")
    ModelAndView temperatuur(@PathVariable String plaats) {
        ModelAndView modelAndView = new ModelAndView(VIEW);
        try {
            modelAndView.addObject("temperatuur", weerService.getTemperatuur(plaats));
        } catch (KanTemperatuurNietLezenException ex) {
            modelAndView.addObject("fout", "kan temperatuur niet lezen");
        }
        return modelAndView;
    }
}
