package model;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {
    private int studentID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}

