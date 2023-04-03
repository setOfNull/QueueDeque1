import java.util.Deque;
import java.util.*;



    public class UndoRedo {
        private Deque<String> history = new ArrayDeque<>();
        private Deque<String> redoHistory = new ArrayDeque<>();
        private String currentText = "";

        
        public void insert(String text) {
            history.addLast("insert " + text);
            currentText += text;
        }

        public void delete(int length) {
            String deletedText = currentText.substring(currentText.length() - length);
            history.addLast("delete " + deletedText);
            currentText = currentText.substring(0, currentText.length() - length);
        }

        public void undo() {
            if (!history.isEmpty()) {
                String lastAction = history.removeLast();
                String[] actionComponents = lastAction.split(" ");
                String actionType = actionComponents[0];
                String actionText = actionComponents[1];
                if (actionType.equals("insert")) {
                    redoHistory.addLast(actionText);
                    currentText = currentText.substring(0, currentText.length() - actionText.length());
                } else if (actionType.equals("delete")) {
                    redoHistory.addLast(actionText);
                    currentText += actionText;
                }
            }
        }

        public void redo() {
            if (!redoHistory.isEmpty()) {
                String lastAction = redoHistory.removeLast();
                String[] actionComponents = lastAction.split(" ");
                String actionType = actionComponents[0];
                String actionText = actionComponents[1];
                if (actionType.equals("insert")) {
                    currentText += actionText;
                    history.addLast(lastAction);
                } else if (actionType.equals("delete")) {
                    currentText = currentText.substring(0, currentText.length() - actionText.length());
                    history.addLast(lastAction);
                }
            }
        }

        public String getCurrentText() {
            return currentText;
        }
    }

