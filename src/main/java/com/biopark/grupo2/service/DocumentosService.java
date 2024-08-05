package com.biopark.grupo2.service;

import com.biopark.grupo2.model.Documentos;
import com.biopark.grupo2.repository.RepositoryDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentosService {

    @Autowired
    private RepositoryDocumentos repositoryDocumentos;

    public Documentos salvarDocumento(List<MultipartFile> arquivos) {

        List<Documentos> salvarDocumento = new ArrayList<>();

        for (MultipartFile arquivo : arquivos) {
            Documentos documento = new Documentos();
            documento.setNomeDocumento(arquivo.getOriginalFilename());

            salvarDocumento.add(repositoryDocumentos.save(documento));
        }

        return salvarDocumento
                .isEmpty() ? null : salvarDocumento.get(0);
    }
}
