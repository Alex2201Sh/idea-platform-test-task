package by.shumilov.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Ticket {

    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate departure_date;
    @JsonFormat(pattern = "H:mm")
    private LocalTime departure_time;
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate arrival_date;
    @JsonFormat(pattern = "H:mm")
    private LocalTime arrival_time;
    private String carrier;
    private int stops;
    private int price;

}
