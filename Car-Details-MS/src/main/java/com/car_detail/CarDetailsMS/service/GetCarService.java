package com.car_detail.CarDetailsMS.service;

import com.car_detail.CarDetailsMS.criteria_builder.GetCarFilteredRepo;
import com.car_detail.CarDetailsMS.dto.CarDTO;
import com.car_detail.CarDetailsMS.dto.SearchDTO;
import com.car_detail.CarDetailsMS.enitity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCarService {

    private static final int PAGE_SIZE_10 = 10;

    private final GetCarFilteredRepo getCarFilteredRepo;

    public GetCarService(GetCarFilteredRepo getCarFilteredRepo) {
        this.getCarFilteredRepo = getCarFilteredRepo;
    }

    public Page<CarDTO> getCars(SearchDTO searchDTO,
                                int pageNumber,
                                String sortBy, boolean ascending){

        Sort sort =  ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        List<Car> filteredCars = getCarFilteredRepo.getCarsAccordingToFilter(searchDTO, sortBy, ascending);

        List<CarDTO> carDTO = filteredCars
                .stream()
                .map(GetCarService::getCarDTO).toList();

        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE_10 ,sort);
        return new PageImpl<>(carDTO, pageRequest, carDTO.size());
    }

    public static CarDTO getCarDTO(Car car){
        return new CarDTO(car.getModelName(), car.getCarBrand().toString(),car.getDescription(), car.getPrice());
    }
}
