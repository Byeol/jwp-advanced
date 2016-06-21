package org.nhnnext.web;

import lombok.RequiredArgsConstructor;
import org.nhnnext.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class TestController {

    private final BoardRepository boardRepository;
    private final ListRepository listRepository;
    private final CardRepository cardRepository;

    @RequestMapping("/test")
    public void test() {
        Board board = new Board();
        board.setName("Board 1");
        board.setDesc("This is a board.");
        boardRepository.save(board);

        List list = new List();
        list.setName("List 1");
        list.setBoard(board);
        listRepository.save(list);

        Card card = new Card();
        card.setName("Card 1");
        card.setDesc("This is a card.");
        card.setList(list);
        cardRepository.save(card);

        board = new Board();
        board.setName("Board 2");
        board.setDesc("This is a board.");
        boardRepository.save(board);

        board = new Board();
        board.setName("Board 3");
        board.setDesc("This is a board.");
        boardRepository.save(board);
    }
}
