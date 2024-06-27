package com.biopark.grupo2.service;

import com.biopark.grupo2.model.Documentos;
import com.biopark.grupo2.repository.RepositoryDocumentos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService {
    @Autowired
    private RepositoryDocumentos repositoryDocumentos;

    public void salvarNomeDocumento(String nomeDocumento) {
        Documentos documentos = new Documentos();
        documentos.setNomeDocumento(nomeDocumento);

        repositoryDocumentos.save(documentos);
    }
}
