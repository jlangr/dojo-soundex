import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SoundexTest {
    private Soundex soundex;

    @Before
    public void create() {
        soundex = new Soundex();
    }

    @Ignore
    @Test
    public void retainsSoleLetterOfOneLetterWord() {
        assertThat(soundex.encode("A"), is(equalTo("A000")));
    }

    @Test
    @Ignore
    public void replacesConsonantsWithAppropriateDigits() {
        assertThat(soundex.encode("Ab"), is(equalTo("A100")));
        // Uncomment each subsequent assertion, and get to pass, one at a time:
        // assertThat(soundex.encode("Bcdl"), is(equalTo("B234")));
        // assertThat(soundex.encode("Ajmr"), is(equalTo("A256")));

        // Prepare to discuss: Should we have multiple assertions in one test?
    }

    @Test
    @Ignore
    public void limitsLengthToFourCharacters() {
        assertThat(soundex.encode("Dbcdlmr"), is(equalTo("D123")));
    }

    @Test
    @Ignore
    public void ignoresVowelLikeLetters() {
        assertThat(soundex.encode("Faeiouhycts"), is(equalTo("F232")));
    }

    @Test
    @Ignore
    public void combinesDuplicateEncodingsAsSingleNumber() {
        // Prepare to discuss:
        // - What is the value of these three preconditions?
        // - What is the cost (tradeoff)? How do you feel about the design choice?
        //assertThat(soundex.toDigit('b'), is(equalTo(soundex.toDigit('f'))));
        //assertThat(soundex.toDigit('c'), is(equalTo(soundex.toDigit('g'))));
        //assertThat(soundex.toDigit('d'), is(equalTo(soundex.toDigit('t'))));

        assertThat(soundex.encode("Gbfcgdt"), is(equalTo("G123")));
    }

    @Test
    @Ignore
    public void uppercasesFirstLetter() {
        assertThat(soundex.encode("abcd"), is(equalTo("A123")));
    }

    @Test
    @Ignore
    public void ignoresVowelLikeLettersRegardlessOfCase() {
        assertThat(soundex.encode("FcAEIOUHYts"), is(equalTo("F232")));
    }

    @Test
    @Ignore
    public void replacesConsonantsWithAppropriateDigitsRegardlessOfCase() {
        assertThat(soundex.encode("BCDL"), is(equalTo("B234")));
    }

    @Test
    @Ignore
    public void combinesDuplicateEncodingsWhenSecondLetterDuplicatesFirst() {
        assertThat(soundex.encode("Bbcd"), is(equalTo("B230")));
    }

    @Test
    @Ignore
    public void doesNotCombineDuplicateEncodingsSeparatedByVowels() {
        assertThat(soundex.encode("Jbobby"), is(equalTo("J110")));
    }
    // Congratulations if you made it this far!
    // Prepare to discuss:
    // - What other tests are missing?
    // - What were the costs and benefits of building Soundex incrementally?
}
