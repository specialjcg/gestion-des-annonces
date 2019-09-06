package com.postule.postuleapp.repository;

import com.postule.postuleapp.model.ListePostule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostuleRepository extends JpaRepository<ListePostule, Long> {

}