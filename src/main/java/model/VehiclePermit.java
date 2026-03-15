package model;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class VehiclePermit{
    private Integer vpID;
    private Integer permitID;
    private String licensePlate;
}
