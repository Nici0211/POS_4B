package at.htlkaindorf.pojos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {

    private Long countryId;
    private String countryName;
    private String countryCode;
    private List<Address> addresses;


}
