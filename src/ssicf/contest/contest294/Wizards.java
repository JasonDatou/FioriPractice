package ssicf.contest.contest294;


class Wizards {
  public static void main(String[] args) {
    WizardsSolution s = new WizardsSolution();
    int[] nums = new int[]{1, 3, 1, 2};
    int result = s.totalStrength(nums);
    System.out.println(result);
  }
}

class WizardsSolution {
  long result = 0;

  public int totalStrength(int[] strength) {
    for (int i = 0; i < strength.length; i++) {
      getCombos(i + 1, strength);
    }
    return (int)(result % ( 1000000000 + 7 ));
  }

  private void getCombos(int amount, int[] strength) {
    for (int i = 0; i < strength.length - amount + 1; i++) {
      int min = strength[i];
      int sum = 0;
      for (int j = i; j < amount + i; j++) {
        min = Math.min(min, strength[j]);
        sum += strength[j];
      }
      result += (min * sum);
    }
  }
}

