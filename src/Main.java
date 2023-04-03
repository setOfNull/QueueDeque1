public class Main {
    public static void main(String[] args) {
        UndoRedo test = new UndoRedo();

        test.insert("Hello World");


        test.insert(" How are you?");

        test.insert(" Fine");

        test.delete(3);
        System.out.println(test.getCurrentText());
        test.redo();



        System.out.println(test.getCurrentText());
    }
}
