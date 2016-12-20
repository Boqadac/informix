package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CallrecordRepository extends JpaRepository<Callrecord, Long> {

	
	@Query("from Callrecord where  callstart > ?1 and (origdestination=?2 or (origdestination >= ?3 and origdestination <= ?4)) order by callstart")
	List<Callrecord> getCalls(String date, long oDestination, long origdestB, long origdestS);

}
