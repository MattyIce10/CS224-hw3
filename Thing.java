// CS224 Fall 2021
//
// *** this is for grad students only ***
//
// for use with priority-queue example code

public class Thing implements Comparable {
  int value;
  String name;

  public Thing(int value) {
    this.value = value;
    int v1, v2;
    Boolean done = false;
    name = "";
    v2 = value;
    while ( ! done ) {
      v1 = v2 % 10;
      if (v1 == 0)
        name = "zero" + name;
      else if (v1 == 1)
        name = "one" + name;
      else if (v1 == 2)
        name = "two" + name;
      else if (v1 == 3)
        name = "three" + name;
      else if (v1 == 4)
        name = "four" + name;
      else if (v1 == 5)
        name = "five" + name;
      else if (v1 == 6)
        name = "six" + name;
      else if (v1 == 7)
        name = "seven" + name;
      else if (v1 == 8)
        name = "eight" + name;
      else
        name = "nine" + name;
      if (v2 < 10)
        done = true;
      else {
        name = " " + name;
        v2 = v2 / 10;
      }
    }

    this.name = name;
  }

  public int compareTo(Object o) {
    Thing otherThing = (Thing) o;
    if (this.value < otherThing.value)
      return -1;
    else if (this.value > otherThing.value)
      return 1;
    else
      return 0;
  }

  public String toString() {
    String s = value + " (" + name + ")";
    return s;
  }
}
