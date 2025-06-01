public class alunos {
    int rgm;
    String nome;
    alunos esquerda;
    alunos direita;

    public alunos(int rgm, String nome) {
        this.rgm = rgm;
        this.nome = nome;
        this.esquerda = null;
        this.direita = null;
    }
}
