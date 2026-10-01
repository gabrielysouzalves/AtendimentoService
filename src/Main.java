public class Main {
    public static void main(String[] args) {
        System.out.println("-----------Emitindo Senhas ---------");

        PainelAtendimentoService guiche1 = PainelAtendimentoService.getInstancia();

        guiche1.emitirSenha("COMUM", "Ana");
        guiche1.emitirSenha("COMUM", "Eduardo");
        guiche1.emitirSenha("PREFERENCIAL", "Bruno");
        guiche1.emitirSenha("PREFERENCIAL", "Mario");

        System.out.println("\n ------------------ Chamando Senhas ------------------");
        PainelAtendimentoService guiche2 = PainelAtendimentoService.getInstancia();

        guiche2.chamarProximaSenha(2);
        guiche2.chamarProximaSenha(2);
        guiche2.chamarProximaSenha(2);
        guiche2.chamarProximaSenha(2);
    }
}
