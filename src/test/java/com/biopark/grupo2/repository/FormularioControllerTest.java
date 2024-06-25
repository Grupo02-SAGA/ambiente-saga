package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class FormularioControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RepositoryFormulario repositoryFormulario;

    @InjectMocks
    private FormularioController formularioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        this.mockMvc = MockMvcBuilders.standaloneSetup(formularioController)
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void testListaFormsBase() throws Exception {
        List<Formulario> formularios = new ArrayList<>();
        when(repositoryFormulario.findAll()).thenReturn(formularios);

        mockMvc.perform(get("/listaFormsBase"))
                .andExpect(status().isOk())
                .andExpect(view().name("listaFormsBase"))
                .andExpect(model().attributeExists("forms"))
                .andExpect(model().attribute("forms", formularios));
    }

    @Test
    public void testCriarForm() throws Exception {
        Formulario formulario = new Formulario();
        formulario.setId_formulario(1L);

        when(repositoryFormulario.save(any(Formulario.class))).thenReturn(formulario);

        mockMvc.perform(post("/listaFormsBase")
                        .flashAttr("formulario", formulario))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/detalhesFormulario/1"));

        verify(repositoryFormulario, times(1)).save(any(Formulario.class));
    }
}
