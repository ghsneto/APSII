package br.unipe.cadastromoveis.repository;

import br.unipe.cadastromoveis.model.Movel;
import java.util.List;

public interface MovelRepository {

    void salvar(Movel movel);

    List<Movel> listarTodos();

    Movel buscarPorId(int id);

    boolean remover(int id);
}
