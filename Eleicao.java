public class Eleicao {
    
    private float nEleitores;
    private float votosValidos;
    private float votosBrancos;
    private float votosNulos;

    public String percentualValido() {
        if (this.nEleitores > 0 && this.votosValidos <= this.nEleitores && this.votosValidos >= 0) {
            return calculaPercentual(this.votosValidos);
        }
        return "0%";
    }

    public String percentualBranco() {
        if (this.nEleitores > 0 && this.votosBrancos <= this.nEleitores && this.votosBrancos >= 0) {
            return calculaPercentual(this.votosBrancos);
        }
        return "0%";
    }

    public String percentualNulos() {
        if (this.nEleitores > 0 && this.votosNulos <= this.nEleitores && this.votosNulos >= 0) {
            return calculaPercentual(this.votosNulos);
        }
        return "0%";
    }

    private String calculaPercentual(float votos) {
        return ((votos / this.nEleitores) * 100) + "%";
    }

    // Getters e Setters
    public float getnEleitores() {
        return nEleitores;
    }

    public void setnEleitores(float nEleitores) {
        this.nEleitores = nEleitores;
    }

    public float getVotosValidos() {
        return votosValidos;
    }

    public void setVotosValidos(float votosValidos) {
        this.votosValidos = votosValidos;
    }

    public float getVotosBrancos() {
        return votosBrancos;
    }

    public void setVotosBrancos(float votosBrancos) {
        this.votosBrancos = votosBrancos;
    }

    public float getVotosNulos() {
        return votosNulos;
    }

    public void setVotosNulos(float votosNulos) {
        this.votosNulos = votosNulos;
    }

    
}