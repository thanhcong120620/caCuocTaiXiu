import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class caCuocTaiXiu {
	static String tenNguoichoi;
	static double taiKhoan;
	static String chutk;
	static String nganhang;
	static String sotk;
	static Scanner sc = new Scanner(System.in);

	static Locale lc = new Locale("vi", "VN");
	static NumberFormat nf = NumberFormat.getInstance(lc);
	
	public static void main(String[] args) {
		System.out.println("\n$$$$$$$$$ ___ GAME CA CUOC TAI XIU ___ $$$$$$$$");
		String choice = "0";

		do {
			System.out.println("\n|-----------------MENU-----------------|");
			System.out.println("| Ban co muon ca cuoc khong (1 or 2):  |");
			System.out.println("|(1) Thoi toi het tien roi             |");
			System.out.println("|(2) Toi muon ca cuoc them 1 lan nua   |");
			System.out.println("|(3) Dang ky tai khoan                 |");
			System.out.println("|(4) Kiem tra tai khoan                |");
			System.out.println("|(5) Nap them tien vao tai khoan       |");
			System.out.println("|(6) Rut tien                          |");
			System.out.println("|--------------------------------------|");

			choice = sc.next();

			switch (choice) {
			case "2":
				caCuoc();
				break;
			case "3":
				dangKyTK();
				break;
			case "4":
				ktTK();
				break;
			case "5":
				napTien();
				break;
			case "6":
				rutTien();
				break;

			default:
				System.out.println("Ban da thoat van cuoc ");
			}

		} while (choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("3") || choice.equalsIgnoreCase("4")
				|| choice.equalsIgnoreCase("5") || choice.equalsIgnoreCase("6"));
		System.out.println("Xin chao va hen gap lai !!!");

	}

	public static void caCuoc() {

		/* Dat cuoc */
		double tienCuoc=0;
		int taiXiu;
		String taiXiu2;

		do {
			if (taiKhoan == 0) {
				System.out.println("Tai khoan cua ban da bi chay, vui long nap them tien");
				break;
			}
			int cuoc;
			do {
			System.out.println("Ban muon cuoc nhu the nao: \n(1)Kho mau! Show hand\n(2)Nhap so tien cuoc");
			cuoc = sc.nextInt();
			if(cuoc==1) {
				tienCuoc = taiKhoan;
			} else if(cuoc==2) {
				System.out.println("Ban muon cuoc bao nhieu");
			tienCuoc = sc.nextDouble();
			}
			}while(cuoc!=1 && cuoc!=2);
			
			if (tienCuoc > taiKhoan) {
				System.out.println("Tai khoan cua ban khong du voi so tien cuoc, moi ban cuoc lai");
			} else {

				do {
					System.out.println("Ban muon chon Tai hay Xiu\n(1) Tai\n(2) Xiu");
					taiXiu = sc.nextInt();
					if (taiXiu != 1 && taiXiu != 2) {
						System.out.println("Vui long chon 1 hoac 2 de chon Tai va Xiu");
					}
				} while (taiXiu != 1 && taiXiu != 2);

				if (taiXiu == 1) {
					taiXiu2 = "Tai";
				} else {
					taiXiu2 = "Xiu";
				}
				System.out.println(String.format("ban da cuoc %s va chon %s", tienCuoc, taiXiu2));

				/* Tung xuc xac */
				Random xucxac1 = new Random();
				Random xucxac2 = new Random();
				Random xucxac3 = new Random();

				int gt1 = xucxac1.nextInt(5) + 1;
				int gt2 = xucxac2.nextInt(5) + 1;
				int gt3 = xucxac3.nextInt(5) + 1;
				int tonggt = gt1 + gt3 + gt2;

				/* Thong bao ket qua */
				System.out.println(String.format("Ket qua sau khi lac 3 vien xuc xac: %s - %s - %s", gt1, gt2, gt2));

				if (tonggt == 3 || tonggt == 18) {
					taiKhoan -= tienCuoc;
					System.out.println("--> Nha Cai thang, ban da thua " + tienCuoc);
					System.out.println("So du tai khoan: " + nf.format(taiKhoan));
					break;
				} else if (tonggt >= 4 && tonggt <= 10) {
					System.out.print("--> Xiu: ");
					if (taiXiu == 2) {
						taiKhoan += tienCuoc;
						System.out.println("WIN, Ban da co them " + tienCuoc);
						System.out.println("So du tai khoan: " + nf.format(taiKhoan));
						break;
					} else {
						taiKhoan -= tienCuoc;
						System.out.println("FAILED, Ban da thua " + tienCuoc);
						System.out.println("So du tai khoan: " + nf.format(taiKhoan));
						break;
					}
				} else if (tonggt >= 11 && tonggt <= 17) {
					System.out.print("--> Tai: ");
					if (taiXiu == 1) {
						taiKhoan += tienCuoc;
						System.out.println("WIN, Ban da co them " + tienCuoc);
						System.out.println("So du tai khoan: " + nf.format(taiKhoan));
						break;
					} else {
						taiKhoan -= tienCuoc;
						System.out.println("FAILED, Ban da thua " + tienCuoc);
						System.out.println("So du tai khoan: " + nf.format(taiKhoan));
						break;
					}
				}
			}

		} while (tienCuoc > taiKhoan);

	}

	public static void dangKyTK() {
		System.out.println("---------DANG KY TAI KHOAN---------");
		sc.nextLine();
		System.out.print("Nhap ten cua ban: ");
		tenNguoichoi = sc.nextLine();
		System.out.print("\nChu tai khoan: ");
		chutk = sc.nextLine();
		System.out.print("\nNgan hang: ");
		nganhang = sc.next();
		System.out.print("\nSo tai khoan: ");
		sotk = sc.next();
		System.out.print("\nNap tien vao tai khoan: ");
		taiKhoan = sc.nextDouble();
	}

	public static void napTien() {
		System.out.println("---------NAP TIEN VAO TAI KHOAN---------");
		int er = 0;
		do {
			System.out.print("Nhap ten cua ban: ");
			String tenNguoichoi1 = sc.next();
			System.out.println();
			if (!tenNguoichoi1.equalsIgnoreCase(tenNguoichoi)) {
				System.out.println("Ten nguoi choi khong ton tai");
			} else if (tenNguoichoi1.equalsIgnoreCase(tenNguoichoi)) {
				er = 1;
				System.out.print("Ban muon nap them bao nhieu: ");
				double taiKhoan1 = sc.nextDouble();
				taiKhoan += taiKhoan1;
				System.out.println("ban da nap tien thanh cong !!!");
				System.out.println("So du tai khoan: " + nf.format(taiKhoan));
			}
		} while (er != 1);
	}

	public static void rutTien() {
		double rut = 0;
		int checkr;
		do {
		System.out.println("Ban muon rut nhu the nao: \n(1)Rut het\n(2)Nhap so tien rut");
		checkr = sc.nextInt();
		if(checkr==1) {
			rut = taiKhoan;
			taiKhoan -= rut;
		} else if(checkr==2) {
			do {
			System.out.println("Ban muon rut bao nhieu");
			rut = sc.nextDouble();
			if(rut>taiKhoan) {
				System.out.println("So du khong du de rut");
			} else {
				taiKhoan -= rut;
			}
			}while(rut>taiKhoan);
		}
		}while(checkr!=1 && checkr!=2);
		
		
		System.out.println("Ban da rut tien thanh cong !!!");
		System.out.println("So du tai khoan: " + taiKhoan);
	}

	public static void ktTK() {
		System.out.println("---------TAI KHOAN CUA BAN---------");
		System.out.println("Ten nguoi choi: " + tenNguoichoi);
		System.out.println("So du tai khoan: " + nf.format(taiKhoan));
		System.out.println("Ngan hang lien ket: " + nganhang);
		System.out.println("So tai khoan: " + sotk);
	}

}
