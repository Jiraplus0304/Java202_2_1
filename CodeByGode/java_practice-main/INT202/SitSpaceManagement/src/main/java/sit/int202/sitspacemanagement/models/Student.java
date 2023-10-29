package sit.int202.sitspacemanagement.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private int id ;
    private String name;
    private double score ;
    private String grade;

}
