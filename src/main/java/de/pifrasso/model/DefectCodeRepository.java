package de.pifrasso.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectCodeRepository extends JpaRepository<DefectCode, Long> {
}
