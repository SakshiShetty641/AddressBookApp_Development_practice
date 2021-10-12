package com.bridgelabz.addressbookapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Layer that contains the entities in the database
 * @author - Sakshi Shetty
 * @version - 0.0.1
 * @since - 12/10/2021
 */
@Data
@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String address;
}
