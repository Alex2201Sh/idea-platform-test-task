package by.shumilov.service;

import by.shumilov.bean.Ticket;
import by.shumilov.bean.TicketList;

import java.time.Duration;
import java.util.List;

public class FlightTimeCalculator {

    public double getAverageFlightTimeInMinutes(TicketList ticketList) {
        return ticketList
                .getTickets()
                .stream()
                .mapToInt(this::calculateFlightTimeInMinutes)
                .average()
                .getAsDouble();
    }

    public int calculateFlightTimeInMinutes(Ticket ticket) {
        return (int) Duration.between(
                        ticket.getDeparture_date().atTime(ticket.getDeparture_time()),
                        ticket.getArrival_date().atTime(ticket.getArrival_time()))
                .toMinutes();
    }

    public double getPercentile(double percentile, TicketList ticketList, String origin_name, String destination_name) {
        List<Integer> filteredSortedTicketsTimesList = ticketList
                .getTickets()
                .stream()
                .filter(ticket -> origin_name.equals(ticket.getOrigin_name()) &&
                        destination_name.equals(ticket.getDestination_name()))
                .mapToInt(this::calculateFlightTimeInMinutes)
                .sorted()
                .boxed()
                .toList();

        double k = filteredSortedTicketsTimesList.size() * (percentile / 100);
        return filteredSortedTicketsTimesList.get((int) Math.ceil(k));

    }
}
