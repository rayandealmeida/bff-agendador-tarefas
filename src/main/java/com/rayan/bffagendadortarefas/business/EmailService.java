package com.rayan.bffagendadortarefas.business;


import com.rayan.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.rayan.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailClient emailClient;

    void enviaEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }

}
