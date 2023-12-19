package com.upb.adminservice.service.impl;

import com.upb.adminservice.client.AuthServiceClient;
import com.upb.adminservice.entity.Reservation;
import com.upb.adminservice.model.AdminDetails;
import com.upb.adminservice.repository.ReservationRepository;
import com.upb.adminservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ReservationRepository reservationRepository;

    private final AuthServiceClient authServiceClient;

    @Override
    public List<Reservation> findAllReservations() {
        // Consulta a la base de datos para obtener todas las reservaciones
        return reservationRepository.findAll();
    }

    @Override
    public void createAdmin(AdminDetails adminDetails) {
        // Llama al servicio de autenticación para crear un administrador
        authServiceClient.createAdmin(adminDetails);
    }

    @Override
    public Reservation acceptReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        // Acepta la reservación actual
        reservation.setStatus("ACCEPTED");
        reservationRepository.save(reservation);

        // Encuentra y rechaza todas las reservaciones con el mismo tableId y reservationTime
        List<Reservation> conflictingReservations = reservationRepository
                .findByTableIdAndReservationTime(reservation.getTableId(), reservation.getReservationTime());

        for (Reservation conflicting : conflictingReservations) {
            if (!conflicting.getId().equals(reservationId)) { // Ignora la reservación actual
                conflicting.setStatus("REJECTED");
                reservationRepository.save(conflicting);
            }
        }

        return reservation;
    }
}
