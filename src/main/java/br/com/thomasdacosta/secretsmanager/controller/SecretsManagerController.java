package br.com.thomasdacosta.secretsmanager.controller;

import br.com.thomasdacosta.secretsmanager.configuration.SecretsManagerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SecretsManagerController {

    @Autowired
    private SecretsManagerConfiguration configuration;

    @GetMapping("/secretsManagerConfiguration")
    public String configuration() {
        return String.format("%s - %s - %s", configuration.getValor1(),
                configuration.getValor2(), configuration.getValor3());
    }

}
