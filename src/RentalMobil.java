public class RentalMobil {

    private static final double DISKON = 0.1; // 10% discount for rentals over 7 days
    private static final double DISKON_TAMBAHAN = 0.01; // additional 1% discunt for every one day more than 7.
    private Mobil[] daftarMobil;

    public RentalMobil() {
        daftarMobil = new Mobil[] {
                new Mobil(1, "Toyota Avanza", 500000),
                new Mobil(2, "Honda Civic", 700000),
                new Mobil(3, "BMW X5", 1000000),
                new Mobil(4, "Suzuki Swift", 350000),
                new Mobil(5, "Honda CRV", 600000)
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
            double diskonTotal = DISKON + hitungDiskonTambahan(durasi - 7);
            totalHarga = totalHarga - (totalHarga * diskonTotal);
        }

        return totalHarga;
    }

    public void tampilkanStruk(int mobilId, int durasi, int payMethod) {
        double totalBiaya = hitungBiaya(mobilId, durasi);
        String paymentMethod;
        Mobil mobil = daftarMobil[mobilId - 1];

        switch (payMethod) {
            case 1:
                paymentMethod = "Cash";
                break;
            case 2:
                paymentMethod = "Credit Card";
                break;
            default:
                paymentMethod = "Unknown";
        }

        System.out.println("\n=== PAYMENT RECEIPT ===");
        System.out.println("Selected Car: " + mobil.getNamaMobil());
        System.out.println("Rental Duration: " + durasi + " days");
        System.out.println("Total Cost: Rp " + totalBiaya);
        System.out.println("Payment: " + paymentMethod);
    }

    public int getDafterMobilLength() {
        return daftarMobil.length;
    }

    public double hitungDiskonTambahan(int sisaDurasi) {
        // additonal 1% discount for every one additional day

        if (sisaDurasi == 0) {
            return 0;
        }

        double diskon = DISKON_TAMBAHAN + hitungDiskonTambahan(sisaDurasi - 1);

        return diskon;
    }
}
