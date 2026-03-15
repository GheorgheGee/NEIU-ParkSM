package model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
