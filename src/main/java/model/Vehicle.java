package model;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Vehicle {
    private String licensePlate;
    private String make;
    private String model;
    private int year;
    private Integer studentId;
    private Integer employeeID;
}