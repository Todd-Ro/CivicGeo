package org.esq.toddrom.CivicGeo.Models.Data;

import org.esq.toddrom.CivicGeo.Models.Forms.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CandidateDao extends CrudRepository<Candidate, Integer> {



}
