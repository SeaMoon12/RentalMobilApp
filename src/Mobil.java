public class Mobil {
    int id;
    String namaMobil;
    int tarfPerHari;
    boolean available;

    public Mobil(int id, String namaMobil, int tarifPerHari) {
        this.id = id;
        this.namaMobil = namaMobil;
        this.tarfPerHari = tarifPerHari;
        this.available = true;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public int getTarfPerHari() {
        return tarfPerHari;
    }
}
