package com.biopark.grupo2.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Table(name = "Certificado")
@Entity(name = "Certificado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_certificado")
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_certificado;
    private Date vencimento;
    private double resultado;
    @ManyToOne
    @JoinColumn(name = "id_formulario")
    private Formulario id_formulario;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa id_empresa;



}


