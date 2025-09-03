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

        Sort sort =  ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return ResponseEntity
                .ok()
                .body(getCarService
                        .getCars(searchDTO,
                                pageNumber,
                                sort));
    }

    @GetMapping("/get-car/{model-name}")
    ResponseEntity<Page<CarDTO>> getCarByName(@PathVariable(value = "model-name") String modelName,
                                                    @RequestParam(defaultValue = "0") int pageNumber,
                                                    @RequestParam(defaultValue = "modelName") String sortBy,
                                                    @RequestParam(defaultValue = "true") boolean ascending) {

        Sort sort =  ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        return ResponseEntity
                .ok()
                .body(getCarService
                        .getCars(new SearchDTO(modelName, null,null),
                                pageNumber,
                                sort));
    }

}
