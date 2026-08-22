package com.rayan.bffagendadortarefas.business.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rayan.bffagendadortarefas.business.enums.StatusNotificaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TarefasDTORequest {


    private String nomeDaTarefa;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy HH:mm:ss")
    private LocalDateTime dataEvento;

}
