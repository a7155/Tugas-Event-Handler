
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
public class Kuis {
      public static void main(String[] args) {     
    pembuka();
    boolean lanjut = true;
    int jumSoal = 0;
    int jumBenar = 0;
    int jumSalah = 0;
    int level = 1;
    while (lanjut) {
      jumSoal++;      
      boolean benar = tanyaPenjumlahan(level*5);
      if (benar) {
        System.out.println("jawaban BENAR");
        jumBenar++;
        level++;
      } else {
        jumSalah++;
        System.out.println((char)27+"[01;31m jawaban SALAH "+(char)27+"[00;00m");
      }      
      lanjut = konfirmasi();      
    }    
    penutup(jumSoal,jumBenar,jumSalah);
  }
  static void pembuka() {
    System.out.println("PERMAINAN DIMULAI!");
    System.out.println("Kita akan mulai bermain kuis matematika");
    System.out.println("Jawablah soal-soal perkalian berikut ini");
  }
  static void penutup(int tot,int benar, int salah) {
    System.out.println("PERMAINAN BERAKHIR!");
    System.out.println(" Jawaban benar: "+ benar);
    System.out.println((char)27+"[01;31m Jawaban salah:"+(char)27+"[00;00m "+ salah);
    System.out.println("Total soal: "+ tot);
  }
  static boolean konfirmasi() {
    System.out.println("tekan ENTER untuk melanjutkan, atau tombol lainnya kemudian ENTER untuk menyudahi permainan");    
    Scanner scanner = new Scanner(System.in);
    String readString = scanner.nextLine();
    while(readString!=null) {
        //System.out.println(readString);
        if (readString.isEmpty()) {
            return true;
        }
        return false;
    }
    return false;
  }
  
  static boolean tanyaPenjumlahan(int batasAtas) {    
    int bil1 = ThreadLocalRandom.current().nextInt(2, batasAtas);
    int bil2 = ThreadLocalRandom.current().nextInt(2, batasAtas);
    int kunci = bil1 + bil2;
    System.out.println(bil1+" + " +bil2+ " = ?");
    Scanner scan = new Scanner(System.in);    
    try {
      int jawaban = scan.nextInt();
      if (jawaban == kunci) {
        return true;
      }    
    } catch (Exception x) {
    }        
    return false;
  }
}
