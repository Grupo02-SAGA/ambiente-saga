package com.biopark.grupo2.service;

import com.biopark.grupo2.exception.CertificadoExcessao;
import com.biopark.grupo2.model.Certificado;
import com.biopark.grupo2.model.Empresa;
import com.biopark.grupo2.repository.RepositoryCertificado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NovoCertificadoService {

    @Autowired
    private RepositoryCertificado repositoryCertificado;

    public Certificado criarCertificado(Long idFormulario, Empresa empresa){

        Certificado certificado = new Certificado();

        certificado.setId_formulario(idFormulario);
        certificado.setEmpresa(empresa);
        return repositoryCertificado.save(certificado);
    }

    public Certificado recuperarCertificado(Long idCertificado){
        return repositoryCertificado.findById(idCertificado)
                .orElseThrow(() -> new CertificadoExcessao("Certificado não encontrado"));
    }
}
