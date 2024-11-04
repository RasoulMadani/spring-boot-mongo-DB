package ir.maktabsharif.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Address {

    private final String street;
    private final String city;
    private final String state;
    private final String postalCode;


    // Getters and Setters
}