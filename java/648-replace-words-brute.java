class Solution {
    public boolean isPrefix(String root, String derivative) {
        if (root.length() > derivative.length()) {
            return false;
        }

        for (int i = 0; i < root.length(); ++i) {
            if (root.charAt(i) != derivative.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);

        String[] words = sentence.split("\\s+");

        for (String word : words) {
            String root = word;

            for (int i = 0; i < dictionary.size(); ++i) {
                if (isPrefix(dictionary.get(i), word)) {
                    root = dictionary.get(i);
                    break;
                }
            }
            
            sentence = sentence.replaceFirst(word, root);
        }

        return sentence;
    }
}