public final class TaskParser {
    private final String input;
    private int index;

    private TaskParser(String input) {
        this.input = input;
        this.index = 0;
    }

    public static Task parse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("任务字符串不能为空");
        }

        TaskParser parser = new TaskParser(input);
        Task task = parser.parseTask();
        parser.skipWhitespace();
        if (!parser.isEnd()) {
            throw parser.error("存在多余字符");
        }
        return task;
    }

    private Task parseTask() {
        skipWhitespace();
        if (isEnd()) {
            throw error("意外结束，缺少任务内容");
        }

        char current = peek();
        if (current == '(') {
            return parseCompositeTask();
        }
        if (Character.isDigit(current)) {
            return new AtomicTask(parseNumber());
        }

        throw error("无法识别的任务起始字符 '" + current + "'");
    }

    private Task parseCompositeTask() {
        expect('(');
        skipWhitespace();

        char type = nextNonWhitespaceChar();
        Task left;
        Task right;

        if (type != 'S' && type != 'P') {
            throw error("组合任务类型必须是 S 或 P");
        }

        skipWhitespace();
        expect(',');
        left = parseTask();
        skipWhitespace();
        expect(',');
        right = parseTask();
        skipWhitespace();
        expect(')');

        if (type == 'S') {
            return new SerialTask(left, right);
        }
        return new ParallelTask(left, right);
    }

    private int parseNumber() {
        skipWhitespace();
        int start = index;
        while (!isEnd() && Character.isDigit(peek())) {
            index++;
        }
        if (start == index) {
            throw error("原子任务必须是非负整数");
        }

        String numberText = input.substring(start, index);
        try {
            int value = Integer.parseInt(numberText);
            if (value < 0) {
                throw error("原子任务不能为负数");
            }
            return value;
        } catch (NumberFormatException exception) {
            throw error("数字超出 int 范围: " + numberText);
        }
    }

    private char nextNonWhitespaceChar() {
        skipWhitespace();
        if (isEnd()) {
            throw error("意外结束");
        }
        return input.charAt(index++);
    }

    private void expect(char expected) {
        skipWhitespace();
        if (isEnd() || input.charAt(index) != expected) {
            throw error("期望字符 '" + expected + "'");
        }
        index++;
    }

    private void skipWhitespace() {
        while (!isEnd() && Character.isWhitespace(peek())) {
            index++;
        }
    }

    private char peek() {
        return input.charAt(index);
    }

    private boolean isEnd() {
        return index >= input.length();
    }

    private IllegalArgumentException error(String message) {
        return new IllegalArgumentException(message + "，位置: " + index + "，附近: " + snippet());
    }

    private String snippet() {
        int start = Math.max(0, index - 8);
        int end = Math.min(input.length(), index + 8);
        return input.substring(start, end);
    }
}