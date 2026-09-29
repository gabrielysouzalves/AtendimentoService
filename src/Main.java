public class Main {
    public static void main(String[] args){
        PainelAtendimentoService guiche1 = new PainelAtendimentoService();
        guiche1.emitirSenha("COMUM", "Carlos");
        guiche1.emitirSenha("PREFERENCIAL","Maria Aparecida");

        PainelAtendimentoService guiche2 = new PainelAtendimentoService();
        guiche2.emitirSenha("COMUM", "João");
    }
}
