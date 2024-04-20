package com.biopark.grupo2.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "empresa")
@Entity(name = "empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_empresa;
    private String fantasia;
    private String razao_social;
    private String cnpj;
    private String email;
    private String endereco;
    private String telefone;
    private String porte;
    private String atividade;

    public Empresa(RequestEmpresa requestEmpresa){
            this.fantasia = requestEmpresa.fantasia();
            this.razao_social = requestEmpresa.razao_social();
            this.cnpj = requestEmpresa.cnpj();
            this.email = requestEmpresa.email();
            this.endereco = requestEmpresa.endereco();
            this.telefone = requestEmpresa.telefone();
            this.porte = requestEmpresa.porte();
            this.atividade = requestEmpresa.atividade();
    }
}
