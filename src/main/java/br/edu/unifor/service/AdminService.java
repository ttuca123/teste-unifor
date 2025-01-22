package br.edu.unifor.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdminService {

    public String getServico() {

        return "Serviço admin";
    }

}
