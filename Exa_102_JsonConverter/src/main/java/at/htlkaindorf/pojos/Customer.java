package at.htlkaindorf.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private Long customerId;
    private String firstname;
    private String lastname;
    private String email;
    private Gender gender;
    private LocalDate since;
    private Boolean active;
    private Address address;


    
}
