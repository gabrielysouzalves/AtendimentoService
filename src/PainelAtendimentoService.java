import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PainelAtendimentoService{
    private List<String> filaSenhas;
    private int contadorGeral;

    public PainelAtendimentoService(){
        this.filaSenhas = new ArrayList<>();
        this.contadorGeral = 0;
    }

    public String emitirSenha(String tipoAtendimento, String nomeCliente){
        this.contadorGeral++;
        String ticketformatado = "";

        if (tipoAtendimento.equalsIgnoreCase("COMUM")){
            ticketformatado = "C-" + this.contadorGeral + " / " + nomeCliente.toUpperCase();
        }
        else if (tipoAtendimento.equalsIgnoreCase("PREFERENCIAL")){
            ticketformatado = "P-" + this.contadorGeral + " / " + nomeCliente.toUpperCase();
        }
        else if (tipoAtendimento.equalsIgnoreCase("EMERGENCIA")){
            ticketformatado = "Emerg- " + this.contadorGeral + " / " + nomeCliente.toUpperCase();
        }
        else{
            throw new IllegalArgumentException("Tipo de Atendimento invalido: " + tipoAtendimento);
        }

        this.filaSenhas.add(ticketformatado);
        System.out.println("Senha emitida com sucesso: " + ticketformatado);
        return ticketformatado;
    }

    public void chamarProximaSenha(int numeroGuiche){
        if (this.filaSenhas.isEmpty()){
            System.out.println("Guiche " + numeroGuiche + " : Nenhuma senha na fila de espera.");
            return;
        }

        String proxima = this.filaSenhas.remove(0);;

        System.out.println("\n----------------------------");
        System.out.println("Painel na TV: " + proxima + "Comparecer ao guiche " + numeroGuiche);
        System.out.println("------------------------------");
    }
}