public interface BubbleSort {
    public static void ordenar(int[] lista, int tam) {
        if (tam == 1)
            return;
        for (int i = 0; i < tam - 1; i++) {
            if (lista[i] > lista[i + 1]) {
                int a = lista[i];
                lista[i] = lista[i + 1];
                lista[i + 1] = a;
            }
        }
        ordenar(lista, --tam);
    }
}