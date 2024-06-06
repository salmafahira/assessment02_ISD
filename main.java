import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

class antrian {
    static int idAntri;
    static String namaPasien;
    static int usia;
    String kodeEr;
    protected Object urutanSelesai;

    public antrian(int idAntri, String namaPasien, int usia, String kodeEr) {
        this.idAntri = idAntri;
        this.namaPasien = namaPasien;
        this.usia = usia;
        this.kodeEr = kodeEr;
    }

    private int setLamaAntri() {
        switch (kodeEr) {
            case "Hijau":
                return 0;
            case "Biru":
                return 2;
            case "Kuning":
                return 1;
            case "Merah":
                return 0;
            default:
                throw new IllegalArgumentException("Kode tidak valid");
        }
    }

//     private Date setTanggalSelesai() {
//         long millis = antrianMasuk.getTime() + TimeUnit.DAYS.toMillis(lamaAntri);
//         return new Date(millis);
//     }
// }

class Pasien {
    List<Pasien> daftarAntrian;

    public Pasien() {
        daftarAntrian = new ArrayList<>();
    }

    public void terimaAntrian(int idAntri, String namaPasien, String kodeEr, int usia) {
        try {
            String antrianMasuk;
            antrian antrianBaru = new antrian(idAntri, namaPasien, usia, kodeEr);
            antrianBaru.add(antrianBaru);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pasien> urutanAntrian() {
        Collections.sort(daftarAntrian, new Comparator<antrian>() {
            public int compare(antrian c1, antrian c2) {
                int dateCompare = ((Date) c1.urutanSelesai).compareTo((Date)c2.urutanSelesai);
                if (dateCompare == 0) {
                    return Integer.compare(c1.idAntri, c2.idAntri);
                }
                return dateCompare;
            }
        });
        return daftarAntrian;
    }


    public void tampilkanUrutan() {
        List<antrian.Pasien> urutan = urutanAntrian();
        System.out.println("Urutan Penanganan Pasien:");
        for (antrian.Pasien Antrian : urutan) {
            System.out.println("namaPasien = " + antrian.namaPasien + ", Usia = " + antrian.usia);
        }
    }
}

public class main {
    public static void main(String[] args) {
        Pasien daftarAntrian = new antrian();
        daftarAntrian.terimaAntrian(1, "Nur Aisyah", "Biru", 30);
        daftarAntrian.terimaAntrian(2, "Rima", "Merah", 20);
        daftarAntrian.terimaAntrian(3, "Kira", "Hijau", 10);
        daftarAntrian.terimaAntrian(4, "Didi", "Kuning", 5);
        daftarAntrian.terimaAntrian(5, "Mila", "Biru", 65);

        daftarAntrian.tampilkanUrutan();
    }
}

public void add(antrian antrianBaru) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'add'");
}
}