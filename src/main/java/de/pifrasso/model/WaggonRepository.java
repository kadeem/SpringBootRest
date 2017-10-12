package de.pifrasso.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by kadeem on 19.06.17.
 */
@RepositoryRestResource
public interface WaggonRepository extends JpaRepository<Waggon, Long> {


    public Waggon findByNumber(@Param("number")String number);
}
