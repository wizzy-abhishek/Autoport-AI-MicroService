package com.car_detail.CarDetailsMS.controller;

import com.car_detail.CarDetailsMS.dto.CarDTO;
import com.car_detail.CarDetailsMS.dto.SearchDTO;
import com.car_detail.CarDetailsMS.service.GetCarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicCarShowcaseController {

    private final GetCarService getCarService;

    public PublicCarShowcaseController(GetCarService getCarService) {
        this.getCarService = getCarService;
    }

    @PostMapping("/get-car")
    ResponseEntity<Page<CarDTO>> getAllCars(@RequestBody SearchDTO searchDTO,
                                            @RequestParam(defaultValue = "0") int pageNumber,
                                            @RequestParam(defaultValue = "modelName") String sortBy,
                                            @RequestParam(defaultValue = "true") boolean ascending){

        return ResponseEntity
                .ok()
                .body(getCarService.getCars(searchDTO, pageNumber, sortBy, ascending));
    }

    @GetMapping("/get-car/{modelName}")
    ResponseEntity<Page<CarDTO>> getCarByName(@PathVariable(value = "modelName") String modelName,
                                                    @RequestParam(defaultValue = "0") int pageNumber,
                                                    @RequestParam(defaultValue = "modelName") String sortBy,
                                                    @RequestParam(defaultValue = "true") boolean ascending) {
        return ResponseEntity
                .ok()
                .body(getCarService
                        .getCars(new SearchDTO(modelName, modelName,modelName), pageNumber, sortBy, ascending));
    }

}
