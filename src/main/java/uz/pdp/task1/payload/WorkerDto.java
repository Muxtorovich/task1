package uz.pdp.task1.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDto {
    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String street;

    @NotNull
    private String homeNumber;

    @NotNull
    private String departmentName;
}
