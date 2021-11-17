package uz.pdp.task1.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.task1.entity.Address;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private String compName;
    private String directorName;
    private Address address;
}
