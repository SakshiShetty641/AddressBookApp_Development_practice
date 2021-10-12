package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.entity.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Layer contains business logic,
 * It implements all the methods in controller layer
 * @author - Sakshi Shetty
 * @version - 0.0.1
 * @since - 11/10/2021
 */

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
     * Function to add address to the database
     * @param addressBookDto address data from client
     * @return address added
     */
    public AddressBook addAddress(AddressBookDto addressBookDto){
       AddressBook addressBook = new AddressBook();
        addressBook.setAddress(addressBookDto.getAddress());
        return addressBookRepository.save(addressBook);
    }

    /**
     * Function to get a particular address stored in database
     * @param name unique name of the person whose address stored
     * @return address with unique name
     */
    public AddressBook findAddressByName(String name) {
        Optional<AddressBook> address = addressBookRepository.findByName(name);
        if (address.isPresent()) {
            return address.get();
        }
        return null;
    }

    /**
     * Function to edit the available address in the database
     * @param name of the person whose address stored
     * @param addressBookDTO  data from client
     * @return updated address of the person
     */
    public AddressBook editAddress(String name, AddressBookDto addressBookDTO) {
        Optional<AddressBook> addressBook = addressBookRepository.findByName(name);
        if (addressBook.isPresent()) {
            AddressBook addressDetails = addressBook.get();
            addressDetails.setAddress(addressBookDTO.getAddress());
            return  addressDetails ;
        }
        return null;
    }

    /**
     * Function to particular address from database and delete it
     * @param name of the person whose address stored
     * @return String message displaying status of operation
     */
    public String deleteAddress(String name) {
        Optional<AddressBook> addressBook = addressBookRepository.findByName(name);
        if (addressBook.isPresent()) {
            addressBookRepository.delete(addressBook.get());
            return "Record deleted successfully";
        }
        return "Record does not exists with this name : " + name;
    }
}
