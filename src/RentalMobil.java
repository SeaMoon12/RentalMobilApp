public class RentalMobil {

    private static final double DISKON = 0.1; // 10% discount for rentals over 7 days
    private Mobil[] daftarMobil;

    public RentalMobil() {
        daftarMobil = new Mobil[] {
                new Mobil(1, "Toyota Avanza", 500000),
                new Mobil(2, "Honda Civic", 700000),
                new Mobil(3, "BMW X5", 1000000),
                new Mobil(4, "Suzuki Swift", 350000)
        };
    }

    public void tampilkanMobil() {
        System.out.println("Available Cars:");
        for (Mobil mobil : daftarMobil) {
            System.out.println(mobil.id + ". " + mobil.getNamaMobil() + " - Rp " + mobil.getTarfPerHari() + " per day");
        }
    }

    public double hitungBiaya(int mobilId, int durasi) {
        Mobil mobilDipilih = daftarMobil[mobilId - 1];
        double totalHarga = mobilDipilih.getTarfPerHari() * durasi;

        if (durasi > 7) {
            totalHarga = totalHarga - (totalHarga * DISKON);
        }

        return totalHarga;
    }

    public void tampilkanStruk(int mobilId, int durasi) {
        double totalBiaya = hitungBiaya(mobilId, durasi);
        Mobil mobil = daftarMobil[mobilId - 1];

        System.out.println("\n=== PAYMENT RECEIPT ===");
        System.out.println("Selected Car: " + mobil.getNamaMobil());
        System.out.println("Rental Duration: " + durasi + " days");
        System.out.println("Total Cost: Rp " + totalBiaya);
    }
}
