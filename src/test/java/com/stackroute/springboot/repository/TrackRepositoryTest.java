package com.stackroute.springboot.repository;

import com.stackroute.springboot.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {


    @Autowired
    private TrackRepo trackRepo;
    private Track track;

    @Before
    public void setUp() {
        track = new Track();
        track.setTId(10);
        track.setTName("John");
        track.setTComment("Jenny");

    }

    @After
    public void tearDown() {

        trackRepo.deleteAll();
    }


    @Test
    public void testSaveUser() {
        trackRepo.save(track);
        Track fetchUser = trackRepo.findById(track.getTId()).get();
        Assert.assertEquals(10, fetchUser.getTId());

    }

    @Test
    public void testSaveUserFailure() {
        Track testUser = new Track(10, "John", "Jenny");
        trackRepo.save(track);
       // Track fetchUser = trackRepo.findById(track.getTId()).get();
        Assert.assertNotSame(testUser, track);
    }

    @Test
    public void testGetAllUser() {
        Track u = new Track( 10, "John", "Jenny");
        Track u1 = new Track( 11, "Harry12", "porter");
        trackRepo.save(u);
        trackRepo.save(u1);

        List<Track> list = trackRepo.findAll();
        Assert.assertEquals("John", list.get(0).getTName());


    }

}
