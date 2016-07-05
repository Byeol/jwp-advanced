package org.nhnnext.web.actual;

import org.nhnnext.domain.Card;
import org.nhnnext.service.actual.CardService;
import org.nhnnext.web.RepositoryEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardController extends RepositoryEntityController<Card, Long> {

    @Autowired
    public CardController(CardService repository) {
        super(repository);
    }
}
