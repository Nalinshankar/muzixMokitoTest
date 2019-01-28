//package com.stackroute.springboot.seeddate;
//
//import com.stackroute.springboot.domain.Track;
//import com.stackroute.springboot.exception.TrackAlreadyExistsException;
//import com.stackroute.springboot.service.TrackService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
////import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
////import org.springframework.context.event.ContextStoppedEvent;
////import org.springframework.stereotype.Component;
////import javax.naming.Context;
//
//@Component
//public class AppListener implements ApplicationListener<ContextRefreshedEvent>  {
//
//    private TrackService trackService;
//@Autowired
//    public AppListener(TrackService trackService) {
//        this.trackService = trackService;
//    }
//
//    @Override
//        public void onApplicationEvent(ContextRefreshedEvent event)  {
//        try {
//            trackService.saveTrack(new Track("nalin", "shankar"));
//
//        }
//        catch (Exception ta)
//        {
//            System.out.println(ta.getMessage());
//        }
//        }
//    }

