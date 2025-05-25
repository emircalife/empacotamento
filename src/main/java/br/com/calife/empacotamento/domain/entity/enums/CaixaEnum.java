package br.com.calife.empacotamento.domain.entity.enums;

public enum CaixaEnum {
    CAIXA_PEQ(1, "Caixa 1: 30 x 40 x 80"), CAIXA_MED(2, "Caixa 2: 80 x 50 x 40"), CAIXA_GRD(3, "Caixa 3: 50 x 80 x 60");

    private Integer codigo;
    private String descricao;

    private CaixaEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CaixaEnum toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(CaixaEnum x : CaixaEnum.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Caixa inválida");
    }
}

