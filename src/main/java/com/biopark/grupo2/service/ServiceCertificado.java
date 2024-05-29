package com.biopark.grupo2.service;

import com.biopark.grupo2.DTO.AvaliacaoDTO;
import com.biopark.grupo2.repository.RepositoryCertificado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCertificado {

    @Autowired
    private RepositoryCertificado certificadoRepository;

    public List<AvaliacaoDTO> listarAvaliacoes() {
        List<Object[]> results = certificadoRepository.findAvaliacoes();
        List<AvaliacaoDTO> collect = results.stream()
                .map(result -> new AvaliacaoDTO(
                        (Integer)result[0],
                        (Date) result[1],
                        (String) result[2],
                        (String) result[3],
                        (String) result[4],
                        (Long) result[5]
                ))
                .collect(Collectors.toList());
        return collect;
    }


//        public List<CertificadoDTO> getResultsByEmpresa(Long empresaId) {
//            List<Object[]> results = certificadoRepository.findResultsByEmpresa(empresaId);
//            return results.stream()
//                    .map(result -> new CertificadoDTO(
//                            (Long) result[0],
//                            (String) result[1],
//                            (String) result[2],
//                            (String) result[3]
//                    ))
//                    .collect(Collectors.toList());
//        }
}
