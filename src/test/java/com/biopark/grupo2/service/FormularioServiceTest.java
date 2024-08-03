package com.biopark.grupo2.service;

import com.biopark.grupo2.model.Formulario;
import com.biopark.grupo2.repository.RepositoryFormulario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FormularioServiceTest {

    @InjectMocks
    private FormularioService formularioService;

    @Mock
    private RepositoryFormulario repositoryFormulario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarFormulario() {
        Formulario formulario = new Formulario();
        formulario.setId_formulario(1L);
        when(repositoryFormulario.findById(1L)).thenReturn(Optional.of(formulario));

        Formulario result = formularioService.consultarFormulario(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId_formulario());

        verify(repositoryFormulario, times(1)).findById(1L);
    }

    @Test
    void testAlterarFormulario() {
        Formulario existingFormulario = new Formulario();
        existingFormulario.setId_formulario(1L);
        when(repositoryFormulario.findById(1L)).thenReturn(Optional.of(existingFormulario));
        when(repositoryFormulario.save(any(Formulario.class))).thenReturn(existingFormulario);

        Formulario updatedFormulario = new Formulario();
        updatedFormulario.setTitulo("Updated Title");

        Formulario result = formularioService.alterarFormulario(1L, updatedFormulario);
        assertNotNull(result);
        assertEquals("Updated Title", result.getTitulo());

        verify(repositoryFormulario, times(1)).findById(1L);
        verify(repositoryFormulario, times(1)).save(existingFormulario);
    }

    @Test
    void testAlterarFormularioNotFound() {
        when(repositoryFormulario.findById(1L)).thenReturn(Optional.empty());

        Formulario updatedFormulario = new Formulario();
        Formulario result = formularioService.alterarFormulario(1L, updatedFormulario);
        assertNull(result);

        verify(repositoryFormulario, times(1)).findById(1L);
        verify(repositoryFormulario, never()).save(any(Formulario.class));
    }
//
//    @Test
//    void testFindByBase2() {
//        Formulario formulario = new Formulario();
//        formulario.setTitulo("Test Title");
//        Page<Formulario> page = new PageImpl<>(Collections.singletonList(formulario));
//        when(repositoryFormulario.findFormularioByNome(anyString(), any(PageRequest.class))).thenReturn(page);
//
//        Page<Formulario> result = formularioService.findFormulariosLista(0, 10, true, "Test Title");
//        assertNotNull(result);
//        assertFalse(result.isEmpty());
//        assertEquals(1, result.getTotalElements());
//        assertEquals("Test Title", result.getContent().get(0).getTitulo());
//
//        verify(repositoryFormulario, times(1)).findFormularioByNome("Test Title", PageRequest.of(0, 10));
//    }
}
