package uz.pdp.task1.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private String departmentName;

    private String company;

    private String companyDirector;

    private String street;

    private String homeNumber;


}