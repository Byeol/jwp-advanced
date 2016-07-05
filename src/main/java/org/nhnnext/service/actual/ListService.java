package org.nhnnext.service.actual;

import org.nhnnext.domain.List;
import org.nhnnext.domain.ListRepository;
import org.nhnnext.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService extends BaseService<List, Long> {

    @Autowired
    public ListService(ListRepository repository) {
        super(repository);
    }
}
