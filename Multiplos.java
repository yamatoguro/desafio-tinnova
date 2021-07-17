public interface Multiplos {
    public static int somarMultiplos(int n) {
        int resultado = 0, i = 0;
        while(i < n) {
            resultado += (i%5 == 0 || i%3 == 0) ? i : 0;
            i++;
        }
        return resultado;
    }
}
