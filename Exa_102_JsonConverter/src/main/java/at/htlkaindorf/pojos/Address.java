package at.htlkaindorf.pojos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private Long addressId;
    private String city;
    @JsonAlias("postal_code")
    private String postalCode;
    private String streetname;
    private String streetnumber;

    @JsonBackReference
    private Customer customer;
    @JsonManagedReference
    private Country country;


}
