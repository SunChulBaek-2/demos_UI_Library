package io.karim.materialtabs.sample;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import io.karim.materialtabs.sample.ui.RadioButtonCenter;

public class TabsSettingsFragment extends Fragment implements ResettableFragment, View.OnClickListener {

    public static final String INDICATOR_COLOR = "INDICATOR_COLOR";
    public static final String UNDERLINE_COLOR = "UNDERLINE_COLOR";
    public static final String INDICATOR_HEIGHT = "INDICATOR_HEIGHT";
    public static final String UNDERLINE_HEIGHT = "UNDERLINE_HEIGHT";
    public static final String TAB_PADDING = "TAB_PADDING";
    public static final String PADDING_MIDDLE = "PADDING_MIDDLE";
    public static final String SAME_WEIGHT_TABS = "SAME_WEIGHT_TABS";
    public static final String TEXT_ALL_CAPS = "TEXT_ALL_CAPS";
    public static final String TAB_BACKGROUND = "TAB_BACKGROUND";
    public static final String TOOLBAR_BACKGROUND = "TOOLBAR_BACKGROUND";
    public static final String TEXT_COLOR_UNSELECTED = "TEXT_COLOR_UNSELECTED";
    public static final String TEXT_COLOR_SELECTED = "TEXT_COLOR_SELECTED";
    public static final String TEXT_STYLE_SELECTED = "TEXT_STYLE_SELECTED";
    public static final String TEXT_STYLE_UNSELECTED = "TEXT_STYLE_UNSELECTED";
    public static final String SHOW_TOOLBAR = "SHOW_TOOLBAR";
    public static final String NUMBER_OF_TABS = "NUMBER_OF_TABS";

    private static final int UNDERLINE_HEIGHT_DEFAULT_DP = 0;
    private static final int INDICATOR_HEIGHT_DEFAULT_DP = 2;
    private static final int TAB_PADDING_DEFAULT_DP = 12;
    private static final int NUMBER_OF_TABS_DEFAULT = 3;

    private MainActivity mainActivity;

    // Indicator Height
    SeekBar numberOfTabsSeekBar;
    TextView numberOfTabsTextView;

    // Indicator Color
    RadioGroup indicatorColorRadioGroup;
    RadioButtonCenter indicatorColorButtonWhite;

    // Underline Color
    RadioGroup underlineColorRadioGroup;
    RadioButtonCenter underlineColorButtonMantis;

    // Indicator Height
    SeekBar indicatorHeightSeekBar;
    TextView indicatorHeightTextView;

    // Underline Height
    SeekBar underlineHeightSeekBar;
    TextView underlineHeightTextView;

    // Tab Padding Left Right
    SeekBar tabPaddingSeekBar;
    TextView tabPaddingTextView;

    // Padding Middle
    CheckBox paddingMiddleCheckBox;

    // Should Expand
    CheckBox sameWeightTabsCheckBox;

    // Text All Caps
    CheckBox textAllCapsCheckBox;

    // Show Toolbar
    CheckBox showToolbarCheckBox;

    // Tab Text Color
    RadioGroup tabTextColorRadioGroup;
    RadioButtonCenter tabTextColorButtonWhite;

    // Tab Text Selected Color
    RadioGroup tabTextSelectedColorRadioGroup;
    RadioButtonCenter tabTextSelectedColorButtonWhite;

    // Tab Background Color
    RadioGroup tabBackgroundColorRadioGroup;
    RadioButtonCenter tabBackgroundColorButtonFireEngineRed;

    // Toolbar Background Color
    RadioGroup toolbarColorRadioGroup;
    RadioButtonCenter toolbarColorButtonFireEngineRed;

    // Selected Text Style
    RadioGroup selectedTextStyleRadioGroup;
    RadioButton selectedTextStyleButtonBold;

    // Unselected Text Style
    RadioGroup unselectedTextStyleRadioGroup;
    RadioButton unselectedTextStyleButtonBold;

    int underlineHeightDp;
    int indicatorHeightDp;
    int tabPaddingDp;
    int numberOfTabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tabs_settings, container, false);

        // Indicator Height
        numberOfTabsSeekBar = (SeekBar)rootView.findViewById(R.id.numberOfTabsSeekBar);
        numberOfTabsTextView = (TextView)rootView.findViewById(R.id.numberOfTabsTextView);
        // Indicator Color
        indicatorColorRadioGroup = (RadioGroup)rootView.findViewById(R.id.indicatorColorRadioGroup);
        indicatorColorButtonWhite = (RadioButtonCenter)rootView.findViewById(R.id.indicatorColorButtonWhite);
        // Underline Color
        underlineColorRadioGroup = (RadioGroup)rootView.findViewById(R.id.underlineColorRadioGroup);
        underlineColorButtonMantis = (RadioButtonCenter)rootView.findViewById(R.id.underlineColorButtonMantis);
        // Indicator Height
        indicatorHeightSeekBar = (SeekBar)rootView.findViewById(R.id.indicatorHeightSeekBar);
        indicatorHeightTextView = (TextView)rootView.findViewById(R.id.indicatorHeightTextView);
        // Underline Height
        underlineHeightSeekBar = (SeekBar)rootView.findViewById(R.id.underlineHeightSeekBar);
        underlineHeightTextView = (TextView)rootView.findViewById(R.id.underlineHeightTextView);
        // Tab Padding Left Right
        tabPaddingSeekBar = (SeekBar)rootView.findViewById(R.id.tabPaddingSeekBar);
        tabPaddingTextView = (TextView)rootView.findViewById(R.id.tabPaddingTextView);
        // Padding Middle
        paddingMiddleCheckBox = (CheckBox)rootView.findViewById(R.id.paddingMiddleCheckBox);
        // Should Expand
        sameWeightTabsCheckBox = (CheckBox)rootView.findViewById(R.id.sameWeightTabsCheckBox);
        // Text All Caps
        textAllCapsCheckBox = (CheckBox)rootView.findViewById(R.id.textAllCapsCheckBox);
        // Show Toolbar
        showToolbarCheckBox = (CheckBox)rootView.findViewById(R.id.showToolbarCheckBox);
        // Tab Text Color
        tabTextColorRadioGroup = (RadioGroup)rootView.findViewById(R.id.tabTextColorRadioGroup);
        tabTextColorButtonWhite = (RadioButtonCenter)rootView.findViewById(R.id.tabTextColorButtonWhite);
        // Tab Text Selected Color
        tabTextSelectedColorRadioGroup = (RadioGroup)rootView.findViewById(R.id.tabTextSelectedColorRadioGroup);
        tabTextSelectedColorButtonWhite = (RadioButtonCenter)rootView.findViewById(R.id.tabTextSelectedColorButtonWhite);
        // Tab Background Color
        tabBackgroundColorRadioGroup = (RadioGroup)rootView.findViewById(R.id.tabBackgroundColorRadioGroup);
        tabBackgroundColorButtonFireEngineRed = (RadioButtonCenter)rootView.findViewById(R.id.tabBackgroundColorButtonFireEngineRed);
        // Toolbar Background Color
        toolbarColorRadioGroup = (RadioGroup)rootView.findViewById(R.id.toolbarColorRadioGroup);
        toolbarColorButtonFireEngineRed = (RadioButtonCenter)rootView.findViewById(R.id.toolbarColorButtonFireEngineRed);
        // Selected Text Style
        selectedTextStyleRadioGroup = (RadioGroup)rootView.findViewById(R.id.selectedTextStyleRadioGroup);
        selectedTextStyleButtonBold = (RadioButton)rootView.findViewById(R.id.selectedTextStyleButtonBold);
        // Unselected Text Style
        unselectedTextStyleRadioGroup = (RadioGroup)rootView.findViewById(R.id.unselectedTextStyleRadioGroup);
        unselectedTextStyleButtonBold = (RadioButton)rootView.findViewById(R.id.unselectedTextStyleButtonBold);

        rootView.findViewById(R.id.tabPaddingInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.tabBackgroundColorInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.tabTextColorInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.tabTextSelectedColorInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.toolbarColorInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.textSelectedStyleInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.textUnselectedStyleInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.textAllCapsInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.underlineColorInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.underlineHeightInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.indicatorColorInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.indicatorHeightInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.paddingMiddleInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.sameWeighTabsInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.sameWeighTabsInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.showToolbarInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.numberOfTabsInfoButton).setOnClickListener(this);

        setupAndReset();
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) getActivity();
        mainActivity.addFragment(this);
    }

    @Override
    public void onDetach() {
        mainActivity.removeFragment(this);
        super.onDetach();
    }

    @Override
    public void setupAndReset() {
        /** SeekBars **/

        underlineHeightDp = UNDERLINE_HEIGHT_DEFAULT_DP;
        underlineHeightTextView.setText(getString(R.string.underline_height) + ": " + underlineHeightDp + "dp");
        underlineHeightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                underlineHeightDp = progress;
                underlineHeightTextView.setText(getString(R.string.underline_height) + ": " + underlineHeightDp + "dp");
                mainActivity.startTabsActivityIntent.putExtra(UNDERLINE_HEIGHT, underlineHeightDp);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        numberOfTabs = NUMBER_OF_TABS_DEFAULT;
        numberOfTabsTextView.setText(getString(R.string.number_of_tabs) + ": " + numberOfTabs);
        numberOfTabsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numberOfTabs = progress + 1;
                numberOfTabsTextView.setText(getString(R.string.number_of_tabs) + ": " + numberOfTabs);
                mainActivity.startTabsActivityIntent.putExtra(NUMBER_OF_TABS, numberOfTabs);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        indicatorHeightDp = INDICATOR_HEIGHT_DEFAULT_DP;
        indicatorHeightTextView.setText(getString(R.string.indicator_height) + ": " + indicatorHeightDp + "dp");
        indicatorHeightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                indicatorHeightDp = progress;
                indicatorHeightTextView.setText(getString(R.string.indicator_height) + ": " + indicatorHeightDp + "dp");
                mainActivity.startTabsActivityIntent.putExtra(INDICATOR_HEIGHT, indicatorHeightDp);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        tabPaddingDp = TAB_PADDING_DEFAULT_DP;
        tabPaddingTextView.setText(getString(R.string.tab_padding) + ": " + tabPaddingDp + "dp");
        tabPaddingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tabPaddingDp = progress;
                tabPaddingTextView.setText(getString(R.string.tab_padding) + ": " + tabPaddingDp + "dp");
                mainActivity.startTabsActivityIntent.putExtra(TAB_PADDING, tabPaddingDp);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        underlineHeightSeekBar.setProgress(underlineHeightDp);
        numberOfTabsSeekBar.setProgress(numberOfTabs);
        indicatorHeightSeekBar.setProgress(indicatorHeightDp);
        tabPaddingSeekBar.setProgress(tabPaddingDp);

        /** RadioGroups **/

        // Indicator Color
        indicatorColorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String key = INDICATOR_COLOR;
                if (checkedId == R.id.indicatorColorButtonFireEngineRed) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.fire_engine_red);
                } else if (checkedId == R.id.indicatorColorButtonGorse) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.gorse);
                } else if (checkedId == R.id.indicatorColorButtonIrisBlue) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.iris_blue);
                } else if (checkedId == R.id.indicatorColorButtonSafetyOrange) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.safety_orange);
                } else if (checkedId == R.id.indicatorColorButtonWhite) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.white);
                } else if (checkedId == R.id.indicatorColorButtonBlack) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.black);
                } else if (checkedId == R.id.indicatorColorButtonMantis) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.mantis);
                }
            }
        });

        // Underline Color
        underlineColorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String key = UNDERLINE_COLOR;
                if (checkedId == R.id.underlineColorButtonFireEngineRed) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.fire_engine_red);
                } else if (checkedId == R.id.underlineColorButtonGorse) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.gorse);
                } else if (checkedId == R.id.underlineColorButtonIrisBlue) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.iris_blue);
                } else if (checkedId == R.id.underlineColorButtonSafetyOrange) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.safety_orange);
                } else if (checkedId == R.id.underlineColorButtonWhite) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.white);
                } else if (checkedId == R.id.underlineColorButtonBlack) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.black);
                } else if (checkedId == R.id.underlineColorButtonMantis) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.mantis);
                }
            }
        });

        // Tab Background Color
        tabBackgroundColorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String key = TAB_BACKGROUND;
                if (checkedId == R.id.tabBackgroundColorButtonFireEngineRed) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.fire_engine_red);
                } else if (checkedId == R.id.tabBackgroundColorButtonGorse) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.gorse);
                } else if (checkedId == R.id.tabBackgroundColorButtonIrisBlue) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.iris_blue);
                } else if (checkedId == R.id.tabBackgroundColorButtonSafetyOrange) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.safety_orange);
                } else if (checkedId == R.id.tabBackgroundColorButtonWhite) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.white);
                } else if (checkedId == R.id.tabBackgroundColorButtonBlack) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.black);
                } else if (checkedId == R.id.tabBackgroundColorButtonMantis) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.mantis);
                }
            }
        });

        // Toolbar Background Color
        toolbarColorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String key = TOOLBAR_BACKGROUND;
                if (checkedId == R.id.toolbarColorButtonFireEngineRed) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.fire_engine_red);
                } else if (checkedId == R.id.toolbarColorButtonGorse) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.gorse);
                } else if (checkedId == R.id.toolbarColorButtonIrisBlue) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.iris_blue);
                } else if (checkedId == R.id.toolbarColorButtonSafetyOrange) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.safety_orange);
                } else if (checkedId == R.id.toolbarColorButtonWhite) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.white);
                } else if (checkedId == R.id.toolbarColorButtonBlack) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.black);
                } else if (checkedId == R.id.toolbarColorButtonMantis) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.mantis);
                }
            }
        });

        // Text Color Unselected
        tabTextColorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String key = TEXT_COLOR_UNSELECTED;
                if (checkedId == R.id.tabTextColorButtonFireEngineRed) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.fire_engine_red);
                } else if (checkedId == R.id.tabTextColorButtonGorse) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.gorse);
                } else if (checkedId == R.id.tabTextColorButtonIrisBlue) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.iris_blue);
                } else if (checkedId == R.id.tabTextColorButtonSafetyOrange) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.safety_orange);
                } else if (checkedId == R.id.tabTextColorButtonWhite) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.white);
                } else if (checkedId == R.id.tabTextColorButtonBlack) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.black);
                } else if (checkedId == R.id.tabTextColorButtonMantis) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.mantis);
                }
            }
        });

        // Text Color Selected
        tabTextSelectedColorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String key = TEXT_COLOR_SELECTED;
                if(checkedId == R.id.tabTextSelectedColorButtonFireEngineRed) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.fire_engine_red);
                } else if(checkedId == R.id.tabTextSelectedColorButtonGorse) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.gorse);
                } else if(checkedId == R.id.tabTextSelectedColorButtonIrisBlue) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.iris_blue);
                } else if(checkedId == R.id.tabTextSelectedColorButtonSafetyOrange) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.safety_orange);
                } else if(checkedId == R.id.tabTextSelectedColorButtonWhite) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.white);
                } else if(checkedId == R.id.tabTextSelectedColorButtonBlack) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.black);
                } else if(checkedId == R.id.tabTextSelectedColorButtonMantis) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.mantis);
                }
            }
        });

        // Text Style Selected
        selectedTextStyleRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String key = TEXT_STYLE_SELECTED;
                if (checkedId == R.id.selectedTextStyleButtonNormal) {
                    mainActivity.startTabsActivityIntent.putExtra(key, Typeface.NORMAL);
                } else if (checkedId == R.id.selectedTextStyleButtonItallic) {
                        mainActivity.startTabsActivityIntent.putExtra(key, Typeface.ITALIC);
                } else if (checkedId == R.id.selectedTextStyleButtonBold) {
                        mainActivity.startTabsActivityIntent.putExtra(key, Typeface.BOLD);
                }
            }
        });

        // Text Style Unselected
        unselectedTextStyleRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String key = TEXT_STYLE_UNSELECTED;
                if (checkedId == R.id.unselectedTextStyleButtonNormal) {
                    mainActivity.startTabsActivityIntent.putExtra(key, Typeface.NORMAL);
                } else if (checkedId == R.id.unselectedTextStyleButtonItallic) {
                        mainActivity.startTabsActivityIntent.putExtra(key, Typeface.ITALIC);
                } else if (checkedId == R.id.unselectedTextStyleButtonBold) {
                        mainActivity.startTabsActivityIntent.putExtra(key, Typeface.BOLD);
                }
            }
        });

        indicatorColorButtonWhite.setChecked(true);
        underlineColorButtonMantis.setChecked(true);

        tabTextColorButtonWhite.setChecked(true);
        tabTextSelectedColorButtonWhite.setChecked(true);

        tabBackgroundColorButtonFireEngineRed.setChecked(true);
        toolbarColorButtonFireEngineRed.setChecked(true);

        selectedTextStyleButtonBold.setChecked(true);
        unselectedTextStyleButtonBold.setChecked(true);

        /** CheckBoxes **/

        // Text Style Unselected
        sameWeightTabsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mainActivity.startTabsActivityIntent.putExtra(SAME_WEIGHT_TABS, isChecked);
            }
        });

        // Text Style Unselected
        paddingMiddleCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mainActivity.startTabsActivityIntent.putExtra(PADDING_MIDDLE, isChecked);
            }
        });

        // Text Style Unselected
        textAllCapsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mainActivity.startTabsActivityIntent.putExtra(TEXT_ALL_CAPS, isChecked);
            }
        });

        // Text Style Unselected
        showToolbarCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mainActivity.startTabsActivityIntent.putExtra(SHOW_TOOLBAR, isChecked);
            }
        });

        sameWeightTabsCheckBox.setChecked(true);
        paddingMiddleCheckBox.setChecked(false);
        textAllCapsCheckBox.setChecked(true);
        showToolbarCheckBox.setChecked(true);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tabPaddingInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.tab_padding).setMessage(R.string.tab_padding_details).create().show();
        } else if(v.getId() == R.id.tabBackgroundColorInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.tab_background_color)
                    .setMessage(R.string.tab_background_color_details)
                    .create()
                    .show();
        } else if(v.getId() == R.id.tabTextColorInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.tab_text_color).setMessage(R.string.tab_text_color_details).create().show();
        } else if(v.getId() == R.id.tabTextSelectedColorInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.tab_text_selected_color)
                    .setMessage(R.string.tab_text_selected_color_details)
                    .create()
                    .show();
        } else if(v.getId() == R.id.toolbarColorInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.toolbar_color).setMessage(R.string.toolbar_color_details).create().show();
        } else if(v.getId() == R.id.textSelectedStyleInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.text_selected_style)
                    .setMessage(R.string.text_selected_style_details)
                    .create()
                    .show();
        } else if(v.getId() == R.id.textUnselectedStyleInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.text_unselected_style)
                    .setMessage(R.string.text_unselected_style_details)
                    .create()
                    .show();
        } else if(v.getId() == R.id.textAllCapsInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.text_all_caps).setMessage(R.string.text_all_caps_details).create().show();
        } else if(v.getId() == R.id.underlineColorInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.underline_color).setMessage(R.string.underline_color_details).create().show();
        } else if(v.getId() == R.id.underlineHeightInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.underline_height).setMessage(R.string.underline_height_details).create().show();
        } else if(v.getId() == R.id.indicatorColorInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.indicator_color).setMessage(R.string.indicator_color_details).create().show();
        } else if(v.getId() == R.id.indicatorHeightInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.indicator_height).setMessage(R.string.indicator_height_details).create().show();
        } else if(v.getId() == R.id.paddingMiddleInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.padding_middle).setMessage(R.string.padding_middle_details).create().show();
        } else if(v.getId() == R.id.sameWeighTabsInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.same_weight_tabs).setMessage(R.string.same_weight_tabs_details).create().show();
        } else if(v.getId() == R.id.showToolbarInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.show_toolbar).setMessage(R.string.show_toolbar_details).create().show();
        } else if(v.getId() == R.id.numberOfTabsInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.number_of_tabs).setMessage(R.string.number_of_tabs_details).create().show();
        }
    }
}
