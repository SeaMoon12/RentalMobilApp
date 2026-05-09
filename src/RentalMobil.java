import java.util.ArrayList;

public class RentalMobil {

    private static final double DISKON = 0.1; // 10% discount for rentals over 7 days
    private static final double DISKON_TAMBAHAN = 0.01; // additional 1% discunt for every one day more than 7.
    private static final int BIAYA_TERLAMBAT_PER_HARI = 100000;
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
        System.out.println("Cars:");
        for (Mobil mobil : daftarMobil) {
            if (mobil.available) {
                System.out.println(mobil.id + ". " + mobil.getNamaMobil() + " - Rp " + mobil.getTarfPerHari() + " per day");
            } else {
                System.out.println(mobil.id + ". " + mobil.getNamaMobil() + " - Rp " + mobil.getTarfPerHari() + " per day (Rented)");
            }
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

    public void tampilkanStruk(ArrayList<Integer> mobilId, ArrayList<Integer> durasi, ArrayList<Integer> durasiTerlambat, int payMethod) {
        String paymentMethod;
        double totalBiaya = 0;

        System.out.println("\n=== PAYMENT RECEIPT ===");

        for (int i = 0; i < mobilId.size(); i++)
        {
            int biayaTerlambat;
            double biayaMobil = hitungBiaya(mobilId.get(i), durasi.get(i));
            Mobil mobil = daftarMobil[mobilId.get(i) - 1];

            if (durasiTerlambat.get(i) < 0) {
                biayaTerlambat = 0;
            } else {
                biayaTerlambat = durasiTerlambat.get(i) * BIAYA_TERLAMBAT_PER_HARI;
            }

            System.out.println("Selected Car: " + mobil.getNamaMobil());
            System.out.println("Rental Duration: " + durasi.get(i) + " days");
            System.out.println("Late return by " + durasiTerlambat.get(i) + " day(s)");
            System.out.println("Fine: " + biayaTerlambat);
            System.out.println("Total Car Rental Cost (including fine): Rp " + (biayaMobil + biayaTerlambat) + "\n");
            totalBiaya += (biayaMobil + biayaTerlambat);
        }

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

        System.out.println("Total Payment: " + totalBiaya);
        System.out.println("Payment: " + paymentMethod);
    }

    public int getDaftarMobilLength() {
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

    public void makeUnavailable(int mobilId) {
        for (Mobil mobil : daftarMobil) {
            if (mobilId == mobil.id) {
                mobil.available = false;
                return;
            }
        }
        System.out.println("Error: Car with ID " + mobilId + " not found!");
    }

    public boolean getMobilAvailability(int id) {
        return daftarMobil[id - 1].available;
    }

    public boolean getDaftarAvailability() {
        for (Mobil mobil : daftarMobil) {
            if (mobil.available) {
                return true;
            }
        }
        return false;
    }

    public void tampilkanRentalHistory(ArrayList<Integer> mobilIdRentals, ArrayList<Integer> durasiRentals) {
        if (mobilIdRentals.isEmpty()) {
            System.out.println("No rentals yet.");
            return;
        }
        for (int i = 0; i < mobilIdRentals.size(); i++) {
            int mobilId = mobilIdRentals.get(i);
            int durasi = durasiRentals.get(i);
            double biaya = hitungBiaya(mobilId, durasi);
            Mobil mobil = daftarMobil[mobilId - 1];
            System.out.println("Car: " + mobil.getNamaMobil() + ", Duration: " + durasi + " days, Base Price: Rp " + biaya);
        }
    }
}
