package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Empresa;
import com.biopark.grupo2.repository.RepositoryEmpresa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EmpresaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RepositoryEmpresa repositoryEmpresa;

    @InjectMocks
    private EmpresaController empresaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        this.mockMvc = MockMvcBuilders.standaloneSetup(empresaController)
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void testListaEmpresas() throws Exception {
        mockMvc.perform(get("/listaEmpresas"))
                .andExpect(status().isOk())
                .andExpect(view().name("listaEmpresas"))
                .andExpect(model().attributeExists("empresas"));
    }

    @Test
    public void testModelAndView() throws Exception {
        mockMvc.perform(get("/novaEmpresa"))
                .andExpect(status().isOk())
                .andExpect(view().name("novaEmpresa"))
                .andExpect(model().attributeExists("empresa"));
    }

    @Test
    public void testCreateEmpresa() throws Exception {
        Empresa empresa = new Empresa();
        empresa.setId_empresa(1L);

        mockMvc.perform(post("/novaEmpresa")
                        .flashAttr("empresa", empresa))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/novaEmpresa"));

        verify(repositoryEmpresa, times(1)).save(any(Empresa.class));
    }

    @Test
    public void testGetEmpresaById() throws Exception {
        Empresa empresa = new Empresa();
        empresa.setId_empresa(1L);

        when(repositoryEmpresa.findById(1L)).thenReturn(java.util.Optional.of(empresa));

        mockMvc.perform(get("/editarEmpresa/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("editarEmpresa"))
                .andExpect(model().attributeExists("empresa"))
                .andExpect(model().attribute("empresa", empresa));
    }

    @Test
    public void testEditarEmpresa() throws Exception {
        Empresa empresaExistente = new Empresa();
        empresaExistente.setId_empresa(1L);

        when(repositoryEmpresa.findById(1L)).thenReturn(java.util.Optional.of(empresaExistente));

        Empresa empresaAtualizada = new Empresa();
        empresaAtualizada.setId_empresa(1L);

        mockMvc.perform(post("/editarEmpresa")
                        .flashAttr("empresa", empresaAtualizada))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/editarEmpresa/1"));

        verify(repositoryEmpresa, times(1)).save(any(Empresa.class));
    }
}
