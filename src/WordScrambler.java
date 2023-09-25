public class WordScrambler {

    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) {
        mixedWords(wordArr);

        scrambledWords = wordArr;

    }

    private String recombine (String word1, String word2) {
        int halfWord1Length = word1.length()/2;
        int halfWord2Length = word2.length()/2;
        String halfWord1 = word1.substring(0,halfWord1Length);
        String halfWord2 = word2.substring(halfWord2Length);
        String newWord = halfWord1 + halfWord2;
        return newWord;

    }


    private String[] mixedWords (String[] words) {
        if (words.length%2 != 0) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j)==' ') {
                    throw new IllegalArgumentException("Word Array must contain single words only! "+ words[i] + " contains more than one word!");
                }
            }
        }
        for (int i = 0; i < words.length; i += 2) {
            String w1 = words[i];
            String w2 = words[i+1];
            String newW1 = recombine(w1,w2);
            String newW2 = recombine(w2,w1);
            words[i] = newW1;
            words[i+1] = newW2;

        }

        return scrambledWords;

    }


    public String[] getScrambledWords() {
        return scrambledWords;
    }


}