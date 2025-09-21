package at.htlkaindorf.pojos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

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
    @JsonFormat(pattern = "dd-MMM-yyyy")
    private LocalDate since;
    private Boolean active;

   @JsonManagedReference
   @ToString.Exclude
    private Address address;

}
