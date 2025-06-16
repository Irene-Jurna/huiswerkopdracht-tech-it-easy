package org.example.huiswerktechiteasy.mappers;

import org.example.huiswerktechiteasy.dtos.TelevisionDto;
import org.example.huiswerktechiteasy.dtos.TelevisionInputDto;
import org.example.huiswerktechiteasy.models.Television;

public class TelevisionMapper {
    public static Television toEntity(TelevisionInputDto tvDto) {
        return new Television(tvDto.brand, tvDto.name);
    }

    public static TelevisionDto toDto(Television television) {
        TelevisionDto televisionDto = new TelevisionDto();
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
