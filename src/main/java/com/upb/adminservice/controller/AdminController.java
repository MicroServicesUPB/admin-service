package com.upb.adminservice.controller;


import com.upb.adminservice.entity.Reservation;
import com.upb.adminservice.model.AdminDetails;
import com.upb.adminservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;


    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = adminService.findAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @PostMapping("/admin")
    public ResponseEntity<String> createAdmin(@RequestBody AdminDetails adminDetails) {
        adminService.createAdmin(adminDetails);
        return ResponseEntity.ok("Administrador creado con éxito");
    }

    @PutMapping("/reservations/{id}/accept")
    public ResponseEntity<String> acceptReservation(@PathVariable Long id) {
        Reservation reservation = adminService.acceptReservation(id);
        return ResponseEntity.ok("Reservación aceptada con ID: " + id);
    }

}
