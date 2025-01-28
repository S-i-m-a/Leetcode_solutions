class Solution {
  public boolean doesAliceWin(String s) {
   
    return s.chars().anyMatch(c -> isVowel((char) c));
  }

  private boolean isVowel(char c) {
    return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
  }
}