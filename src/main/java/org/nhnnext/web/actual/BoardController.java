package org.nhnnext.web.actual;

import org.nhnnext.domain.Board;
import org.nhnnext.service.actual.BoardService;
import org.nhnnext.web.RepositoryEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boards")
public class BoardController extends RepositoryEntityController<Board, Long> {

    @Autowired
    public BoardController(BoardService repository) {
        super(repository);
    }
}
