package br.edu.infnet.tp3jdbccrud.service;

import br.edu.infnet.tp3jdbccrud.model.Fornecedor;
import br.edu.infnet.tp3jdbccrud.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor create(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor getById(Long id) {
        return fornecedorRepository.findById(id);
    }

    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor update(Fornecedor fornecedor) {
        return fornecedorRepository.update(fornecedor);
    }

    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
