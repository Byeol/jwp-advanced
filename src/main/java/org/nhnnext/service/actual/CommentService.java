package org.nhnnext.service.actual;

import org.nhnnext.domain.Comment;
import org.nhnnext.domain.CommentRepository;
import org.nhnnext.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends BaseService<Comment, Long> {

    @Autowired
    public CommentService(CommentRepository repository) {
        super(repository);
    }
}
