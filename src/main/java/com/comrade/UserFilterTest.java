package com.comrade;


import com.comrade.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class UserFilterTest {

    @Test
    public void addressFilterBothTrueTest(){

        User user = new User();
        user.setFirstName("Shiva");
        user.setLastName("Dasari");
        user.setGender(Gender.MALE);

        Address addressPer = new Address();
        addressPer.setHouseNumber("4-22");
        addressPer.setStreet("Church street");
        addressPer.setLandMark("Near Govt School");
        addressPer.setAddressLine1("Thalla Malkapuram(V), Garidepally(M)");
        addressPer.setAddressLine2("Suryapet(D)");
        addressPer.setState("Telangana");
        addressPer.setCountry("India");
        addressPer.setPostalCode("508201");
        addressPer.setAddressType(AddressType.PERMANENT);

        Address addressTem = new Address();
        addressTem.setHouseNumber("10-15/2");
        addressTem.setStreet("Netaji Nagar");
        addressTem.setLandMark("Near Ramalayam common");
        addressTem.setAddressLine1("Fathenagar, Begampet");
        addressTem.setAddressLine2("Hyderabad");
        addressTem.setState("Telangana");
        addressTem.setCountry("India");
        addressTem.setPostalCode("500082");
        addressTem.setAddressType(AddressType.TEMPORARY);

        List<Address> addresses = new ArrayList<>();
        addresses.add(addressPer);
        addresses.add(addressTem);

        user.setAddresses(addresses);

        List<Filter> filters = new ArrayList<>();
        Filter filterOne = new Filter("Permanent", true);
        Filter filterTwo = new Filter("Temporary", true);

        filters.add(filterOne);
        filters.add(filterTwo);
        DearComradeJavaZeroToHero dearComradeJavaZeroToHero = new DearComradeJavaZeroToHero();
        List<Address> addressesResult = dearComradeJavaZeroToHero.filterAddress(user, filters);
        assertEquals(2, addressesResult.size());
    }

    @Test
    public void addressFilterOneTrueTest(){

        User user = new User();
        user.setFirstName("Shiva");
        user.setLastName("Dasari");
        user.setGender(Gender.MALE);

        Address addressPer = new Address();
        addressPer.setHouseNumber("4-22");
        addressPer.setStreet("Church street");
        addressPer.setLandMark("Near Govt School");
        addressPer.setAddressLine1("Thalla Malkapuram(V), Garidepally(M)");
        addressPer.setAddressLine2("Suryapet(D)");
        addressPer.setState("Telangana");
        addressPer.setCountry("India");
        addressPer.setPostalCode("508201");
        addressPer.setAddressType(AddressType.PERMANENT);

        Address addressTem = new Address();
        addressTem.setHouseNumber("10-15/2");
        addressTem.setStreet("Netaji Nagar");
        addressTem.setLandMark("Near Ramalayam common");
        addressTem.setAddressLine1("Fathenagar, Begampet");
        addressTem.setAddressLine2("Hyderabad");
        addressTem.setState("Telangana");
        addressTem.setCountry("India");
        addressTem.setPostalCode("500082");
        addressTem.setAddressType(AddressType.TEMPORARY);

        List<Address> addresses = new ArrayList<>();
        addresses.add(addressPer);
        addresses.add(addressTem);

        user.setAddresses(addresses);

        List<Filter> filters = new ArrayList<>();
        Filter filterOne = new Filter("Permanent", true);
        Filter filterTwo = new Filter("Temporary", false);

        filters.add(filterOne);
        filters.add(filterTwo);
        DearComradeJavaZeroToHero dearComradeJavaZeroToHero = new DearComradeJavaZeroToHero();
        List<Address> addressesResult = dearComradeJavaZeroToHero.filterAddress(user, filters);
        assertEquals(1, addressesResult.size());
    }

    @Test
    public void addressFilterBothFalseTest(){

        User user = new User();
        user.setFirstName("Shiva");
        user.setLastName("Dasari");
        user.setGender(Gender.MALE);

        Address addressPer = new Address();
        addressPer.setHouseNumber("4-22");
        addressPer.setStreet("Church street");
        addressPer.setLandMark("Near Govt School");
        addressPer.setAddressLine1("Thalla Malkapuram(V), Garidepally(M)");
        addressPer.setAddressLine2("Suryapet(D)");
        addressPer.setState("Telangana");
        addressPer.setCountry("India");
        addressPer.setPostalCode("508201");
        addressPer.setAddressType(AddressType.PERMANENT);

        Address addressTem = new Address();
        addressTem.setHouseNumber("10-15/2");
        addressTem.setStreet("Netaji Nagar");
        addressTem.setLandMark("Near Ramalayam common");
        addressTem.setAddressLine1("Fathenagar, Begampet");
        addressTem.setAddressLine2("Hyderabad");
        addressTem.setState("Telangana");
        addressTem.setCountry("India");
        addressTem.setPostalCode("500082");
        addressTem.setAddressType(AddressType.TEMPORARY);

        List<Address> addresses = new ArrayList<>();
        addresses.add(addressPer);
        addresses.add(addressTem);

        user.setAddresses(addresses);

        List<Filter> filters = new ArrayList<>();
        Filter filterOne = new Filter("Permanent", false);
        Filter filterTwo = new Filter("Temporary", false);

        filters.add(filterOne);
        filters.add(filterTwo);
        DearComradeJavaZeroToHero dearComradeJavaZeroToHero = new DearComradeJavaZeroToHero();
        List<Address> addressesResult = dearComradeJavaZeroToHero.filterAddress(user, filters);
        assertEquals(0, addressesResult.size());
    }
}
