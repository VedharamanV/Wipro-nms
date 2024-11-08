import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaultManagement {
    public static void main(String[] args) {
        // Simulate alarms
        Map<String, String> alarm1 = new HashMap<>();
        alarm1.put("interface", "ge-0/0/0");
        alarm1.put("reason", "Packet Loss Detected");

        Map<String, String> alarm2 = new HashMap<>();
        alarm2.put("interface", "ge-0/0/1");
        alarm2.put("reason", "High Utilization");

        List<Map<String, String>> alarms = new ArrayList<>();
        alarms.add(alarm1);
        alarms.add(alarm2);

        // Correlate alarms and root cause analysis
        correlateAlarms(alarms);
    }

    private static void correlateAlarms(List<Map<String, String>> alarms) {
        boolean highUtilization = false;
        boolean packetLoss = false;

        for (Map<String, String> alarm : alarms) {
            if ("High Utilization".equals(alarm.get("reason"))) {
                highUtilization = true;
            }
            if ("Packet Loss Detected".equals(alarm.get("reason"))) {
                packetLoss = true;
            }
        }

        if (highUtilization && packetLoss) {
            System.out.println("Root Cause Analysis: High Utilization on ge-0/0/1 may be contributing to Packet Loss on ge-0/0/0.");
        } else {
            System.out.println("No correlation found between alarms.");
        }
    }
}
