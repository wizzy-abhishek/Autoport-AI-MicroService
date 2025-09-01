package com.car_detail.CarDetailsMS.controller;


import com.car_detail.CarDetailsMS.dto.CarDTO;
import com.car_detail.CarDetailsMS.service.CarDetailService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController("/car-detail")
public class CarDetailController {

    private final CarDetailService carDetailService;

    public CarDetailController(CarDetailService carDetailService) {
        this.carDetailService = carDetailService;
    }

    @PostMapping("/add-car")
    ResponseEntity<String> addCar(@RequestParam CarDTO carDTO,
                                  @RequestParam List<MultipartFile> multipartFiles,
                                  HttpServletRequest httpServletRequest){

        return ResponseEntity
                .ok()
                .body(carDetailService
                        .addCar(carDTO,
                                httpServletRequest,
                                multipartFiles));

    }
}
