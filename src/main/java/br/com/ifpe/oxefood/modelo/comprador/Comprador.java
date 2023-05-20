package br.com.ifpe.oxefood.modelo.comprador;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Comprador")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comprador extends EntidadeAuditavel {
    
    private static final long serialVersionUID = 6744535953108071602L;

    @Column
    private String nome;

    @Column
    private String enderecoComercial;

    @Column
    private String enderecoResidencial;
    
    @Column
    private Double comissao;

    @Column
    private Boolean trabahoHomeOffice;

    @Column
    private int qtdComprasMediasMes;
    
    @Column
    private LocalDate contratadoEm;

}
