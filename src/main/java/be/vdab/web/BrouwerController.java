package be.vdab.web;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
    private final BrouwerService brouwerService;
    private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
    private static final String BEGIN_NAAM_VIEW = "brouwers/beginnaam";
    private static final String BROUWERS_VIEW = "brouwers/brouwers";
    private static final String ALFABET_VIEW = "brouwers/opalfabet";
    private static final String REDIRECT_NA_TOEVOEGEN = "redirect:/";
    private final char[] alfabet = new char['Z' - 'A' + 1];

    @RequestMapping(value = "opalfabet", method = RequestMethod.GET)
    ModelAndView opAlfabetForm() {
        return new ModelAndView(ALFABET_VIEW, "alfabet", alfabet);
    }

    @RequestMapping(method = RequestMethod.GET, params = "letter")
    ModelAndView opAlfabet(@RequestParam char letter) {
        return new ModelAndView(ALFABET_VIEW).addObject("alfabet", alfabet)
                .addObject("brouwers", brouwerService.findByNaam(String.valueOf(letter)));
    }

    @RequestMapping(method = RequestMethod.GET, params = "beginnaam")
    ModelAndView beginNaam(@Valid BeginNaamForm form, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(BEGIN_NAAM_VIEW);
        if (!bindingResult.hasErrors()) {
            modelAndView.addObject("brouwers", brouwerService.findByNaam(form.getBeginnaam()));
        }
        return modelAndView;
    }

    @Autowired
    BrouwerController(BrouwerService brouwerService) {
        this.brouwerService = brouwerService;
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            alfabet[letter - 'A'] = letter;
        }
    }
    @RequestMapping(method = RequestMethod.GET)
    ModelAndView brouwers() {
        return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
    }

    @RequestMapping(value = "beginnaam", method = RequestMethod.GET)
    ModelAndView beginNaamForm() {
        return new ModelAndView(BEGIN_NAAM_VIEW).addObject(new BeginNaamForm());
    }

    @RequestMapping(value = "toevoegen", method = RequestMethod.GET)
    ModelAndView toevoegen() {
        return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Brouwer());
    }

    @RequestMapping(method = RequestMethod.POST)
    String toevoegen(@Valid Brouwer brouwer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return TOEVOEGEN_VIEW;
        }
        brouwerService.create(brouwer);
        return REDIRECT_NA_TOEVOEGEN;
    }

    @InitBinder("brouwer")
    void initBinderPostcodeReeks(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }
}