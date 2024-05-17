import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.text.DateFormat;

class Equipment {
    private String name;
    private String type;
    private String location;
    private String maintenanceStatus;
    private int id;
    private String maintenanceDate;


    protected Equipment(String name, String type, String location, int id) { //ekipman nesnesini oluşturmak için metod
        this.name = name;
        this.type = type;
        this.location = location;
        this.id = id;
        this.maintenanceStatus = "Yeni cihaz";
    }

    protected String getName() { //ekipmanın ismini almamızı sağlayan metod
        return name;
    }

    protected String getType() { //ekipmanın türünü almamızı sağlayan metod
        return type;
    }

    protected String getLocation() { //ekipmanın konumunu almamızı sağlayan meod
        return location;
    }

    protected String getMaintenanceDate() { //ekipmanın bakımdan alınma/ bakıma verilme tarihini almamızı sağlayan metod
        return maintenanceDate;
    }

    protected String getMaintenanceStatus() { //ekipmanın bakım durumunu almamızı sağlayan metod
        if (maintenanceStatus.equals("Bakımda")) {
            return maintenanceStatus + ", bakıma veriliş tarihi: " + getMaintenanceDate();
        } else if(maintenanceStatus.equals("Bakım yapıldı")) {
            return maintenanceStatus + ", bakımdan alınış tarihi: " + getMaintenanceDate();
        }
        return maintenanceStatus;
    }

    protected void setMaintenance(String maintenanceStatus) { //bakım durumunu ayarlayan metod
        this.maintenanceStatus = maintenanceStatus;
    }

    protected void setLocation(String location) { //konumu ayarlayan metod
        this.location = location;
    }

    protected void setMaintenanceDate(String maintenanceDate) { //bakımdan alınma/bakıma verilme tarihini ayaarlayan metod
       this.maintenanceDate = maintenanceDate;
    }
}
