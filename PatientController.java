package org.example.session11.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.session11.dtos.PatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
@Slf4j
public class PatientController {

    @PostMapping
    public ResponseEntity<String> addPatient(@RequestBody PatientDTO patientDTO) {

        log.info("Đã tiếp nhận yêu cầu thêm mới bệnh nhân. Tên: {}", patientDTO.getName());

        if (patientDTO.getAge() > 120) {
            log.warn("Cảnh báo: Bệnh nhân {} có số tuổi khai báo bất thường ({} tuổi).",
                    patientDTO.getName(), patientDTO.getAge());
        }


        return ResponseEntity.ok("Tiếp nhận bệnh nhân thành công!");
    }
}