package com.rayan.bffagendadortarefas.infrastructure.client;

import com.rayan.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.rayan.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.rayan.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.rayan.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.rayan.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.rayan.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.rayan.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuariopPorEmail(@RequestParam("email") String email,
                                             @RequestHeader("Authorization")String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);
    //

    /*
     * Metodo Post para login
     *  */
    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);
    //

    /*
     * Metodo Delete para deletar um usuário por email
     *  */
    @DeleteMapping("/{email}")
     void deletaUsuarioPorEmail(@PathVariable String email,
                                                      @RequestHeader("Authorization") String token);
    /*
     * Metodo Post para atualizar dados usuario
     *  */
    @PutMapping
    UsuarioDTOResponse atualizarDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                             @RequestHeader("Authorization") String token);
    //

    /*
     * Metodo Post para atualizar endereço e telefone
     *  */
    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization")String token);
    //

    /*
     * Metodo Post para cadastrar endereço e telefone
     *  */
    @PostMapping("/endereco")
    EnderecoDTOResponse cadastrarEndereco(@RequestBody EnderecoDTORequest dto,
                                          @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastrarTelefone(@RequestBody TelefoneDTORequest dto,
                                          @RequestHeader("Authorization") String token);
}
