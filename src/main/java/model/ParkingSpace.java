package model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ParkingSpace {
    private int spaceNumber;
    private int lotID;
}
