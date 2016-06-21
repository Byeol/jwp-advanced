package org.nhnnext.web;

import lombok.RequiredArgsConstructor;
import org.nhnnext.domain.Board;
import org.nhnnext.domain.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class BoardController {

    private static final String BASE_MAPPING = "/boards";

    private final BoardRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/boards";
    }

    @RequestMapping(value = BASE_MAPPING, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("boards", repository.findAll());
        return "boards";
    }

    @RequestMapping(value = BASE_MAPPING + "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("board", repository.findOne(id));
        return "board";
    }
}
