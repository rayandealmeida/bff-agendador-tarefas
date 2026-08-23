package com.rayan.bffagendadortarefas.infrastructure.client.config;

import com.rayan.bffagendadortarefas.infrastructure.exceptions.BusinessException;
import com.rayan.bffagendadortarefas.infrastructure.exceptions.ConflictException;
import com.rayan.bffagendadortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.rayan.bffagendadortarefas.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 409:
                return new ConflictException("Error atributo já existente");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado ");
            case 401:
                return new UnauthorizedException("Erro usuário não autorizado");
            default:
                return new BusinessException("Error de servidor");
        }
    }
}
