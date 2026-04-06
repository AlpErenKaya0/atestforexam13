
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileServiceTest {

    @TempDir
    Path tempDir;

    @Test
    void testFileWriteAndRead() throws Exception {
        Path filePath = tempDir.resolve("testfile.txt");

        String content = "Hello JUnit 5!";
        Files.writeString(filePath, content);

        assertTrue(Files.exists(filePath), "File should be created in temp directory");

        String readContent = Files.readString(filePath);
        assertEquals(content, readContent, "File content should match the written string");
    }

    @Test
    void testMultipleFiles() throws Exception {
        Path file1 = tempDir.resolve("file1.log");
        Path file2 = tempDir.resolve("file2.log");

        Files.createFile(file1);
        Files.createFile(file2);

        assertEquals(2, Files.list(tempDir).count(), "There should be 2 files in the temp directory");
    }
}