package com.example.BookMyShow.repositories;

import com.example.BookMyShow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Override
    <S extends Booking> S save(S entity);
}
