package com.solirius.journal;

import com.solirius.journal.domain.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Integer> {

}
