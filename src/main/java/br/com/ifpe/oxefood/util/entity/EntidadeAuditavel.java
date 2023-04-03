package br.com.ifpe.oxefood.util.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeAuditavel extends EntidadeNegocio {
   
    @JsonIgnore
    @Version
    private Long versao;

    @CreatedDate
    private LocalDate dataCriacao;

    @LastModifiedDate
    private LocalDate dataUltimaModificacao;

    @Column
    private Long criadoPor; // Id do usuário que o criou

    @Column
    private Long ultimaModificacaoPor; // Id do usuário que fez a última alteração

}

