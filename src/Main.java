public class Main {

    public static String convertToOldNIC(String newNIC) {
        if (newNIC == null || newNIC.length() != 12) {
            throw new IllegalArgumentException("Invalid new NIC format");
        }

        // Extract the last two digits of the year
        String lastTwoDigitsOfYear = newNIC.substring(2, 4);

        // Extract the day of the year (next 3 digits)
        String dayOfYear = newNIC.substring(4, 7);

        // Extract the serial number (last 4 digits)
        String serialNumber = newNIC.substring(8, 12);

        // Combine to form the old NIC
        String oldNIC = lastTwoDigitsOfYear + dayOfYear + serialNumber + "V";

        return oldNIC;
    }


    public static String convertToNewNIC(String oldNIC) {
        if (oldNIC == null || oldNIC.length() != 10 || (!oldNIC.endsWith("V") && !oldNIC.endsWith("X"))) {
            throw new IllegalArgumentException("Invalid old NIC format");
        }

        // Extract the year part and reconstruct it as 19XX
        String yearPart = "19" + oldNIC.substring(0, 2);

        // Extract the day of the year part (next 3 digits)
        String dayOfYear = oldNIC.substring(2, 5);

        // Extract the last four digits and add a "0" in front
        String serialNumber = "0" + oldNIC.substring(5, 9);

        // Combine these parts to form the new NIC
        String newNIC = yearPart + dayOfYear + serialNumber;

        return newNIC;
    }

    public static void main(String[] args) {

    }
}