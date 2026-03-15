package model.views;

import java.util.*;
import lombok.*;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class VehiclePermitInfo {
    private int vpID;
    private String licensePlate;
    private String permitType;
    private Date validFrom;
    private Date validTo;
}
