public class arvore {
    private alunos raiz;

    public void inserir(int rgm, String nome) {
        raiz = inserirrec(raiz, rgm, nome);
    }

    private alunos inserirrec(alunos raiz, int rgm, String nome) {
        if (raiz == null) return new alunos(rgm, nome);
        if (rgm < raiz.rgm) raiz.esquerda = inserirrec(raiz.esquerda, rgm, nome);
        else if (rgm > raiz.rgm) raiz.direita = inserirrec(raiz.direita, rgm, nome);
        else System.out.println("RGM já existe!");
        return raiz;
    }

    public alunos pesquisar(int rgm) {
        return pesquisarec(raiz, rgm);
    }
    private alunos pesquisarec(alunos raiz, int rgm) {

        if (raiz == null) {
            return null;
        }

        if (raiz.rgm == rgm) {
            return raiz;
        }

        if (rgm < raiz.rgm) {
            return this.pesquisarec(raiz.esquerda, rgm);
        }

        else {
            return this.pesquisarec(raiz.direita, rgm);
        }
    }

    public void remover(int rgm) {
        raiz = removerrec(raiz, rgm);
    }

    private alunos removerrec(alunos raiz, int rgm) {
        if (raiz == null) {
            System.out.println("RGM não encontrado!");
            return null;
        }
        if (rgm < raiz.rgm) raiz.esquerda = removerrec(raiz.esquerda, rgm);
        else if (rgm > raiz.rgm) raiz.direita = removerrec(raiz.direita, rgm);
        else {
            System.out.println("Removido: " + raiz.rgm + " - " + raiz.nome);
            if (raiz.esquerda == null) return raiz.direita;
            else if (raiz.direita == null) return raiz.esquerda;

            alunos sucessor = menorvalor(raiz.direita);
            raiz.rgm = sucessor.rgm;
            raiz.nome = sucessor.nome;
            raiz.direita = removerrec(raiz.direita, sucessor.rgm);
        }
        return raiz;
    }

    private alunos menorvalor(alunos raiz) {
        while (raiz.esquerda != null) raiz = raiz.esquerda;
        return raiz;
    }

    public void esvaziar() {
        raiz = null;
        System.out.println("Árvore esvaziada!");
    }

    public void exibirpreordem() {
        preordem(raiz);
        System.out.println();
    }

    public void exibirinordem() {
        inordem(raiz);
        System.out.println();
    }

    public void exibirposordem() {
        posordem(raiz);
        System.out.println();
    }

    private void preordem(alunos raiz) {
        if (raiz != null) {
            System.out.println(raiz.rgm + " - " + raiz.nome);
            preordem(raiz.esquerda);
            preordem(raiz.direita);
        }
    }

    private void inordem(alunos raiz) {
        if (raiz != null) {
            inordem(raiz.esquerda);
            System.out.println(raiz.rgm + " - " + raiz.nome);
            inordem(raiz.direita);
        }
    }

    private void posordem(alunos raiz) {
        if (raiz != null) {
            posordem(raiz.esquerda);
            posordem(raiz.direita);
            System.out.println(raiz.rgm + " - " + raiz.nome);
        }
    }
}