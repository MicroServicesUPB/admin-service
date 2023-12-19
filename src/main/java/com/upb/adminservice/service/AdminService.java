package com.upb.adminservice.service;

import com.upb.adminservice.entity.Reservation;
import com.upb.adminservice.model.AdminDetails;

import java.util.List;

public interface AdminService {
    List<Reservation> findAllReservations();
    void createAdmin(AdminDetails adminDetails);
    Reservation acceptReservation(Long reservationId);
}
