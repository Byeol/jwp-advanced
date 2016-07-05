package org.nhnnext.web.actual;

import org.nhnnext.domain.List;
import org.nhnnext.domain.ListRepository;
import org.nhnnext.web.RepositoryEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lists")
public class ListController extends RepositoryEntityController<List, Long> {

    @Autowired
    public ListController(ListRepository repository) {
        super(repository);
    }
}
