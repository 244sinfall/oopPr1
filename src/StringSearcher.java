import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSearcher {
    private String _matcher = "";
    private String _input = "";

    /**
     * Проверяет наличие данных.
     * @return true - исходная строка и строка для поиска присутствуют; false в остальных случаях.
     */
    private boolean hasData() {
        return !this._input.equals("") && !this._matcher.equals("");
    }

    /**
     *
     * @return {@link Pattern} для поиска по строке.
     * @throws Exception {@link java.util.regex.PatternSyntaxException}: ошибка компиляции регулярного выражения;
     * {@link Exception}: отсутствие данных.
     */
    private Pattern buildRegex() throws Exception {
        if (this.hasData()) {
            return Pattern.compile("([^\\s,.:-?]+)?"+this._matcher+"([^\\s,.:-?]+)?");
        }
        throw new Exception("regex couldn't be created without a matcher");
    }

    /**
     * Устанавливает значения, необходимые для работы
     * @param matcher искомое значение в каждом слове
     * @param input строка, по которой проводится поиск
     */
    public void setData(String matcher, String input) {
        this._input = input;
        this._matcher = matcher;
    }

    /**
     *
     * @return Массив слов, включающих в себя matcher, и находящихся в строке input
     * @throws Exception при отсутствии данных
     */
    public String[] findMatches() throws Exception {
        if(this.hasData()) {
            Pattern searchPattern = this.buildRegex();
            Matcher matcher = searchPattern.matcher(this._input);
            int resultsCount = (int) matcher.results().count();
            if(resultsCount == 0) return new String[0];
            String[] output = new String[resultsCount];
            matcher.reset();
            int counter = 0;
            while (matcher.find()) {
                output[counter] = matcher.group();
                counter++;
            }
            return output;
        } else {
            throw new Exception("missing data");
        }
    }
}
