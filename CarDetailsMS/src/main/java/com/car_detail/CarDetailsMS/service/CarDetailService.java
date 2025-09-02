package com.car_detail.CarDetailsMS.service;

import com.car_detail.CarDetailsMS.dto.CarDTO;
import com.car_detail.CarDetailsMS.enitity.Car;
import com.car_detail.CarDetailsMS.repo.CarRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CarDetailService {

    private final CarRepo carRepo;
    private final MediaCloudService mediaCloudSaveService;

    public CarDetailService(CarRepo carRepo, MediaCloudService mediaCloudSaveService) {
        this.carRepo = carRepo;
        this.mediaCloudSaveService = mediaCloudSaveService;
    }

    public String addCar(CarDTO carDTO,
                         HttpServletRequest httpServletRequest) {
        Car save = carRepo.save(getCarFromDTO(carDTO));
        return save.getModelName() + " saved";
    }

    public String uploadImage(List<MultipartFile> multipartFiles){
        List<String> url = new ArrayList<>();
        StringBuilder msg = new StringBuilder(" ");
        for (MultipartFile multipartFile: multipartFiles){
            try {
                msg.append(url.add(mediaCloudSaveService.uploadFile(multipartFile))).append(" ");
            }
            catch (IOException e){
                log.error("Error {}" , e.getMessage());
            }
        }

        return String.valueOf(msg);
    }

    private Car getCarFromDTO(CarDTO carDTO){
        return new Car(carDTO.modelName(),
                carDTO.description(),
                carDTO.price());
    }
}
