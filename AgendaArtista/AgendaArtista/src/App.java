import eventos.Ensaio;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Ensaio ensaio = new Ensaio(); 
        int opcao;

        do {
            String menu = """
                AGENDA ARTÍSTICA
                1. Cadastrar Ensaio
                2. Consultar Ensaios
                3. Procurar Ensaio
                4. Confirmar Presença
                5. Ver Confirmados
                6. Excluir Ensaio
                7. Sair
                """;

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1 -> ensaio.cadastrar();
                case 2 -> ensaio.obter();
                case 3 -> ensaio.existe();
                case 4 -> ensaio.confirmarPresencaNaLista(); 
                case 5 -> ensaio.verConfirmados();          
                case 6 -> ensaio.excluir();
                case 7 -> JOptionPane.showMessageDialog(null, "Saindo da Agenda Artística...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 7);
    }
}