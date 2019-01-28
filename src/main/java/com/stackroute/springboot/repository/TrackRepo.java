package com.stackroute.springboot.repository;

import com.stackroute.springboot.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface TrackRepo extends JpaRepository<Track,Integer> {

    public Track findBytName(String name);

}
