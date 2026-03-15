package model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ParkingLot {
    private int lotID;
    private String lotName;
    private String location;
}
