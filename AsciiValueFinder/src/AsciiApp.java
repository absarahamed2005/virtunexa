public class AsciiApp {
    public static void main(String[] args) {
        boolean useGUI = false; // Set to true to use GUI

        if (useGUI) {
            new GUIApp();
        } else {
            ConsoleUI app = new ConsoleUI();
            app.run();
        }
    }
}