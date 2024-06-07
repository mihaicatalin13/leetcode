class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split("\\s+");
        Set<String> dictSet = new HashSet<>(dictionary);

        for (int i = 0; i < words.length; ++i) {
            words[i] = shortestRoot(words[i], dictSet);
        }

        return String.join(" ", words);
    }

    public String shortestRoot(String word, Set<String> dictSet) {
        for (int i = 1; i <= word.length(); ++i) {
            String root = word.substring(0, i);
            if (dictSet.contains(root)) {
                return root;
            }
        }

        return word;
    }
}