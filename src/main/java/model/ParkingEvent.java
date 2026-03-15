package model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ParkingEvent {
    private int eventID;
    private String vpID;
    private int lotID;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
}
