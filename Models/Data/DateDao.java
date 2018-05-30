package org.esq.toddrom.CivicGeo.Models.Data;

import org.esq.toddrom.CivicGeo.Models.Forms.DateWrapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.GregorianCalendar;

@Repository
@Transactional
public interface DateDao extends CrudRepository<DateWrapper, Integer>{
}
