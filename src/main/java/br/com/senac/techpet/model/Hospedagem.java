package br.com.senac.techpet.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalTime;

import java.time.LocalTime;


@Entity
public class Hospedagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name = "pet_hospedado_id")
    private Pet petHospedado;
    
    @Column(name = "hora_entrada")
    private LocalTime horaEntrada;
    
    @Column(name = "hora_saida")
    private LocalTime horaSaida;

    public Hospedagem() {
    }

    public Hospedagem(Pet petHospedado, LocalTime horaEntrada, LocalTime horaSaida) {
        this.petHospedado = petHospedado;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pet getPetHospedado() {
        return petHospedado;
    }

    public void setPetHospedado(Pet petHospedado) {
        this.petHospedado = petHospedado;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }
}
