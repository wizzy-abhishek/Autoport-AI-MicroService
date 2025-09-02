package com.car_detail.CarDetailsMS.controller;


import com.car_detail.CarDetailsMS.dto.CarDTO;
import com.car_detail.CarDetailsMS.service.CarAdditionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController()
@RequestMapping("/car-detail")
public class CarDetailController {

    private final CarAdditionService carDetailService;

    public CarDetailController(CarAdditionService carDetailService) {
        this.carDetailService = carDetailService;
    }

    @PostMapping(value = "/add-car")
    ResponseEntity<String> addCar(@RequestBody CarDTO carDTO,
                                  HttpServletRequest httpServletRequest){

        return ResponseEntity
                .ok()
                .body(carDetailService
                        .addCar(carDTO,
                                httpServletRequest));

    }

    @PostMapping(value = "/upload-images",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    ResponseEntity<String> uploadImage( @RequestParam(value = "multipartFiles",
            required = false) List<MultipartFile> multipartFiles,
                                        HttpServletRequest httpServletRequest){

        return ResponseEntity.ok()
                .body(carDetailService
                        .uploadImage(multipartFiles));

    }


}
