package eventos;

import interfaces.ConfirmacaoPresenca;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Ensaio extends Compromisso implements ConfirmacaoPresenca {

    private String instrumento;
    ArrayList<Ensaio> listaEnsaios = new ArrayList<>();
    private ArrayList<String> listaConfirmados = new ArrayList<>();

    public Ensaio() {
        super();
        instrumento = "";
    }

    public Ensaio(String data, String local, int duracao, String instrumento) {
        super(data, local, duracao);
        this.instrumento = instrumento;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public void cadastrar() {
        String data = JOptionPane.showInputDialog("Digite a data do ensaio:");
        String local = JOptionPane.showInputDialog("Digite o local do ensaio:");
        int duracao = Integer.parseInt(JOptionPane.showInputDialog("Digite a duração (min):"));
        String instrumento = JOptionPane.showInputDialog("Digite o instrumento:");

        listaEnsaios.add(new Ensaio(data, local, duracao, instrumento));
        JOptionPane.showMessageDialog(null, "Ensaio cadastrado com sucesso!");
    }

    public boolean obter() {
        if (listaEnsaios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum ensaio cadastrado.");
            return false;
        }

        for (Ensaio e : listaEnsaios) {
            e.detalhesDoEvento();
        }

        return true;
    }

    public boolean existe() {
        String procurar = JOptionPane.showInputDialog("Procurar ensaio de qual instrumento?");
        for (Ensaio e : listaEnsaios) {
            if (e.getInstrumento().equalsIgnoreCase(procurar)) {
                JOptionPane.showMessageDialog(null, "Ensaio encontrado: " + e.getInstrumento());
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Ensaio não encontrado.");
        return false;
    }

    public boolean excluir() {
        String excluir = JOptionPane.showInputDialog("Excluir ensaio de qual instrumento?");
        for (Ensaio e : listaEnsaios) {
            if (e.getInstrumento().equalsIgnoreCase(excluir)) {
                listaEnsaios.remove(e);
                JOptionPane.showMessageDialog(null, "Ensaio excluído: " + e.getInstrumento());
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Ensaio não encontrado.");
        return false;
    }

    public boolean confirmar() {
        String nome = JOptionPane.showInputDialog("Digite seu nome para confirmar presença:");
        if (nome != null && nome.length() > 2) {
            listaConfirmados.add(nome);
            JOptionPane.showMessageDialog(null, nome + ", presença confirmada!");
            return true;
        }
        JOptionPane.showMessageDialog(null, "Nome inválido.");
        return false;
    }
    
    public void confirmarPresencaNaLista() {
        if (listaEnsaios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum ensaio para confirmar presença.");
        } else {
            String instrumentoBusca = JOptionPane.showInputDialog("Confirmar presença em qual instrumento?");
            boolean encontrado = false;

            for (Ensaio e : listaEnsaios) {
                if (e.getInstrumento().equalsIgnoreCase(instrumentoBusca)) {
                    e.confirmar();
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Ensaio não encontrado.");
            }
        }
    }


    public void verConfirmados() {
        String instrumentoBusca = JOptionPane.showInputDialog("Ver confirmações de qual instrumento?");
        for (Ensaio e : listaEnsaios) {
            if (e.getInstrumento().equalsIgnoreCase(instrumentoBusca)) {
                if (e.listaConfirmados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ninguém confirmou presença neste ensaio.");
                } else {
                    String nomes = "";
                    for (String nome : e.listaConfirmados) {
                        nomes += nome + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "Confirmados neste ensaio:\n" + nomes);
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Ensaio não encontrado.");
    }

    public void detalhesDoEvento() {
        JOptionPane.showMessageDialog(null,
            "Data: " + getData() +
            "\nLocal: " + getLocal() +
            "\nDuração: " + getDuracao() + " min" +
            "\nInstrumento: " + getInstrumento());
    }

    public ArrayList<Ensaio> getListaEnsaios() {
        return listaEnsaios;
    }


}