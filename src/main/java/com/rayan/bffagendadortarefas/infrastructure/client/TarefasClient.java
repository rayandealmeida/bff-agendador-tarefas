package com.rayan.bffagendadortarefas.infrastructure.client;

import com.rayan.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.rayan.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.rayan.bffagendadortarefas.business.enums.StatusNotificaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestHeader("Authorization") String token);

    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefaPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);


    @GetMapping
    List<TarefasDTOResponse> buscarTarefasPorEmail(@RequestHeader("Authorization") String token);

    @DeleteMapping
    void deletarTarefaPorId(@RequestParam("id") String id, @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefasDTOResponse alterarStatusNotificacao(@RequestParam("status") StatusNotificaoEnum statusNotificaoEnum,
                                                @RequestParam("id") String id,
                                                @RequestHeader("Authorization") String token);

    @PutMapping
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestParam("id")String id,
                                     @RequestHeader("Authorization") String token);
}
