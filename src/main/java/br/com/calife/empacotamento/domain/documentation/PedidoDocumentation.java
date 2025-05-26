package br.com.calife.empacotamento.domain.documentation;

import br.com.calife.empacotamento.config.Constants;
import br.com.calife.empacotamento.core.documentation.Documentation;
import br.com.calife.empacotamento.core.http.response.ResponseErrorDTO;
import br.com.calife.empacotamento.domain.entity.DTO.PedidoRequestDTO;
import br.com.calife.empacotamento.domain.entity.DTO.PedidoResponseDTO;
import br.com.calife.empacotamento.domain.entity.Pedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Pedidos", description = "Tudo de Pedidos desta API")
public interface PedidoDocumentation {

    // CREATE
    @Operation(summary = Constants.DOCUMENTATION.MESSAGES.SUMMARY_CREATE, responses = {
            @ApiResponse(responseCode = "201", description = Constants.DOCUMENTATION.MESSAGES.RESPONSE_201, content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = Documentation.GenericResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = Constants.DOCUMENTATION.MESSAGES.ERROR_404, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
            @ApiResponse(responseCode = "403", description = Constants.DOCUMENTATION.MESSAGES.ERROR_403, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
            @ApiResponse(responseCode = "409", description = Constants.DOCUMENTATION.MESSAGES.ERROR_409, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = Constants.DOCUMENTATION.MESSAGES.ERROR_422, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
    })
    ResponseEntity<Pedido> create(@RequestBody @Valid Pedido obj);

    // REQUEST
    @Operation(summary = Constants.DOCUMENTATION.MESSAGES.SUMMARY_FIND_BY_ID, security = @SecurityRequirement(name = "security"), responses = {
            @ApiResponse(responseCode = "200", description = Constants.DOCUMENTATION.MESSAGES.RESPONSE_200_FIND_BY_ID),
            @ApiResponse(responseCode = "404", description = Constants.DOCUMENTATION.MESSAGES.ERROR_404, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
            @ApiResponse(responseCode = "403", description = Constants.DOCUMENTATION.MESSAGES.ERROR_403, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class)))
    })
    ResponseEntity<Pedido> findById(@PathVariable("id") Integer id);

    // DELETE
    @Operation(summary = Constants.DOCUMENTATION.MESSAGES.SUMMARY_DELETE, security = @SecurityRequirement(name = "security"), responses = {
            @ApiResponse(responseCode = "204", description = Constants.DOCUMENTATION.MESSAGES.RESPONSE_204, content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = Documentation.GenericResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = Constants.DOCUMENTATION.MESSAGES.ERROR_404, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
            @ApiResponse(responseCode = "403", description = Constants.DOCUMENTATION.MESSAGES.ERROR_403, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class)))
    })
    void delete(@PathVariable("id") Integer id);

    // UPDATE
    @Operation(summary = Constants.DOCUMENTATION.MESSAGES.SUMMARY_UPDATE, security = @SecurityRequirement(name = "security"), responses = {
            @ApiResponse(responseCode = "200", description = Constants.DOCUMENTATION.MESSAGES.RESPONSE_200_UPDATE, content = @Content(mediaType = "application/json;charset=UTF-8", schema = @Schema(implementation = Documentation.GenericResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = Constants.DOCUMENTATION.MESSAGES.ERROR_404, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
            @ApiResponse(responseCode = "403", description = Constants.DOCUMENTATION.MESSAGES.ERROR_403, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
            @ApiResponse(responseCode = "409", description = Constants.DOCUMENTATION.MESSAGES.ERROR_409, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
            @ApiResponse(responseCode = "422", description = Constants.DOCUMENTATION.MESSAGES.ERROR_422, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
    })
    ResponseEntity<Pedido> update(@RequestBody @Valid Pedido obj);

    @Operation(summary = Constants.DOCUMENTATION.MESSAGES.SUMMARY_SEPARATE_REQUEST, security = @SecurityRequirement(name = "security"), responses = {
            @ApiResponse(responseCode = "200", description = Constants.DOCUMENTATION.MESSAGES.RESPONSE_200_SEPARATE_REQUEST),
            @ApiResponse(responseCode = "404", description = Constants.DOCUMENTATION.MESSAGES.ERROR_404, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
            @ApiResponse(responseCode = "403", description = Constants.DOCUMENTATION.MESSAGES.ERROR_403, content = @Content(mediaType = " application/json;charset=UTF-8", schema = @Schema(implementation = ResponseErrorDTO.class))),
    })
    ResponseEntity<List<PedidoResponseDTO>> separarPedido(@RequestBody PedidoRequestDTO obj);

}