package test;

import main.Levenshtein;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LevenshteinTest {

    @Test
    public void calculateCost_aIsSpace() {
        //given
        char a = ' ';
        char b = 'a';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, -1);
    }

    @Test
    public void calculateCost_bIsSpace() {
        //given
        char a = 'g';
        char b = ' ';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, -1);
    }

    @Test
    public void calculateCost_bothAreSpaces() {
        //given
        char a = ' ';
        char b = ' ';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, -1);
    }

    @Test
    public void calculateCost_aIsNotLetter() {
        //given
        char a = '1';
        char b = 'h';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, -1);
    }

    @Test
    public void calculateCost_bIsNotLetter() {
        //given
        char a = 'n';
        char b = '4';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, -1);
    }

    @Test
    public void calculateCost_bothAreNotLetter() {
        //given
        char a = '-';
        char b = '4';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, -1);
    }

    @Test
    public void calculateCost_sameFirstLine() {
        //given
        char a = 'y';
        char b = 't';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, 0.5);
    }

    @Test
    public void calculateCost_sameSecondLine() {
        //given
        char a = 'k';
        char b = 'l';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, 0.5);
    }

    @Test
    public void calculateCost_sameThirdLine() {
        //given
        char a = 'm';
        char b = 'n';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, 0.5);
    }

    @Test
    public void calculateCost_otherLine_1() {
        //given
        char a = 'q';
        char b = 'x';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, 1);
    }

    @Test
    public void calculateCost_otherLine_2() {
        //given
        char a = 'd';
        char b = 'b';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, 1);
    }

    @Test
    public void calculateCost_otherLine_3() {
        //given
        char a = 'y';
        char b = 'f';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, 1);
    }

    @Test
    public void calculateCost_otherLine_4() {
        //given
        char a = 'p';
        char b = 'c';

        //when
        double result = Levenshtein.calculateCost(a, b);

        //then
        Assertions.assertEquals(result, 1);
    }

    @Test
    public void LevQWERTY_test_1() {
        //given
        String word1 = "kot";
        String word2 = "kita";
        Levenshtein levenshtein = new Levenshtein();

        //when
        double result = levenshtein.LevQWERTY(word1, word2);

        //then
        Assertions.assertEquals(result, 1.5);
    }

    @Test
    public void LevQWERTY_test_2() {
        //given
        String word1 = "kwiat";
        String word2 = "kwist";
        Levenshtein levenshtein = new Levenshtein();

        //when
        double result = levenshtein.LevQWERTY(word1, word2);

        //then
        Assertions.assertEquals(result, 0.5);
    }

    @Test
    public void LevQWERTY_test_3() {
        //given
        String word1 = "drab";
        String word2 = "dal";
        Levenshtein levenshtein = new Levenshtein();

        //when
        double result = levenshtein.LevQWERTY(word1, word2);

        //then
        Assertions.assertEquals(result, 2);
    }

    @Test
    public void LevQWERTY_firstEmpty() {
        //given
        String word1 = "";
        String word2 = "dal";
        Levenshtein levenshtein = new Levenshtein();

        //when
        double result = levenshtein.LevQWERTY(word1, word2);

        //then
        Assertions.assertEquals(result, 3);
    }

    @Test
    public void LevQWERTY_secondEmpty() {
        //given
        String word1 = "okon";
        String word2 = "";
        Levenshtein levenshtein = new Levenshtein();

        //when
        double result = levenshtein.LevQWERTY(word1, word2);

        //then
        Assertions.assertEquals(result, 4);
    }

    @Test
    public void LevQWERTY_bothEmpty() {
        //given
        String word1 = "";
        String word2 = "";
        Levenshtein levenshtein = new Levenshtein();

        //when
        double result = levenshtein.LevQWERTY(word1, word2);

        //then
        Assertions.assertEquals(result, 0);
    }

    @Test
    public void LevQWERTY_secondNotWord() {
        //given
        String word1 = "okon";
        String word2 = "213";
        Levenshtein levenshtein = new Levenshtein();

        //when
        double result = levenshtein.LevQWERTY(word1, word2);

        //then
        Assertions.assertEquals(result, -1);
    }

    @Test
    public void LevQWERTY_firstNotWord() {
        //given
        String word1 = "*-";
        String word2 = "krab";
        Levenshtein levenshtein = new Levenshtein();

        //when
        double result = levenshtein.LevQWERTY(word1, word2);

        //then
        Assertions.assertEquals(result, -1);
    }

    @Test
    public void LevQWERTY_bothNotWord() {
        //given
        String word1 = "*-";
        String word2 = "kr3ab";
        Levenshtein levenshtein = new Levenshtein();

        //when
        double result = levenshtein.LevQWERTY(word1, word2);

        //then
        Assertions.assertEquals(result, -1);
    }

}
