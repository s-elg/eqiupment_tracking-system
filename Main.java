import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EquipmentTrackingSystem system = new EquipmentTrackingSystem();

        try{
            while (true) {
                System.out.println("1. Ekipman ekle");
                System.out.println("2. Ekipman bakım durumu güncelle");
                System.out.println("3. Ekipmanın konumunu güncelle");
                System.out.println("4. Ekipmanları listele");
                System.out.println("5. Çıkış");
                System.out.print("Seçiminiz: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Boşluğu temizle

                switch (choice) {
                    case 1:
                        system.addEquipment(scanner);
                        break;
                    case 2:
                        system.updateMaintenanceStatus(scanner);
                        break;
                    case 3:
                        system.updateLocation(scanner);
                        break;
                    case 4:
                        system.listEquipments();
                        break;
                    case 5:
                        System.out.println("Çıkılıyor...");
                        System.exit(0);
                        break;
                    default:
                        throw new InputMismatchException("Geçersiz giriş yaptınız");
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("HATA! " + e.getMessage());
        }
    }
}

