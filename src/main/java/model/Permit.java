package model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Permit {
    private int permitID;
    private String typeName;
    private LocalDate validFrom;
    private LocalDate validTo;
}