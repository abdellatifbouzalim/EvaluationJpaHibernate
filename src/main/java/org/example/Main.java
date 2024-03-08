package org.example;

import org.example.dao.AvionDAO;
import org.example.dao.PiloteDAO;
import org.example.dao.VolDAO;
import org.example.entities.Avion;
import org.example.entities.Pilote;
import org.example.entities.Vol;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PiloteDAO piloteDAO = new PiloteDAO();
        AvionDAO avionDAO = new AvionDAO();
        VolDAO volDAO = new VolDAO();

        // Add a new pilot
        Pilote newPilot = new Pilote();
        newPilot.setNom("John Doe");
        newPilot.setAdresse("Agadir");
        piloteDAO.addPilote(newPilot);

        // Add a new airplane
        Avion newAvion = new Avion();
        newAvion.setNom("Boeing 747");
        newAvion.setCapacite(500);
        newAvion.setLocalite("casa");
        avionDAO.addAvion(newAvion);

        // Add a new flight
        Vol newFlight = new Vol();
        newFlight.setVD("Paris");
        newFlight.setVA("New York");
        newFlight.setHD(LocalDateTime.now()); // Set the departure time to the current time
        newFlight.setHA(LocalDateTime.now().plusHours(3)); // Set the arrival time to 3 hours after departure
        newFlight.setPilote(newPilot); // Assign the pilot to the flight
        newFlight.setAvion(newAvion); // Assign the airplane to the flight
        volDAO.addVol(newFlight);

        System.out.println("Added new pilot: " + newPilot.getNom());
        System.out.println("Added new airplane: " + newAvion.getNom());
        System.out.println("Added new flight: " + newFlight.getNV());

        // Retrieve flights by airplane ID
        List<Vol> flightsByAvion = volDAO.getFlightsByAvion(1);
        System.out.println("Flights by airplane ID: " + flightsByAvion);

        // Retrieve flights by departure city
        List<Vol> flightsByDepartureCity = volDAO.getFlightsByDepartureCity("Paris");
        System.out.println("Flights by departure city: " + flightsByDepartureCity);

        // Retrieve flights by arrival city and time range
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusHours(6);
        List<Vol> flightsByArrivalCityAndTimeRange = volDAO.getFlightsByArrivalCityAndTimeRange("New York", startTime, endTime);
        System.out.println("Flights by arrival city and time range: " + flightsByArrivalCityAndTimeRange);

        // Count flights by pilot ID
        int piloteId = 1;
        int flightCount = volDAO.countFlightsByPilote(piloteId);
        System.out.println("Flight count by pilot ID " + piloteId + ": " + flightCount);

        // Retrieve flights between dates
        Date startDate = new Date(); // current date
        Date endDate = new Date(System.currentTimeMillis() + 86400000); // next day
        List<Vol> flightsBetweenDates = volDAO.getFlightsBetweenDates(startDate, endDate);
        System.out.println("Flights between dates: " + flightsBetweenDates);
    }
}
