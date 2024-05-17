import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class EquipmentTrackingSystem {
    static Map<Integer, Equipment> equipmentMap = new HashMap<>();

    protected static void addEquipment(Scanner scanner) { //ekipman eklememizi sağlayan metod
        System.out.print("Ekipman adı: ");
        String name = scanner.nextLine();
        System.out.print("Ekipman türü: ");
        String type = scanner.nextLine();
        System.out.print("Ekipman konumu: ");
        String location = scanner.nextLine();
        System.out.print("Ekipmana vermek istediğiniz id: ");
        int id = scanner.nextInt();
        if (equipmentMap.containsKey(id) == true) { //id çakışması olması durumunda uyarı verecek
            System.out.println("Girdiğiniz id başka bir elemana ait, lütfen tekrar giriniz");
        } else {
            Equipment equipment = new Equipment(name, type, location, id); //Equipment classının nesnesini oluşturduk, her seferinde yeni ekipmanı eklemesi için burada oluşturduk
            equipmentMap.put(id, equipment); //yeninesneyi hash map'e ekledik, id kısmı pk oluyo
            System.out.println("Ekipman eklendi.");
        }
    }

    protected static void updateMaintenanceStatus(Scanner scanner) { //bakım durumunu güncelleyen metod
        try{
            System.out.print("Bakım yapılacak ekipmanın idsi: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Equipment equipment = equipmentMap.get(id); //id'den ekipmanı buluyor
            if (equipment != null) {
                System.out.print("Bakım durumu (Bakımda/Bakım yapıldı): ");
                String maintenanceStatus = scanner.nextLine();
                equipment.setMaintenance(maintenanceStatus); //bakım durumunu güncelledik
                Date maintenanceDate = new Date(); //tarihi aldık
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); //yıl/ay/gün formatına getirdik
                equipment.setMaintenanceDate(df.format(maintenanceDate)); //tarihi ayarladık
                System.out.println("Bakım durumu güncellendi");
            } else {
                System.out.println("Ekipman bulunamadı.");
            }
        } catch (InputMismatchException e) {
            System.out.println("İstenen tipte veri girişi yapmadınız");
        }
    }

    protected static void listEquipments() { //ekipmanları listeleyen metod
        System.out.println("Ekipmanlar:");
        for (Equipment equipment : equipmentMap.values()) {
            System.out.println("Adı: " + equipment.getName() + ", Türü: " + equipment.getType() + ", Konumu: " + equipment.getLocation() + ", Bakım Durumu: " + equipment.getMaintenanceStatus());
        }
    }

    protected static void updateLocation(Scanner scanner) { //konumu güncelleyen metod
        System.out.print("Konumu güncelleneecek ekipmanın idsi: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Equipment equipment = equipmentMap.get(id); //id'den ekipmanı çektik
        if (equipment != null) {
            System.out.print("Yeni konum: ");
            String location = scanner.nextLine();
            equipment.setLocation(location); //konumu ayarladık
            System.out.println("Konum güncellendi.");
        } else {
            System.out.println("Ekipman bulunamadı.");
        }
    }
}
