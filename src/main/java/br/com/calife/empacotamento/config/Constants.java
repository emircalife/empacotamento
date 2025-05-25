package br.com.calife.empacotamento.config;

import java.util.Locale;

public interface Constants {
    /*
     *  CONTROLLERS
     */
    public interface CONTROLLER {
        /*	*/
        public static final String BASE_URL = "";
        public static final String SLASH = "/";
        public static final String BUILD = "build";

        /*	*/
        public interface CADASTROS {
            public static final String BASE_URL = "/cadastros";
            public static final String CATEGORIA_URL = BASE_URL + "-categoria";
            public static final String CLIENTE_URL = BASE_URL + "-cliente";
            public static final String COMPRA_URL = BASE_URL + "-compra";
            public static final String COMPRA_ITEM_URL = BASE_URL + "-compraitem";
            public static final String EMPRESA_URL = BASE_URL + "-empresa";
            public static final String PORMA_PAGAMENTO_URL = BASE_URL + "-formapagamento";
            public static final String FORNECEDOR_URL = BASE_URL + "-fornecedor";
            public static final String PRODUTO_URL = BASE_URL + "-produto";
            public static final String SUBCATEGORIA_URL = BASE_URL + "-subcategoria";
            public static final String UF_URL = BASE_URL + "-uf";
            public static final String UNIDADE_MEDIDA_URL = BASE_URL + "-unidademedida";
            public static final String USUARIO_URL = BASE_URL + "-usuario";
            public static final String VENDA_URL = BASE_URL + "-venda";
            public static final String VENDA_ITEM_URL = BASE_URL + "-vendaitem";
        }
    }

    interface TIME_ZONE {
        public static final String DEFAULT = "America/Sao_Paulo";
    }

    interface LOCALE {
        public static final Locale DEFAULT = new Locale("pt", "BR");
        public static final Locale SQL = new Locale("en", "US");
    }

    interface JSON {
        interface DATE {
            public static final String DEFAULT = "yyyy-MM-dd";
            public static final String SMMALDATETIME = "yyyy-MM-dd HH:mm";
            public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";
            public static final String TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS"; // "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
            public static final String TIME = "HH:mm:ss";
        }
    }

    interface DOCUMENTATION {
        interface MESSAGES {
            /*
             * CRUD DOCUMENTATION MESSAGES CONSTANTS
             */

            // SUMMARIES
            public static final String SUMMARY_CREATE = "Cadastrar novo registro";
            public static final String SUMMARY_FIND_BY_ID = "Pesquisar registro por ID";
            public static final String SUMMARY_FIND_ALL = "Localizar todos os recursos";
            public static final String SUMMARY_SEARCH = "Pesquisar recursos";
            public static final String SUMMARY_UPDATE = "Recurso para atualizar registro";
            public static final String SUMMARY_DELETE = "Recurso para deletar registro";

            // RESPONSES
            public static final String RESPONSE_201 = "Recurso criado com sucesso";
            public static final String RESPONSE_200_UPDATE = "Registro atualizado com sucesso.";
            public static final String RESPONSE_200_FIND_ALL = "Registros localizados com sucesso.";
            public static final String RESPONSE_200_FIND_BY_ID = "Registros localizados com sucesso.";
            public static final String RESPONSE_204 = "Registro deletado com sucesso.";

            // DESCRIPTIONS
            public static final String DESCRIPTION_FIND_BY_ID = "Recurso para localizar pelo ID.";
            public static final String RESPONSE_DESCRIPTION_FIND_BY_ID = "Registro localizado com sucesso.";
            public static final String DESCRIPTION_FIND_BY_ID_LANGCODE_TRANS = "Recurso para localizar pelo ID, LANG_CODE e TRANS.";
            public static final String RESPONSE_DESCRIPTION_FIND_BY_ID_LANGCODE_TRANS = "Registro localizado com sucesso.";

            public static final String DESCRIPTION_FIND_ALL = "Recurso para listar todos os registros.";
            public static final String DESCRIPTION_SEARCH = "Recurso para pesquisar os registros.";

            // Erros
            public static final String ERROR_403 = "Recurso n\u00E3o permitido ao seu perfil.";
            public static final String ERROR_404 = "Recurso n\u00E3o encontrado";
            public static final String ERROR_409 = "Recurso j\u00E1 registrado no sistema";
            public static final String ERROR_422 = "Recurso n\u00E3o processado por falta de dados ou dados inv\u00E1lidos";
        }
    }

    public interface REPOSITORY {
        public static final String langCodePT = "pt";
        public static final String langCodeEN = "en";
        public static final String langCodeEs = "es";
    }

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";
}
