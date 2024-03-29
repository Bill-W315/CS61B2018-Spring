public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new LinkedListDeque<Character>();
        for(Character c : word.toCharArray()){
            deque.addLast(c);
        }
        return deque;
    }

    public boolean isPalindrome(String word){
        if(word.length() == 0 || word.length() == 1){
            return true;
        }
        Deque wordInDeque = wordToDeque(word);
        while(wordInDeque.isEmpty() != true && wordInDeque.size() != 1){
            Character left = (Character) wordInDeque.removeFirst();
            Character right = (Character) wordInDeque.removeLast();
            if(left.equals(right) == false){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length() == 0 || word.length() == 1){
            return true;
        }
        Deque wordInDeque = wordToDeque(word);
        while(wordInDeque.isEmpty() != true && wordInDeque.size() != 1){
            Character left = (Character) wordInDeque.removeFirst();
            Character right = (Character) wordInDeque.removeLast();
            if(cc.equalChars(left,right) == false){
                return false;
            }
        }
        return true;
    }

}