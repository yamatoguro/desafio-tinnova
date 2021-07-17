public interface Fatorial {
    public static int fatorial(int n) {
        return (n == 0) ? 1 : n * fatorial(--n);
    }
}
