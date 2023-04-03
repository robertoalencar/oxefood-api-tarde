package br.com.ifpe.oxefood.util.entity;

import br.com.ifpe.oxefood.util.exception.PreenchimentoException;

public abstract class GenericController {
 
    protected void validarPreenchimentoChave(String chave) {

        if (chave == null || chave.equals("")) {
            throw new PreenchimentoException(PreenchimentoException.MSG_CHAVE_NAO_INFORMADA);
        }
    }
}

