package br.com.rodrigo.notepad.service;

import br.com.rodrigo.notepad.model.Nota;
import br.com.rodrigo.notepad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {
    @Autowired
    NotaRepository notaRepository;

    public void salvar(Nota nota){
        Nota notas = notaRepository.findByTitulo(nota.getTitulo());
        if(notas != null){
            nota.setId(notas.getId());
        }
        notaRepository.save(nota);
    }

    public Nota buscarNota(String titulo){
        return notaRepository.findByTitulo(titulo);
    }

    public List<Nota> buscarTodos(){
        return notaRepository.findAll();
    }

    public void apagar(String titulo){
        notaRepository.delete(titulo);
    }

    public void apagaTodos(){
        notaRepository.deleteAll();
    }
}
