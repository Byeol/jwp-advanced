package org.nhnnext.service.actual;

import org.nhnnext.domain.Card;
import org.nhnnext.domain.CardRepository;
import org.nhnnext.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cardService")
public class CardService extends BaseService<Card, Long> {

    @Autowired
    public CardService(CardRepository repository) {
        super(repository);
    }
}
