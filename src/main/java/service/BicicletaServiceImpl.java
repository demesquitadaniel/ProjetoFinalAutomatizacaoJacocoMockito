package service;

import model.Bicicleta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BicicletaServiceImpl implements BicicletaService {

    private Map<Long, Bicicleta> bicicletas = new HashMap<>();
    private Long proximoId = 1L;
    private Bicicleta bicicleta;
    private double velocidadeMenos;
    private double velocidadeMais;

    public <BicicletaRepository> BicicletaServiceImpl(BicicletaRepository repository) {

    }

    @Override
    public Bicicleta criarBicicleta(String modelo, int numMarchas, boolean eletrica, double velocidadeAtual, double velocidadeMaxima) throws Exception{
        Bicicleta bicicleta = new Bicicleta(proximoId, modelo, numMarchas, eletrica, 0, 100);
        bicicletas.put(proximoId, bicicleta);
        proximoId++;
        if ((numMarchas <= 0) || (modelo == null)) {
            throw new Exception("Erro! Nr de marchas OU modelo inválidos");
        } else {
            return bicicleta;
        }
    }

    @Override
    public Bicicleta buscarBicicletaPorId(Long id) {
        return bicicletas.get(id);
    }

    @Override
    public List<Bicicleta> buscarTodasBicicletas() {
        return new ArrayList<>(bicicletas.values());
    }

    @Override
    public Bicicleta pedalar(Bicicleta bicicleta, int velocidadeMais) {
        bicicleta.setVelocidadeAtual(bicicleta.getVelocidadeAtual() + velocidadeMais);
        return bicicleta;
    }

    @Override
    public Bicicleta frear(Bicicleta bicicleta, int velocidadeMenos) {
        bicicleta.setVelocidadeAtual(bicicleta.getVelocidadeAtual() - velocidadeMenos);
        return bicicleta;
    }
}
