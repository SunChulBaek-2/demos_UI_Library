package kr.pe.ssun.demos;

/**
 * Created by x1210x on 15. 4. 15..
 */
public enum Library {
  MATERIAL_TAB("MaterialTab", it.neokree.materialtabtest.MainActivity.class),
  ANDROID_CHIPS("AndroidChips", com.android.ex.chips.sample.MainActivity.class);

  private String title;
  private Class clazz;

  private Library(String title, Class clazz) {
    this.title = title;
    this.clazz = clazz;
  }

  public String getTitle() {
    return this.title;
  }

  public Class getClazz() {
    return this.clazz;
  }

  @Override
  public String toString() {
    return this.title;
  }
};
