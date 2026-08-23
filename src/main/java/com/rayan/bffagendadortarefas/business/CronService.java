package com.rayan.bffagendadortarefas.business;

import com.rayan.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.rayan.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.rayan.bffagendadortarefas.business.enums.StatusNotificaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
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
        log.info("Iniciada a busca de tarefas...");

        LocalDateTime horaAtual = LocalDateTime.now();
        LocalDateTime horaFuturo = horaAtual.plusHours(1);

        List<TarefasDTOResponse> listaTarefas =
                tarefasService.buscarTarefasAgendadasPorPeriodo(
                        horaAtual,
                        horaFuturo,
                        token
                );
        log.info("Tarefas encontradas" + listaTarefas);

        listaTarefas.forEach(tarefa -> {

            emailService.enviaEmail(tarefa);
            log.info("Email enviado para o usuáiro..."+tarefa.getEmailUsuario());

            tarefasService.alteraStatus(
                    StatusNotificaoEnum.NOTIFICADO,
                    tarefa.getId(),
                    token
            );
        });
        log.info("Finalizada a busca de tarefas e notificação de tarefa");
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