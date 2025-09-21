package at.htlkaindorf.json;

import at.htlkaindorf.pojos.Address;
import at.htlkaindorf.pojos.Country;
import at.htlkaindorf.pojos.Customer;
import at.htlkaindorf.pojos.Gender;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Json_Access {

    private ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    private File jsonFile = Path.of("src", "main","resources","CountryCustomersModified.json").toFile();
    private InputStream is = Json_Access.class.getResourceAsStream("/CountryCustomers.json");
    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);


    public List<Customer> loadFromJson() throws IOException {

        List<Customer> customers = new ArrayList<>();
        JsonNode root = mapper.readTree(is);

        Map<String,Country> countryMap = new HashMap<>();
        long countryCount = 1;
        long customerId = 1;

        if (root.isArray())
        {
            for (JsonNode node : root)
            {
                Customer customer = new Customer(
                            customerId,
                            node.get("firstname").asText(),
                            node.get("lastname").asText(),
                            node.get("email").asText(),
                            Gender.valueOf(node.get("gender").asText()),
                            LocalDate.parse(node.get("since").asText(),DTF),
                            node.get("active").asBoolean(),
                            null

                );
                customers.add(customer);

                Address address = new Address(
                        customerId,
                        node.get("city").asText(),
                        node.get("postal_code").asText(),
                        node.get("streetname").asText(),
                        node.get("streetnumber").asText(),
                        customer,
                        null
                );
                customer.setAddress(address);


            String countryCode = node.get("country_code").asText();
            Country country;

            if (countryMap.containsKey(countryCode))
            {
                country = countryMap.get(countryCode);
            }
            else
            {
                country = new Country(
                        countryCount++,
                        node.get("country").asText(),
                        countryCode,
                        new ArrayList<>()
                );
                countryMap.put(countryCode,country);
            }

            address.setCountry(country);
            country.getAddresses().add(address);


            customerId++;

            }
        }

        return customers;
    }


    public void writeToJson(List<Customer> customer) throws IOException {

        mapper.writerWithDefaultPrettyPrinter()
            .writeValue(jsonFile,customer);

    }


    public static void main(String[] args) {
        try {
        Json_Access ja = new Json_Access();
        List<Customer> customers = ja.loadFromJson();

        customers.forEach(System.out::println);

        ja.writeToJson(customers);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
