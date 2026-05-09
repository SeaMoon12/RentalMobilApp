public class Mobil {
    int id;
    String namaMobil;
    int tarfPerHari;

    public Mobil(int id, String namaMobil, int tarifPerHari) {
        this.id = id;
        this.namaMobil = namaMobil;
        this.tarfPerHari = tarifPerHari;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public int getTarfPerHari() {
        return tarfPerHari;
    }
}
