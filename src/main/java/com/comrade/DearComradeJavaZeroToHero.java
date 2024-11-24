package com.comrade;

import com.comrade.model.*;
import java.util.List;
import java.util.stream.Collectors;

public class DearComradeJavaZeroToHero
{
    public List<Address> filterAddress(User user, List<Filter> filters){
        return filters.isEmpty() ? user.getAddresses():
                                   user.getAddresses()
                                           .stream().filter(address -> filters.stream().anyMatch(filter -> address.getAddressType().getName().equals(filter.getFieldName()) && filter.isViewStatus()))
                                           .collect(Collectors.toList());
    }
}
