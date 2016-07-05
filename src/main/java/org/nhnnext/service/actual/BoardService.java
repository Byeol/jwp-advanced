package org.nhnnext.service.actual;

import org.nhnnext.domain.Board;
import org.nhnnext.domain.BoardRepository;
import org.nhnnext.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService extends BaseService<Board, Long> {

    @Autowired
    public BoardService(BoardRepository repository) {
        super(repository);
    }
}
