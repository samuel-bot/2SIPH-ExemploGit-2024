package TestesAppElevador;

import FontesAppElevador.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElevadorTeste {

	Elevador elevadorX = new Elevador();

	//Inicialização da Carga Atual do elevador
	@Before
	public void setUp() throws Exception {
		elevadorX.setId(1);
		elevadorX.setCargaAtual(0);
		elevadorX.setCargaMaxima(200);
	}

	//Teste de entrada de uma pessoa no elevador
	@Test
	public void testeIncrementarPessoaCom100Kg() {
		elevadorX.entrarNoelevador(100);
		assertEquals(elevadorX.getCargaAtual(), 100, 0);
	}

	//Teste de entrada de duas pessoas na sequência, no elevador
	@Test
	public void testeIncrementarPessoaCom50KgMaisOutraDe100Kg() {
		elevadorX.entrarNoelevador(50);
		elevadorX.entrarNoelevador(100);
		assertEquals(elevadorX.getCargaAtual(), 150, 0);
	}
	
	@Test
	public void testeRetirarPessoaCom80KgDepoisdeEmbarcarPessoaCom100Kg() {
		elevadorX.entrarNoelevador(100);
		elevadorX.sairDoelevador(80);
		assertEquals(elevadorX.getCargaAtual(), 20, 0);
	}
	
	//Teste de alerta da entrada de duas pessoas com peso que não excede a capacidade do elevador
	@Test
	public void testeAlertaPessoaCom50KgMaisOutraDe100Kg() {
		elevadorX.setCargaAtual(50);
		elevadorX.entrarNoelevador(100);
		boolean alerta = elevadorX.avaliarpeso(elevadorX.getCargaAtual());
		assertFalse(alerta);
	}
	
	//Teste de alerta da entrada de duas pessoas com peso que excede a capacidade do elevador
	@Test
	public void testeAlertaPessoaCom120KgMaisOutraDe100Kg() {
		elevadorX.entrarNoelevador(120);
		elevadorX.entrarNoelevador(100);
		boolean alerta = elevadorX.avaliarpeso(elevadorX.getCargaAtual());
		assertTrue(alerta);
	}

}
