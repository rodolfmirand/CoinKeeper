package CoinKeeper.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStatus {

    ATIVO("A", "Ativo"),
    INATIVO("I", "Inativo"),
    PENDENTE("p", "Pendente");

    private String code;
    private String description;

    private UserStatus(String codigo, String descricao) {
        this.code = codigo;
        this.description = descricao;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonCreator
    public static UserStatus doValor(String code) {
        if (code.equals("A")) {
            return ATIVO;
        } else if (code.equals("I")) {
            return INATIVO;
        } else if(code.equals("P")){
            return PENDENTE;
        } else {
            return null;
        }
    }
}
