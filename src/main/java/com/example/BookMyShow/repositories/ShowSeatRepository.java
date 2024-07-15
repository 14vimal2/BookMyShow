package com.example.BookMyShow.repositories;

import com.example.BookMyShow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    @Override
    List<ShowSeat> findAllById(Iterable<Integer> integers);

    @Override
    <S extends ShowSeat> S save(S entity);
}
