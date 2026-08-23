package com.rayan.bffagendadortarefas.business;


import com.rayan.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.rayan.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.rayan.bffagendadortarefas.business.enums.StatusNotificaoEnum;
import com.rayan.bffagendadortarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasClient tarefasClient;


    /*
    Cadastrar tarefa
    * */
    public TarefasDTOResponse gravarTarefa(String token, TarefasDTORequest dto) {
        return tarefasClient.gravarTarefas(dto, token);
    }


    public List<TarefasDTOResponse> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefasClient.buscaListaDeTarefaPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscarTarefasPorEmail(String token) {
        return tarefasClient.buscarTarefasPorEmail(token);

    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletarTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificaoEnum status, String id, String token) {
        return tarefasClient.alterarStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token) {
        return tarefasClient.updateTarefas(dto, id, token);

    }
}
