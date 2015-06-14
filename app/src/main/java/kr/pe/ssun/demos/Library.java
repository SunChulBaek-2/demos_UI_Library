package kr.pe.ssun.demos;

import com.wangjie.rapidfloatingactionbutton.example.MainActivity;

/**
 * Created by x1210x on 15. 4. 15..
 */
public enum Library {
  MATERIAL_TAB("MaterialTab", Category.MATERIAL, R.string.desc_material_tabs, R.string.desc_material_tabs, it.neokree.materialtabtest.MainActivity.class),
  MATERIAL_TAB2("MaterialTab", Category.MATERIAL, R.string.desc_material_tabs2, R.string.desc_material_tabs2, io.karim.materialtabs.sample.MainActivity.class),
  ANDROID_CHIPS("AndroidChips", Category.MATERIAL, R.string.desc_android_chips, R.string.desc_android_chips, com.android.ex.chips.sample.MainActivity.class),
  FLOATING_ACTION_BUTTON("FloatingActionButton", Category.MATERIAL, R.string.desc_floating_action_button, R.string.desc_floating_action_button, com.getbase.floatingactionbutton.sample.MainActivity.class),
  FLOATING_ACTION_BUTTON2("FloatingActionButton", Category.MATERIAL, R.string.desc_floating_action_button2, R.string.desc_floating_action_button2, com.melnykov.fab.sample.MainActivity.class),
  RAPID_FLOATING_ACTION_BUTTON("RapidFloatingActionButton", Category.MATERIAL, R.string.desc_rapid_floating_action_button, R.string.desc_rapid_floating_action_button, MainActivity.class),
  CIRCLE_IMAGE_VIEW("CircleImageView", Category.IMAGE, R.string.desc_circle_image_view, R.string.desc_circle_image_view, de.hdodenhof.circleimageview.sample.MainActivity.class);

  private String title;
  private Category category;
  private int desc;
  private int url;
  private Class clazz;

  Library(String title, Category category, int desc, int url, Class clazz) {
    this.title = title;
    this.category = category;
    this.desc = desc;
    this.url = url;
    this.clazz = clazz;
  }

  public String getTitle() {
    return this.title;
  }

  public Category getCategory() {
    return this.category;
  }

  public int getDesc() {
    return this.desc;
  }

  public int getUrl() {
    return this.url;
  }

  public Class getClazz() {
    return this.clazz;
  }

  @Override
  public String toString() {
    return this.title;
  }
};
