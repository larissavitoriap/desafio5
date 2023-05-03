package br.com.edusync.jpa.Controllers;

import br.com.edusync.jpa.Models.EstoqueMovimento;
import br.com.edusync.jpa.Models.FuncionarioResponsavel;
import br.com.edusync.jpa.services.EstoqueMovimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstoqueMovimentoController {

    private EstoqueMovimentoService estoqueMovimentoService;


    //adicionar
    @GetMapping(value = "/adicionar/estoque")
    public ResponseEntity novoEstoque(@RequestBody EstoqueMovimento estoqueMovimento) {
        return new ResponseEntity(estoqueMovimento, HttpStatus.CREATED);
    }
    //listar
    @GetMapping(value = "/listar")
    public ResponseEntity listarTodosFuncionario() {
        return new ResponseEntity(estoqueMovimentoService.listarTudo(), HttpStatus.OK);
    }

    public ResponseEntity listarHistoricoEstoque(Integer codigo){
        return new ResponseEntity(estoqueMovimentoService.listarHistoricoEstoque(codigo),HttpStatus.OK);
    }

    //deletar
    @DeleteMapping
    public ResponseEntity deletar(@PathVariable Integer codigo) {
        estoqueMovimentoService.remover(codigo);
        return new ResponseEntity(HttpStatus.OK);


    }
    //alterar


    @PutMapping(value = "/atualizar/{codigo}")
    public ResponseEntity atualizarEstoque(@PathVariable Integer codigo, @RequestBody EstoqueMovimento estoqueMovimento){
        estoqueMovimentoService.update(codigo, estoqueMovimento);
        return new ResponseEntity(codigo, HttpStatus.OK);
    }
}
