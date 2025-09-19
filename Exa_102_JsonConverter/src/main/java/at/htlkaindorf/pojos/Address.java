package at.htlkaindorf.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private Long addressId;
    private String city;
    private String postalCode;
    private String streetname;
    private String streetnumber;
    private Customer customer;



}
