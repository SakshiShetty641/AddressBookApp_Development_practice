package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Layer that implements interface and does the database operations
 * @author - Sakshi Shetty
 * @version - 0.0.1
 * @since - 11/10/2021
 */
public interface AddressBookRepository extends JpaRepository<AddressBook, String>{
    Optional<AddressBook> findByName(String name);
}
