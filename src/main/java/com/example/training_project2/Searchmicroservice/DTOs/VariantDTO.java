package com.example.training_project2.Searchmicroservice.DTOs;

import org.springframework.data.annotation.Id;


public class VariantDTO {

    private String variantId;
    private String ram;
    private String colour;
    private String screenSize;
    private String screenType;
    private String simSlots;
    private String batterySize;
    private String processor;
    private String frontCamera;
    private String backCamera;
    private String price;
    private String graphicsCard;
    private String usbPorts;
    private String networkDetails;
    private String speakerDetails;
    private String warrantyDetails;

    public VariantDTO() {
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getSimSlots() {
        return simSlots;
    }

    public void setSimSlots(String simSlots) {
        this.simSlots = simSlots;
    }

    public String getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(String batterySize) {
        this.batterySize = batterySize;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public String getBackCamera() {
        return backCamera;
    }

    public void setBackCamera(String backCamera) {
        this.backCamera = backCamera;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getUsbPorts() {
        return usbPorts;
    }

    public void setUsbPorts(String usbPorts) {
        this.usbPorts = usbPorts;
    }

    public String getNetworkDetails() {
        return networkDetails;
    }

    public void setNetworkDetails(String networkDetails) {
        this.networkDetails = networkDetails;
    }

    public String getSpeakerDetails() {
        return speakerDetails;
    }

    public void setSpeakerDetails(String speakerDetails) {
        this.speakerDetails = speakerDetails;
    }

    public String getWarrantyDetails() {
        return warrantyDetails;
    }

    public void setWarrantyDetails(String warrantyDetails) {
        this.warrantyDetails = warrantyDetails;
    }
}