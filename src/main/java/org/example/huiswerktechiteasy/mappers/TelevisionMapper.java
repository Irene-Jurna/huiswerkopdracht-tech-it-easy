package org.example.huiswerktechiteasy.mappers;

import org.example.huiswerktechiteasy.dtos.EmployeeTelevisionOutputDto;
import org.example.huiswerktechiteasy.dtos.EmployeeTelevisionInputDto;
import org.example.huiswerktechiteasy.models.Television;
import org.springframework.beans.BeanUtils;

public class TelevisionMapper {
    public static Television toEntity(EmployeeTelevisionInputDto tvDto) {
        Television television = new Television();
        television.setType(tvDto.getType());
        television.setBrand(tvDto.getBrand());
        television.setName(tvDto.getName());
        television.setPrice(tvDto.getPrice());
        television.setAvailableSize(tvDto.getAvailableSize());
        television.setRefreshRate(tvDto.getRefreshRate());
        television.setScreenType(tvDto.getScreenType());
        television.setScreenQuality(tvDto.getScreenQuality());
        television.setSmartTv(tvDto.getSmartTv());
        television.setWifi(tvDto.getWifi());
        television.setVoiceControl(tvDto.getVoiceControl());
        television.setHdr(tvDto.getHdr());
        television.setBluetooth(tvDto.getBluetooth());
        television.setAmbiLight(tvDto.getAmbiLight());
        return television;
    }

    public static EmployeeTelevisionOutputDto toDto(Television television) {
        EmployeeTelevisionOutputDto televisionDto = new EmployeeTelevisionOutputDto();
        televisionDto.id = television.getId();
        televisionDto.type = television.getType();
        televisionDto.brand = television.getBrand();
        televisionDto.name = television.getName();
        televisionDto.price = television.getPrice();
        televisionDto.availableSize = television.getAvailableSize();
        televisionDto.refreshRate = television.getRefreshRate();
        televisionDto.screenType = television.getScreenType();
        televisionDto.screenQuality = television.getScreenQuality();
        televisionDto.smartTv =  television.getSmartTv();
        televisionDto.wifi = television.getWifi();
        televisionDto.voiceControl = television.getVoiceControl();
        televisionDto.hdr = television.getHdr();
        televisionDto.bluetooth = television.getBluetooth();
        televisionDto.ambiLight = television.getAmbiLight();
        return televisionDto;
    }
}
