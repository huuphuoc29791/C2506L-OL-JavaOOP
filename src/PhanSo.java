
import java.util.Scanner;

public class PhanSo {
    // Attributes - Thuộc tính
    public int tuSo;
    public int mauSo;

    // Methods - Phương thức
    //// Default constructor - Phương thức khởi tạo mặc định
    public PhanSo() {
        tuSo = 0;
        mauSo = 1;
    }

    //// Parameterized constructor - Phương thức khởi tạo kèm tham số
    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    public void nhap(Scanner scanner) {
        do {
            tuSo = scanner.nextInt();
            mauSo = scanner.nextInt();
            if (mauSo == 0) {
                System.out.print("Mẫu số phải khác 0. Vui lòng nhập lại phân số: ");
            }
        } while (mauSo == 0);
    }

    public void xuat() {
        if (mauSo < 0) {
            mauSo = -mauSo;
            tuSo = -tuSo;
        }
        if (mauSo == 1) {
            System.out.print(String.format("%d", tuSo));
        } else {
            System.out.print(String.format("%d/%d", tuSo, mauSo));
        }
    }

    PhanSo cong(PhanSo p) {
        PhanSo kq = new PhanSo();
        kq.tuSo = tuSo * p.mauSo + mauSo * p.tuSo;
        kq.mauSo = mauSo * p.mauSo;
        return kq.rutGon();
    }

    PhanSo tru(PhanSo p) {
        PhanSo kq = new PhanSo();
        kq.tuSo = tuSo * p.mauSo - mauSo * p.tuSo;
        kq.mauSo = mauSo * p.mauSo;
        return kq.rutGon();
    }

    PhanSo nhan(PhanSo p) {
        PhanSo kq = new PhanSo();
        kq.tuSo = tuSo * p.tuSo;
        kq.mauSo = mauSo * p.mauSo;
        return kq.rutGon();
    }

    PhanSo chia(PhanSo p) {
        PhanSo kq = new PhanSo();
        kq.tuSo = tuSo * p.mauSo;
        kq.mauSo = mauSo * p.tuSo;
        return kq.rutGon();
    }

    int ucln(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        a = Math.abs(a);
        b = Math.abs(b);

        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    PhanSo rutGon() {
        int ucln = ucln(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;
        return this;
    }
}