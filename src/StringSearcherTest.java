import org.junit.Assert;
import org.junit.Test;

/**
 * Тестирует {@link StringSearcher}<br/>
 * 1 сценарий - запуск поиска без данных (ожидаемый результат: исключение)<br/>
 * 2 сценарий - запуск заведомо неудачного поиска (ожидаемый результат: пустой массив)<br/>
 * 3 сценарий - запуск заведомо удачного поиска (ожидаемый результат: массив по тз)
 */
public class StringSearcherTest {
    @Test(expected = Exception.class)
    public void TestFindMatchesWithNoData() throws Exception {
        StringSearcher s = new StringSearcher();
        s.findMatches();
    }
    @Test
    public void TestFindMatchesWithoutMatches() {
        StringSearcher s = new StringSearcher();
        s.setData("рек","Где на Руси жить хорошо?");
        try {
            Assert.assertArrayEquals("Should return empty array",  new String[0], s.findMatches());
        } catch (Exception e) {
            Assert.fail();
        }
    }
    @Test
    public void TestFindMatchesWithMatches() {
        StringSearcher s = new StringSearcher();
        s.setData("дв","Дворник дверь два дня держал, деревянный дом дрожал. Ветер дёргал в доме дверь, дворник думал – это зверь.");
        try {
            String[] answer = {"дверь","два","дверь","дворник"};
            Assert.assertArrayEquals("Should return array [\"дверь\",\"два\",\"дверь\",\"дворник\"]",answer, s.findMatches());
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
