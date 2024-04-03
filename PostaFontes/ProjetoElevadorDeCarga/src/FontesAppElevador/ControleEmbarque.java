package FontesAppElevador;

public class ControleEmbarque {

	//Embarcar pessoa no elevador
	public boolean embarcar(Pessoa pessoa, Elevador elevador) {
	
		double pesoFinalElevador = elevador.entrarNoelevador(pessoa.getPeso());
		
		boolean alarmeAcesso =elevador.avaliarpeso(pesoFinalElevador);
		if (alarmeAcesso == false) {
			//Se o alarme for FALSE (não ativado),
			//retorna confirmação de embarque TRUE
			return true;
		}
		else {
			//Se o alarme for TRUE (ativado),
			//retorna bloqueio de acionamento do elevador 
			//(retorna FALSE para a confirmação de embarque)
			return false;
		}

	}
	
}
