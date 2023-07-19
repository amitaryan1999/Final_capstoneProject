package com.tour;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.tour.controller.ScheduleTourController;
import com.tour.exceptions.TourDetailsAlreadyExists;
import com.tour.exceptions.TourDetailsNotFound;
import com.tour.model.ScheduleTour;
import com.tour.service.IScheduleTourService;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScheduleTourApplicationTests {

    @Mock
    private IScheduleTourService scheduleService;

    @InjectMocks
    private ScheduleTourController scheduleTourController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveScheduleTourHandler_ValidScheduleTour_ReturnsOkResponse() throws TourDetailsAlreadyExists {
        // Arrange
        ScheduleTour scheduleTour = new ScheduleTour();
        when(scheduleService.addTour(any(ScheduleTour.class))).thenReturn(scheduleTour);

        // Act
        ResponseEntity<?> response = scheduleTourController.saveScheduleTourHandler(scheduleTour);

        // Assert
        verify(scheduleService, times(1)).addTour(any(ScheduleTour.class));
        assertSame(HttpStatus.OK, response.getStatusCode());
        assertEquals("Tour booked successfully", response.getBody());
    }

    @Test
    void saveScheduleTourHandler_InvalidScheduleTour_ReturnsBadRequestResponse() throws TourDetailsAlreadyExists {
        // Arrange
        ScheduleTour scheduleTour = new ScheduleTour();
        when(scheduleService.addTour(any(ScheduleTour.class))).thenReturn(null);

        // Act
        ResponseEntity<?> response = scheduleTourController.saveScheduleTourHandler(scheduleTour);

        // Assert
        verify(scheduleService, times(1)).addTour(any(ScheduleTour.class));
        assertSame(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Date or slots are not available for booking", response.getBody());
    }

    @Test
    void updateTourHandler_ValidScheduleTour_ReturnsCreatedResponse() throws TourDetailsNotFound {
        // Arrange
        ScheduleTour scheduleTour = new ScheduleTour();
        int scheduleId = 1;
        when(scheduleService.updateTour(any(ScheduleTour.class), eq(scheduleId))).thenReturn(scheduleTour);

        // Act
        ResponseEntity<?> response = scheduleTourController.updateTourHandler(scheduleTour, scheduleId);

        // Assert
        verify(scheduleService, times(1)).updateTour(any(ScheduleTour.class), eq(scheduleId));
        assertSame(HttpStatus.CREATED, response.getStatusCode());
        assertSame(scheduleTour, response.getBody());
    }

    @Test
    void getAllTourHandler_ReturnsOkResponseWithScheduleTourList() {
        // Arrange
        List<ScheduleTour> scheduleTours = new ArrayList<>();
        when(scheduleService.getAllTours()).thenReturn(scheduleTours);

        // Act
        ResponseEntity<?> response = scheduleTourController.getAllTourHandler();

        // Assert
        verify(scheduleService, times(1)).getAllTours();
        assertSame(HttpStatus.OK, response.getStatusCode());
        assertSame(scheduleTours, response.getBody());
    }

    @Test
    void getTourByIdHandler_ValidScheduleId_ReturnsOkResponseWithScheduleTour() throws TourDetailsNotFound {
        // Arrange
        ScheduleTour scheduleTour = new ScheduleTour();
        int scheduleId = 1;
        when(scheduleService.getTourById(eq(scheduleId))).thenReturn(scheduleTour);

        // Act
        ResponseEntity<?> response = scheduleTourController.getTourByIdHandler(scheduleId);

        // Assert
        verify(scheduleService, times(1)).getTourById(eq(scheduleId));
        assertSame(HttpStatus.OK, response.getStatusCode());
        assertSame(scheduleTour, response.getBody());
    }

    @Test
    void DeleteNoteByIdHandler_ValidScheduleId_ReturnsOkResponse() throws TourDetailsNotFound {
        // Arrange
        int scheduleId = 1;
        when(scheduleService.delTour(eq(scheduleId))).thenReturn(true);

        // Act
        ResponseEntity<?> response = scheduleTourController.DeleteNoteByIdHandler(scheduleId);

        // Assert
        verify(scheduleService, times(1)).delTour(eq(scheduleId));
        assertSame(HttpStatus.OK, response.getStatusCode());
        assertEquals("ScheduleTour Details Deleted ....", response.getBody());
    }
}


