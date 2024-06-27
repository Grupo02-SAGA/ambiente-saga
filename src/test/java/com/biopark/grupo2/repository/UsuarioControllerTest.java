package com.biopark.grupo2.controller;

import com.biopark.grupo2.model.Usuario;
import com.biopark.grupo2.repository.RepositoryUsuario;
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

public class UsuarioControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RepositoryUsuario repositoryUsuario;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        this.mockMvc = MockMvcBuilders.standaloneSetup(usuarioController)
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void testModelAndView() throws Exception {
        mockMvc.perform(get("/novoUsuario"))
                .andExpect(status().isOk())
                .andExpect(view().name("novoUsuario"))
                .andExpect(model().attributeExists("usuario"));
    }

    @Test
    public void testCreateUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId_usuario(1L);
        usuario.setNome("Teste");

        mockMvc.perform(post("/novoUsuario")
                        .flashAttr("usuario", usuario))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/novoUsuario"));

        verify(repositoryUsuario, times(1)).save(any(Usuario.class));
    }

    @Test
    public void testGetUsuarioById() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId_usuario(1L);
        usuario.setNome("Teste");

        when(repositoryUsuario.findById(1L)).thenReturn(java.util.Optional.of(usuario));

        mockMvc.perform(get("/editarUsuario/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("editarUsuario"))
                .andExpect(model().attributeExists("usuario"))
                .andExpect(model().attribute("usuario", usuario));
    }

    @Test
    public void testEditarUsuario() throws Exception {
        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setId_usuario(1L);
        usuarioExistente.setNome("Existente");

        when(repositoryUsuario.findById(1L)).thenReturn(java.util.Optional.of(usuarioExistente));

        Usuario usuarioAtualizado = new Usuario();
        usuarioAtualizado.setId_usuario(1L);
        usuarioAtualizado.setNome("Atualizado");

        mockMvc.perform(post("/editarUsuario")
                        .flashAttr("usuario", usuarioAtualizado))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/editarUsuario/1"));

        verify(repositoryUsuario, times(1)).save(any(Usuario.class));
    }

    @Test
    public void testListaUsuarios() throws Exception {
        mockMvc.perform(get("/listaUsuarios"))
                .andExpect(status().isOk())
                .andExpect(view().name("listaUsuarios"))
                .andExpect(model().attributeExists("usuarios"));
    }
}
