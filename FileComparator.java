import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class FileComparator {

    /**
     * compare the MD5 of two file
     * @param path1
     * @param path2
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static boolean compare(String path1, String path2) throws IOException, NoSuchAlgorithmException {
        return getMD5(path1).equals(getMD5(path2));
    }

    /**
     * compare the content of two files
     * @param pathFirstFile
     * @param pathSecondFile
     * @return
     */
    public static boolean isEqual(String pathFirstFile, String pathSecondFile) {
        Path firstFile = new File(pathFirstFile).toPath();
        Path secondFile = new File(pathSecondFile).toPath();
        try {
            if (Files.size(firstFile) != Files.size(secondFile)) {
                return false;
            }

            byte[] first = Files.readAllBytes(firstFile);
            byte[] second = Files.readAllBytes(secondFile);
            return Arrays.equals(first, second);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static String getMD5(String path) throws IOException, NoSuchAlgorithmException {
        //Create checksum for this file
        File file = new File(path);

        //Use MD5 algorithm
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");

        //Get the checksum
        String checksum = getFileChecksum(md5Digest, file);

        //see checksum
        return checksum;
    }

    private static String getFileChecksum(MessageDigest digest, File file) throws IOException {
        //Get file input stream for reading the file content
        FileInputStream fis = new FileInputStream(file);

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        //Read file data and update in message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };

        //close the stream; We don't need it now.
        fis.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }
}