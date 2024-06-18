package CoinKeeper.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SituacaoUsuario {

    ATIVO("A", "Ativo"),
    INATIVO("I", "Inativo"),
    PENDENTE("p", "Pendente");

    private String codigo;
    private String descricao;

    private SituacaoUsuario(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonCreator
    public static SituacaoUsuario doValor(String codigo) {
        if (codigo.equals("A")) {
            return ATIVO;
        } else if (codigo.equals("I")) {
            return INATIVO;
        } else if(codigo.equals("P")){
            return PENDENTE;
        } else {
            return null;
        }
    }
}
