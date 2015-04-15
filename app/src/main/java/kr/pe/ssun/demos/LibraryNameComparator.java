package kr.pe.ssun.demos;

import java.util.Comparator;

/**
 * Created by x1210x on 15. 4. 15..
 */
public class LibraryNameComparator implements Comparator<Library> {

  @Override
  public int compare(Library lhs, Library rhs) {
    return lhs.getTitle().compareTo(rhs.getTitle());
  }
}
