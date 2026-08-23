package com.rayan.bffagendadortarefas.business;


import com.rayan.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.rayan.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.rayan.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.rayan.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.rayan.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.rayan.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.rayan.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.rayan.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO dto) {
        return usuarioClient.login(dto);
    }


    public UsuarioDTOResponse buscarUsuarioEmail(String email, String token) {
        return usuarioClient.buscaUsuariopPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(UsuarioDTORequest dto, String token) {

        return usuarioClient.atualizarDadosUsuario(dto, token);

    }

    public EnderecoDTOResponse atualizaEndereco(EnderecoDTORequest enderecoDTO, Long idEndereco, String token) {
        return usuarioClient.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizarTelefone(TelefoneDTORequest telefoneDTO, Long idTelefone, String token) {
        return usuarioClient.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTOResponse cadastrarEndereco(EnderecoDTORequest dto, String token) {
        return usuarioClient.cadastrarEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastrarTelefone(TelefoneDTORequest dto, String token) {
        return usuarioClient.cadastrarTelefone(dto, token);
    }
}
