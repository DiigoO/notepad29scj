package br.com.rodrigo.notepad.controller;

import br.com.rodrigo.notepad.model.Nota;
import br.com.rodrigo.notepad.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "nota")
public class NotaController {

    @Autowired
    public NotaService notaService;

    @GetMapping("/titulo/{titulo}")
    public Nota buscarNota(@PathVariable(value = "titulo") String titulo){
        return notaService.buscarNota(titulo);
    }

    @GetMapping()
    public List<Nota> buscarTodos(){
        return notaService.buscarTodos();
    }

    @DeleteMapping("/titulo/{titulo}")
    public void apagar(@PathVariable(value = "titulo") String titulo){
        notaService.apagar(titulo);
    }

    @DeleteMapping()
    public void apagarTodos(){
        notaService.apagaTodos();
    }

    @PostMapping()
    public void salvar(@RequestBody Nota nota){
        notaService.salvar(nota);
    }

}
