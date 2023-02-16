package service;

import model.Bicicleta;

import java.util.List;

public interface BicicletaService {
    Bicicleta criarBicicleta(String modelo, int numMarchas, boolean eletrica, double velocidadeAtual, double velocidadeMaxima) throws Exception;
    Bicicleta buscarBicicletaPorId(Long id);
    List<Bicicleta> buscarTodasBicicletas();
    Bicicleta pedalar(Bicicleta bicicleta, int velocidadeMais);
    Bicicleta frear(Bicicleta bicicleta, int velocidadeMenos);
}
