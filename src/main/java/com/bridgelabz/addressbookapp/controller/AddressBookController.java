package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.entity.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Layer that receives various HTTP request from client
 * @author - Sakshi Shetty
 * @version - 0.0.1
 * @since - 11/10/2021
 */

@RestController
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * Function to receive get request from client
     * @param addressBookDto address data from client
     * @return added address in the database
     */
    @PostMapping("/addaddress")
    public AddressBook addAddress(@RequestBody AddressBookDto addressBookDto){
        return addressBookService.addAddress(addressBookDto);
    }

    /**
     * Function to receive put request from client
     * @param name unique name of the person
     * @return updated address
     */
    @PutMapping(value = "/editaddress{name}")
    public AddressBook editAddress(@PathVariable String name, @RequestBody AddressBookDto addressBookDto){
        return addressBookService.editAddress(name, addressBookDto);
    }

    /**
     * Function to receive delete request from client
     * @param name unique name of the person
     * @return String message displaying status of operation
     */
    @DeleteMapping(value = "/deleteaddress")
    public String deleteAddress(@RequestParam String name) {
        return addressBookService.deleteAddress(name);
    }
}


