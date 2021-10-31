package es.sergiomendez.ejercicio1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String model;
    private String os;
    private String cpuType;
    private String gpuType;
    private int releaseYear;
    private int ramSize;
    private int hddSize;
    private double screenSize;

    // Constructores
    public Laptop() {
    }

    public Laptop(Long id, String manufacturer, String model, String os, String cpuType, String gpuType, int releaseYear, int ramSize, int hddSize, double screenSize) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.os = os;
        this.cpuType = cpuType;
        this.gpuType = gpuType;
        this.releaseYear = releaseYear;
        this.ramSize = ramSize;
        this.hddSize = hddSize;
        this.screenSize = screenSize;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getHddSize() {
        return hddSize;
    }

    public void setHddSize(int hddSize) {
        this.hddSize = hddSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    // Tostring

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", os='" + os + '\'' +
                ", cpuType='" + cpuType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", releaseYear=" + releaseYear +
                ", ramSize=" + ramSize +
                " GB, hddSize=" + hddSize +
                " GB, screenSize=" + screenSize +
                " inches}";
    }
}
