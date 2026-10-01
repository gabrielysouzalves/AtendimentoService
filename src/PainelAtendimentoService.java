import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PainelAtendimentoService{
    private static PainelAtendimentoService instancia;

    private List<String> filaComum;
    private List<String> filaPreferencial;
    private int contadorGeral;
    private int contagemPreferenciaisSeguidos;

    public PainelAtendimentoService(){
        this.filaComum = new ArrayList<>();
        this.filaPreferencial = new ArrayList<>();
        this.contagemPreferenciaisSeguidos = 0;
        this.contadorGeral = 0;
    }

    public static PainelAtendimentoService getInstancia(){
        if(instancia == null){
            instancia = new PainelAtendimentoService();
        }
        return instancia;
    }

    public String emitirSenha(String tipoAtendimento, String nomeCliente){
        this.contadorGeral++;
        String ticketformatado = "";

        if (tipoAtendimento.equalsIgnoreCase("COMUM")){
            ticketformatado = "C-" + this.contadorGeral + " / " + nomeCliente.toUpperCase();
            this.filaComum.add(ticketformatado);
        }
        else if (tipoAtendimento.equalsIgnoreCase("PREFERENCIAL")) {
            ticketformatado = "P-" + this.contadorGeral + " / " + nomeCliente.toUpperCase();
            this.filaPreferencial.add(ticketformatado);
        }
        else{
            throw new IllegalArgumentException("Tipo de Atendimento invalido: " + tipoAtendimento);
        }

        System.out.println("Senha emitida com sucesso: " + ticketformatado);
        return ticketformatado;
    }

    public void chamarProximaSenha(int numeroGuiche){
        String proxima = null;

        boolean podeChamarPreferencial = !this.filaPreferencial.isEmpty() && this.contagemPreferenciaisSeguidos < 2;
        if (podeChamarPreferencial){
            proxima = this.filaComum.remove(0);
            this.contagemPreferenciaisSeguidos++;
        }
        else if(!this.filaComum.isEmpty()){
            proxima = this.filaComum.remove((0));
            this.contagemPreferenciaisSeguidos = 0;
        }
        else if(!this.filaPreferencial.isEmpty()){
            proxima = this.filaPreferencial.remove(0);
        }

        if (proxima == null){
            System.out.println("Nenhuma senha aguardando no Guiche " + numeroGuiche);
            return;
        }

        System.out.println("\n----------------------------");
        System.out.println("Painel na TV: " + proxima + " Comparecer ao guiche " + numeroGuiche);
        System.out.println("------------------------------");
    }
}