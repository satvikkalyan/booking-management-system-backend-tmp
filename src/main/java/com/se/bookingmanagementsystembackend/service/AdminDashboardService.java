package com.se.bookingmanagementsystembackend.service;

import com.se.bookingmanagementsystembackend.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AdminDashboardService {

    private final UserRepository userRepository;
    private final RoomTypeRepository roomTypeRepository;


    public int getNoOfCustomers(LocalDate fromDate, LocalDate toDate) {
        return userRepository.findUsersRegisteredBetween(fromDate, toDate);
    }

    @Transactional
    public List<String> getRoomsCount() {
        var obj = roomTypeRepository.noOfRoomsForEachProperty();
        int total = 0;
        for (var entry : obj) {
            total += Integer.parseInt(entry.split(",")[0]);
        }
        obj.add(total + ",Total");
        return obj;
    }
}
