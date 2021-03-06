package org.nhnnext.web.actual;

import org.nhnnext.domain.Comment;
import org.nhnnext.service.actual.CommentService;
import org.nhnnext.web.RepositoryEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController extends RepositoryEntityController<Comment, Long> {

    @Autowired
    public CommentController(CommentService repository) {
        super(repository);
    }
}
