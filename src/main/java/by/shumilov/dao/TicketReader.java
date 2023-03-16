package by.shumilov.dao;

import by.shumilov.bean.TicketList;
import by.shumilov.service.TicketParser;

public class TicketReader {

    private final TextFileReader fileReader = new TextFileReader();

    public TicketList getTickets() {
        return TicketParser.getTickets(fileReader.read("src/main/resources/tickets.json"));
    }
}
