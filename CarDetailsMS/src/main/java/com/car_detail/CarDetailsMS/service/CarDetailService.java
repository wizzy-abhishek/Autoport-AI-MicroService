package com.car_detail.CarDetailsMS.service;

import com.car_detail.CarDetailsMS.dto.CarDTO;
import com.car_detail.CarDetailsMS.repo.CarRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CarDetailService {

    private final CarRepo carRepo;
    private final MediaCloudService mediaCloudSaveService;

    public CarDetailService(CarRepo carRepo, MediaCloudService mediaCloudSaveService) {
        this.carRepo = carRepo;
        this.mediaCloudSaveService = mediaCloudSaveService;
    }

    public String addCar(CarDTO carDTO,
                         HttpServletRequest httpServletRequest,
                         List<MultipartFile> multipartFiles){
        return "";
    }
}
