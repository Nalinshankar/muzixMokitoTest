package com.stackroute.springboot.service;

import com.stackroute.springboot.domain.Track;
import com.stackroute.springboot.exception.TrackAlreadyExistsException;
import com.stackroute.springboot.repository.TrackRepo;
import org.h2.engine.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class TrackServiceTest {

    private Track track;

    //Create a mock for UserRepository
    @Mock
    private TrackRepo trackRepo;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTId(10);
        track.setTName("John");
        track.setTComment("Jenny");
        list = new ArrayList<>();
        list.add(track);


    }

    @Test
    public void saveUserTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepo.save((Track)any())).thenReturn(track);
        Track savedUser = trackService.saveTrack(track);
        Assert.assertEquals(track,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepo,times(1)).save(track);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveUserTestFailure() throws TrackAlreadyExistsException {
        when(trackRepo.save((Track)any())).thenReturn(null);
        Track savedUser = trackService.saveTrack(track);
        System.out.println("savedUser" + savedUser);
        Assert.assertEquals(track,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllUser(){

        trackRepo.save(track);
        //stubbing the mock to return specific data
        when(trackRepo.findAll()).thenReturn(list);
        List<Track> userlist = trackService.getAllTracks();
        Assert.assertEquals(list,userlist);
    }



}