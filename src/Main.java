import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len;
        String[] elements;

        while (true) {
            System.out.print("Masukkan panjang array: ");
            try {
                len = scanner.nextInt(); // input ukuran array
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input hanya menerima angka."); // pesan error jika user input bukan angka
                scanner.next(); // clear buffer dari input yang salah
            }
        }

        int[] numbers = new int[len]; // inisialisasi array<int> dengan ukuran sesuai variabel len
        scanner.nextLine(); // clear buffer scanner dari input sebelumnya

        while (true) {
            System.out.print("Masukkan elemen array (" + len + " angka dipisahkan spasi): ");
            try {
                elements = scanner.nextLine().trim().replaceAll(" +", " ").split(" "); // input element array dan dipisahkan berdasarkan spasi dan menghapus spasi jika ada spasi tambahan
                System.out.println(Arrays.toString(elements)); // tampilan element dalam bentuk array
                insertThenSortArray(elements, numbers); // masukkan element ke array numbers
                if (elements.length == numbers.length) {
                    break; // keluar dari looping jika ukuran array<String> == array<int>
                } else if (elements.length < numbers.length) {
                    System.out.println("Jumlah angka yang diinput kurang dari ukuran array yang ditentukan."); // pesan error jika ukuran array<String> < ukuran array<int>
                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Jumlah angka yang diinput melebihi ukuran array yang ditentukan."); // pesan error jika ukuran array<String> > ukuran array<int>
            } catch (NumberFormatException e) {
                System.out.println("Hanya menerima input angka."); // pesan error jika ukuran array<String> > ukuran array<int>
            }
        }

        System.out.println("\nJumlah pasangan nilai unik yang ditemukan: " + countUniqueNumber(numbers)); // output jumlah pasangan bilangan unik
        scanner.close(); // tutup objek scanner
    }

    private static int[] insertThenSortArray(String[] str, int[] arr) {
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]); // assign value element yang diinput ke array<int>
        }

        Arrays.sort(arr); // proses sorting element dari array<int>

        return arr; // return array<int> setelah sorting
    }

    private static int countUniqueNumber(int[] arr) {
        int count = 0; // inisialisasi nilai count

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) count++; // +1 untuk variabel count jika angka ke i != angka ke i+1
        }

        return count; // return nilai count
    }
}