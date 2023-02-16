package service;

import model.Bicicleta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
// import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BicicletaServiceImplTest {

    private BicicletaServiceImpl service;

    @Mock
    private BicicletaRepositorio repositorio;

    @BeforeEach
    public void setUp() {
        openMocks(this);
        service = new BicicletaServiceImpl(repositorio);
    }

    private void openMocks(BicicletaServiceImplTest bicicletaServiceImplTest) {
    }

    @Test
    public void deveCriarBicicleta() throws Exception {
        //given (dado)
        Bicicleta bicicletaCriada = service.criarBicicleta("Caloi", 21, false, 0, 100);

        //when (quando)

        //then (então)
        Assertions.assertNotNull(bicicletaCriada);
        assertEquals("Caloi", bicicletaCriada.getModelo());
        assertEquals(21, bicicletaCriada.getNumMarchas());
        Assertions.assertFalse(bicicletaCriada.isEletrica());
    }

    @Test
    public void deveBuscarBicicletas() throws Exception {
        //given (dado)
        Bicicleta bicicleta1 = service.criarBicicleta("Caloi", 21, false, 0, 100);
        Bicicleta bicicleta2 = service.criarBicicleta("Monark", 12, true, 0, 100);

        //when (quando)
        List<Bicicleta> bicicletasEncontradas = service.buscarTodasBicicletas();

        //then (então)
        Assertions.assertNotNull(bicicletasEncontradas);
        assertEquals(2, bicicletasEncontradas.size());
        Assertions.assertFalse(bicicleta1.isEletrica());
    }

    @Test
    public void deveBuscarBicicletaPorIdInexistente() {
        //given (dado)
        Bicicleta bicicletaEncontrada = service.buscarBicicletaPorId(999L);

        //when (quando)

        //then (então)
        Assertions.assertNull(bicicletaEncontrada);
    }

    @Test
    public void deveCriarBicicletaComModeloNulo() throws Exception{
        //given (dado)

        //when (quando)

        //then (então)
        Assertions.assertThrows(Exception.class, () -> {
            service.criarBicicleta(null, 21, false, 0, 100);
        });
    }

    @Test
    public void deveCriarBicicletaComNumeroDeMarchasNegativo() throws Exception{
        //given (dado)

        //when (quando)

        //then (então)
        Assertions.assertThrows(Exception.class, () -> {
            service.criarBicicleta("Caloi", -5, false, 0, 100);
        });
    }

    @Test
    public void deveGanharVelocidadeNormalmente() throws Exception {
        //given (dado)
        Bicicleta bicicletaCriada = service.criarBicicleta("Caloi", 21, false, 0, 100);

        //when (quando)
        bicicletaCriada.pedalar(bicicletaCriada, 30);

        //then (então)
        Assertions.assertEquals(30, bicicletaCriada.getVelocidadeAtual());
        Assertions.assertSame(bicicletaCriada, bicicletaCriada);
    }

    @Test
    public void deveFrearComSucesso() throws Exception{
        //given (dado)
        Bicicleta bicicletaCriada = service.criarBicicleta("Monark", 12, true, 50, 100);

        //when (quando)
        bicicletaCriada.frear(bicicletaCriada, 50);

        //then (então)
        assertEquals(0, bicicletaCriada.getVelocidadeAtual());
        assertTrue(bicicletaCriada.isEletrica());
    }

}