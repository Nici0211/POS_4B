package at.htlkaindorf.pojos;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {

    private Long countryId;
    @JsonAlias("country")
    private String countryName;
    @JsonAlias("country_code")
    private String countryCode;

    @JsonBackReference
    @ToString.Exclude
    private List<Address> addresses;


}
