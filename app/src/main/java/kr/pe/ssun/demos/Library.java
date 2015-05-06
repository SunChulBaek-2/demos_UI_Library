package kr.pe.ssun.demos;

/**
 * Created by x1210x on 15. 4. 15..
 */
public enum Library {
  MATERIAL_TAB("MaterialTab", R.string.desc_material_tabs, it.neokree.materialtabtest.MainActivity.class),
  ANDROID_CHIPS("AndroidChips", R.string.desc_android_chips, com.android.ex.chips.sample.MainActivity.class),
  FLOATING_ACTION_BUTTON("FloatingActionButton", R.string.desc_floating_action_button, com.getbase.floatingactionbutton.sample.MainActivity.class);

  private String title;
  private int desc;
  private Class clazz;

  Library(String title, int desc, Class clazz) {
    this.title = title;
    this.desc = desc;
    this.clazz = clazz;
  }

  public String getTitle() {
    return this.title;
  }

  public int getDesc() {
    return this.desc;
  }

  public Class getClazz() {
    return this.clazz;
  }

  @Override
  public String toString() {
    return this.title;
  }
};
