package com.kafkademo.repository;
import com.kafkademo.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RideRepository extends JpaRepository<Ride, Long>{

}
