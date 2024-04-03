package TestesAppElevador;
import FontesAppElevador.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControleEmbarqueTeste {


	ControleEmbarque controleEmbarque = new ControleEmbarque();
	Elevador elevadorX = new Elevador();
	Pessoa pessoa = new Pessoa();
	
@Before
	public void setupElevador() {
		elevadorX.setId(1);
		elevadorX.setCargaAtual(180);
		elevadorX.setCargaMaxima(200);
}


@Test
	public void testeEmbarcarPessoa100Kg() {
		pessoa.setNome("Pedro");
		pessoa.setPeso(100);
		boolean resultado = controleEmbarque.embarcar(pessoa,elevadorX);
		assertEquals(resultado, false);
	}

@Test
	public void testeEmbarcarPessoa15Kg() {
		pessoa.setNome("Mario");
		pessoa.setPeso(15);
		boolean resultado = controleEmbarque.embarcar(pessoa, elevadorX);
		assertEquals(resultado, true);
	}

}
