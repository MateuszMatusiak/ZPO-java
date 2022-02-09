public class kuchnia {
    private final String garnek;
    private final String kuchenka;
    private final String szklanka;
    private final String kubek;

    public kuchnia(String garnek, String kuchenka, String szklanka, String kubek) {
        this.garnek = garnek;
        this.kuchenka = kuchenka;
        this.szklanka = szklanka;
        this.kubek = kubek;
    }

    public String getGarnek() {
        return garnek;
    }

    public String getSzklanka() {
        return szklanka;
    }
}
