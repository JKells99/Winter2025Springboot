package com.keyin.clinic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClinicRepository extends JpaRepository<Clinic,Long> {
}
