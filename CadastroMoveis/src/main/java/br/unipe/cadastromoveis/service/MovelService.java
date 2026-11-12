package br.unipe.cadastromoveis.service;

import br.unipe.cadastromoveis.model.Movel;
import br.unipe.cadastromoveis.repository.MovelRepository;
import java.util.List;

public class MovelService {

    private final MovelRepository repository;

    public MovelService(MovelRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Movel movel) {
        if (movel.getNome() == null || movel.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do movel e obrigatorio.");
        }
        if (movel.getPreco() <= 0) {
            throw new IllegalArgumentException("O preco deve ser maior que zero.");
        }
        repository.salvar(movel);
    }

    public List<Movel> listar() {
        return repository.listarTodos();
    }

    public Movel buscar(int id) {
        return repository.buscarPorId(id);
    }

    public boolean remover(int id) {
        return repository.remover(id);
    }
}
