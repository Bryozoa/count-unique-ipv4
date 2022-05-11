package main.java.com.polixis.searchalgoritms;

public interface UniqueIpCounter {

    /*
    In total there are 2 ^ 32 valid IP addresses exists.
     */
    long NUMBER_OF_IP_ADDRESSES = 256L * 256 * 256 * 256;

    /*
    Map string representing the IP address in format 0-255.0-255.0-255.0-255 to number
    in the range of 0..2^32-1 inclusive.
    It is guaranteed that the input string contains a valid IP address.
     */
    static long toLongValue(String ipString) {
        StringBuilder field = new StringBuilder(3);
        int startIndex = 0;
        long result = 0;

        for (int i = 0; i < 3; i++) {
            int spacerPosition = ipString.indexOf('.', startIndex);
            field.append(ipString, startIndex, spacerPosition);
            int fieldValue = Integer.parseInt(field.toString());
            field.setLength(0);
            result += fieldValue * Math.pow(256, 3 - i);
            startIndex = spacerPosition + 1;
        }
        result += Integer.parseInt(ipString.substring(startIndex));

        return result;
    }

    /*
    Returns the number of unique IP addresses in the file whose name is pass by the argument.
    Returns the number from 0 to 2 ^ 32 inclusive.
    Returns -1 in case of any errors.
     */
    long countUniqueIp(String fileName);
}
