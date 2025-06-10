package com.nhnacademy.exam.hotel.repository;

import com.nhnacademy.exam.hotel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
