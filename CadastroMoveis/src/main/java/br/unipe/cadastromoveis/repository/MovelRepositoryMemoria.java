package br.unipe.cadastromoveis.repository;

import br.unipe.cadastromoveis.model.Movel;
import java.util.ArrayList;
import java.util.List;

public class MovelRepositoryMemoria implements MovelRepository {

    private static MovelRepositoryMemoria instancia;

    private final List<Movel> moveis = new ArrayList<>();
    private int proximoId = 1;

    private MovelRepositoryMemoria() {
    }

    public static synchronized MovelRepositoryMemoria getInstancia() {
        if (instancia == null) {
            instancia = new MovelRepositoryMemoria();
        }
        return instancia;
    }

    @Override
    public void salvar(Movel movel) {
        movel.setId(proximoId++);
        moveis.add(movel);
    }

    @Override
    public List<Movel> listarTodos() {
        return new ArrayList<>(moveis);
    }

    @Override
    public Movel buscarPorId(int id) {
        for (Movel movel : moveis) {
            if (movel.getId() == id) {
                return movel;
            }
        }
        return null;
    }

    @Override
    public boolean remover(int id) {
        Movel movel = buscarPorId(id);
        if (movel == null) {
            return false;
        }
        return moveis.remove(movel);
    }
}
