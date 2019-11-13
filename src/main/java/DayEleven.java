public class DayEleven {

    private char[] passwordCharacters;
    private int lastLetterValue;

    public String parttOne(String input) {
        passwordCharacters = input.toCharArray();
        updatePassword();
        while(!checkForIncreasingStraight() || !checkForInvalidCharacters() || !checkForPairs()) {
            updatePassword();
        }
        return new String(passwordCharacters);
    }

    private boolean checkForPairs() {
        int pairCount = 0;
        for(int i = 0; i + 1 < passwordCharacters.length; i++) {
            if(passwordCharacters[i] == passwordCharacters[i + 1]) {
                pairCount++;
                i++;
            }
        }
        return pairCount >= 2;
    }

    private boolean checkForInvalidCharacters() {
        String checkString = new String(passwordCharacters);
        return !checkString.contains("i") && !checkString.contains("o") && !checkString.contains("l");
    }

    private boolean checkForIncreasingStraight() {
        for (int i = 0; i + 2 < passwordCharacters.length; i++) {
            if((int)passwordCharacters[i] + 1 == (int)passwordCharacters[i + 1]
                && (int)passwordCharacters[i + 1] + 1 == (int)passwordCharacters[i + 2]) {
                return true;
            }
        }
        return false;
    }

    private void updatePassword() {
        lastLetterValue = passwordCharacters[passwordCharacters.length - 1];
        int i = 1;
        if(lastLetterValue != 122) {
            passwordCharacters[passwordCharacters.length - 1] = (char) (lastLetterValue + 1);
        } else {
            updateCharacters(i, ++i);
            if(lastLetterValue != 122) {
                passwordCharacters[passwordCharacters.length - i] = (char) (lastLetterValue + 1);
            } else {
                updateCharacters(i, ++i);
                if(lastLetterValue != 122) {
                    passwordCharacters[passwordCharacters.length - i] = (char) (lastLetterValue + 1);
                } else {
                    updateCharacters(i, ++i);
                    if(lastLetterValue != 122) {
                        passwordCharacters[passwordCharacters.length - i] = (char) (lastLetterValue + 1);
                    } else {
                        updateCharacters(i, ++i);
                        if(lastLetterValue != 122) {
                            passwordCharacters[passwordCharacters.length - i] = (char) (lastLetterValue + 1);
                        } else {
                            updateCharacters(i, ++i);
                            if(lastLetterValue != 122) {
                                passwordCharacters[passwordCharacters.length - i] = (char) (lastLetterValue + 1);
                            } else {
                                updateCharacters(i, ++i);
                                if(lastLetterValue != 122) {
                                    passwordCharacters[passwordCharacters.length - i] = (char) (lastLetterValue + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void updateCharacters(int x, int y) {
        passwordCharacters[passwordCharacters.length - x] = 'a';
        lastLetterValue = passwordCharacters[passwordCharacters.length - y];
    }

    public static void main(String[] args) {
        DayEleven dayEleven = new DayEleven();
        String result = dayEleven.parttOne("cqjxjnds");
        System.out.printf("Part One: %s", result);
        System.out.printf("%nPart Two: %s", dayEleven.parttOne(result));
    }
}
