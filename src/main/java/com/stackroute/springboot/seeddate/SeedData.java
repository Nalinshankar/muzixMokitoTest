package com.stackroute.springboot.seeddate;

import com.stackroute.springboot.domain.Track;
//import com.stackroute.springboot.repository.TrackRepo;
import com.stackroute.springboot.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
//
@Component
//@Configuration

public class SeedData implements CommandLineRunner

    {

        private TrackService trackService;

    @Autowired

    public SeedData(TrackService trackService) {

            this.trackService = trackService;
        }

        @Override

        public void run(String... args) throws Exception {
            Track t1 = Track.builder().tName("track").tComment("nocomments").build();
            trackService.saveTrack(t1);
            Track t2 = Track.builder().tName("track1").tComment("good").build();
            trackService.saveTrack(t2);
            Track t3 = Track.builder().tName("track2").tComment("verygood").build();
            trackService.saveTrack(t3);
            Track t4 = Track.builder().tName("track3").tComment("bad").build();
            trackService.saveTrack(t4);



        }



    }


