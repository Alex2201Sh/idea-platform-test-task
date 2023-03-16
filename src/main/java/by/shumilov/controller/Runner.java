package by.shumilov.controller;

import by.shumilov.bean.TicketList;
import by.shumilov.dao.FileWriter;
import by.shumilov.dao.TicketReader;
import by.shumilov.service.FlightTimeCalculator;

public class Runner {
    public static void main(String[] args) {
        TicketList tickets = new TicketReader().getTickets();
        FlightTimeCalculator calculator = new FlightTimeCalculator();

        String result = "Среднее время полета между городами Владивосток и Тель-Авив: " +
                calculator.getAverageFlightTimeInMinutes(tickets) +
                "\n" +
                "90-й процентиль времени полета между городами  Владивосток и Тель-Авив: " +
                calculator.getPercentile(90, tickets, "Владивосток", "Тель-Авив");
        System.out.println(result);
        FileWriter writer = new FileWriter();
        writer.writeDataToFile(result, "src/main/resources/result.txt");
    }
}
