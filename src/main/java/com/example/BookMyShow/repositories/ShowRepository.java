package com.example.BookMyShow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BookMyShow.models.Show;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    @Override
    Optional<Show> findById(Integer integer);
}
