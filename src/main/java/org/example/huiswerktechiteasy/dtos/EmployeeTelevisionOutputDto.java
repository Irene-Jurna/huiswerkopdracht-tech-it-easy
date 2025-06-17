package org.example.huiswerktechiteasy.dtos;

import org.example.huiswerktechiteasy.models.AvailableSize;
import org.example.huiswerktechiteasy.models.ScreenType;

import java.time.LocalDate;

// Geeft alle velden van Television terug, omdat medewerkers alle informatie mogen inzien
public class EmployeeTelevisionOutputDto {
    public Long id;
    public String type;
    public String brand;
    public String name;
    public Double price;
    public AvailableSize availableSize;
    public Integer refreshRate;
    public ScreenType screenType;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
    public LocalDate originalStock;
    public LocalDate sold;
}
