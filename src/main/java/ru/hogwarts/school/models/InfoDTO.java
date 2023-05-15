package ru.hogwarts.school.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Data
public class InfoDTO {

    private String appName = "hogwarts-school";
    private String appVersion = "0.0.1";
    private String appEnvironment = "";

    public InfoDTO(String appName, String appVersion, String appEnvironment) {
        this.appName = appName;
        this.appVersion = appVersion;
        this.appEnvironment = appEnvironment;
    }
}
