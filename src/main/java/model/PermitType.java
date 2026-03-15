package model;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PermitType {
    private int permitType;
    private String typeName;
}