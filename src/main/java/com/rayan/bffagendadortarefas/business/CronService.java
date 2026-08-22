package com.rayan.bffagendadortarefas.business;

import com.rayan.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.rayan.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.rayan.bffagendadortarefas.business.enums.StatusNotificaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefasService tarefasService;
    private final UsuarioService usuarioService;
    private final EmailService emailService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora() {

        String token = login(converterParaRequestDTO());

        System.out.println("EMAIL CRON: [" + email + "]");
        System.out.println("TOKEN CRON: [" + token + "]");

        LocalDateTime horaAtual = LocalDateTime.now();
        LocalDateTime horaFuturo = horaAtual.plusHours(1);

        List<TarefasDTOResponse> listaTarefas =
                tarefasService.buscarTarefasAgendadasPorPeriodo(
                        horaAtual,
                        horaFuturo,
                        token
                );

        listaTarefas.forEach(tarefa -> {

            emailService.enviaEmail(tarefa);

            tarefasService.alteraStatus(
                    StatusNotificaoEnum.NOTIFICADO,
                    tarefa.getId(),
                    token
            );
        });
    }

    public String login(LoginRequestDTO dto) {
        return usuarioService.loginUsuario(dto);
    }

    public LoginRequestDTO converterParaRequestDTO() {
        return LoginRequestDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}