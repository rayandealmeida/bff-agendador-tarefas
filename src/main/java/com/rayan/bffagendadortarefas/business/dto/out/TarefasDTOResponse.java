package com.rayan.bffagendadortarefas.business.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rayan.bffagendadortarefas.business.enums.StatusNotificaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TarefasDTOResponse {

    private String id;
    private String nomeDaTarefa;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNotificaoEnum statusNotificaoEnum;
}
