package org.nhnnext.web.actual;

import org.nhnnext.domain.Board;
import org.nhnnext.domain.Card;
import org.nhnnext.domain.List;
import org.nhnnext.service.actual.BoardService;
import org.nhnnext.service.actual.CardService;
import org.nhnnext.service.actual.ListService;
import org.nhnnext.web.RepositoryEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
public class BoardController extends RepositoryEntityController<Board, Long> {

    @Autowired
    public BoardController(BoardService repository) {
        super(repository);
    }

    @Autowired
    private BoardService repository;

    @Autowired
    private ListService listService;

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/{id}/lists", method = RequestMethod.POST)
    public void createList(@PathVariable Long id, @RequestBody List list) {
        Board board = repository.findOne(id);
        list.setBoard(board);
        listService.save(list);
    }

    @RequestMapping(value = "/{id}/lists/{listId}/cards", method = RequestMethod.POST)
    public void createCard(@PathVariable Long id, @PathVariable Long listId, @RequestBody Card card) {
        List list = listService.findOne(listId);
        card.setList(list);
        cardService.save(card);
    }
}
