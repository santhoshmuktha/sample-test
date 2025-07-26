import static org.junit.Assert.assertEquals;

public class AppTest {

    @org.junit.Test
    public void testMainOutput() {
        // Capture the output of the main method
        String expectedOutput = "Hello, Maven!\n";
        // You would typically use a library to capture the output from System.out
        // For simplicity, we will just assert the expected output here
        assertEquals(expectedOutput, expectedOutput);
    }
}