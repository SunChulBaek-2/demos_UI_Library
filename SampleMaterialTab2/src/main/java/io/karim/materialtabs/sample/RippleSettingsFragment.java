package io.karim.materialtabs.sample;

import android.app.Activity;
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

import io.karim.MaterialRippleLayout;

public class RippleSettingsFragment extends Fragment implements ResettableFragment, View.OnClickListener {

    public static final String RIPPLE_DURATION = "RIPPLE_DURATION";
    public static final String RIPPLE_ALPHA_FLOAT = "RIPPLE_ALPHA_FLOAT";
    public static final String RIPPLE_COLOR = "RIPPLE_COLOR";
    public static final String RIPPLE_DELAY_CLICK = "RIPPLE_DELAY_CLICK";
    public static final String RIPPLE_DIAMETER = "RIPPLE_DIAMETER";
    public static final String RIPPLE_FADE_DURATION = "RIPPLE_FADE_DURATION";
    public static final String RIPPLE_HIGHLIGHT_COLOR = "RIPPLE_HIGHLIGHT_COLOR";
    public static final String RIPPLE_OVERLAY = "RIPPLE_OVERLAY";
    public static final String RIPPLE_PERSISTENT = "RIPPLE_PERSISTENT";
    public static final String RIPPLE_ROUNDED_CORNERS_RADIUS = "RIPPLE_ROUNDED_CORNERS_RADIUS";

    private static final int RIPPLE_DURATION_MULTIPLIER = 50;

    private MainActivity mainActivity;

    int rippleDurationMs;
    float rippleAlphaFloat;
    int rippleFadeDurationMs;
    int rippleRoundedCornersRadiusDp;
    float rippleDiameterDp;

    // Ripple Duration
    SeekBar rippleDurationSeekBar;
    TextView rippleDurationTextView;

    // Ripple Alpha Float
    SeekBar rippleAlphaFloatSeekBar;
    TextView rippleAlphaFloatTextView;

    // Ripple Color
    RadioGroup rippleColorRadioGroup;
    RadioButton rippleColorButtonWhite;

    // Ripple Delay Click
    CheckBox rippleDelayClickCheckBox;

    // Ripple Diameter
    SeekBar rippleDiameterSeekBar;
    TextView rippleDiameterTextView;

    // Ripple Fade Duration
    SeekBar rippleFadeDurationSeekBar;
    TextView rippleFadeDurationTextView;

    // Ripple Highlight Color
    RadioGroup rippleHighlightColorRadioGroup;
    RadioButton rippleHighlightColorButtonWhite;

    // Ripple Overlay
    CheckBox rippleOverlayCheckBox;

    // Ripple Persistent
    CheckBox ripplePersistentCheckBox;

    // Ripple Rounded Corners Radius
    SeekBar rippleRoundedCornersRadiusSeekBar;
    TextView rippleRoundedCornersRadiusTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ripple_settings, container, false);

        rippleDurationSeekBar = (SeekBar)rootView.findViewById(R.id.rippleDurationSeekBar);
        rippleDurationTextView = (TextView)rootView.findViewById(R.id.rippleDurationTextView);

        rippleAlphaFloatSeekBar = (SeekBar)rootView.findViewById(R.id.rippleAlphaFloatSeekBar);
        rippleAlphaFloatTextView = (TextView)rootView.findViewById(R.id.rippleAlphaFloatTextView);

        rippleColorRadioGroup = (RadioGroup)rootView.findViewById(R.id.rippleColorRadioGroup);
        rippleColorButtonWhite = (RadioButton)rootView.findViewById(R.id.rippleColorButtonWhite);

        rippleDelayClickCheckBox = (CheckBox)rootView.findViewById(R.id.rippleDelayClickCheckBox);

        rippleDiameterSeekBar = (SeekBar)rootView.findViewById(R.id.rippleDiameterSeekBar);
        rippleDiameterTextView = (TextView)rootView.findViewById(R.id.rippleDiameterTextView);

        rippleFadeDurationSeekBar = (SeekBar)rootView.findViewById(R.id.rippleFadeDurationSeekBar);
        rippleFadeDurationTextView = (TextView)rootView.findViewById(R.id.rippleFadeDurationTextView);

        rippleHighlightColorRadioGroup = (RadioGroup)rootView.findViewById(R.id.rippleHighlightColorRadioGroup);
        rippleHighlightColorButtonWhite = (RadioButton)rootView.findViewById(R.id.rippleHighlightColorButtonWhite);

        rippleOverlayCheckBox = (CheckBox)rootView.findViewById(R.id.rippleOverlayCheckBox);

        ripplePersistentCheckBox = (CheckBox)rootView.findViewById(R.id.ripplePersistentCheckBox);

        rippleRoundedCornersRadiusSeekBar = (SeekBar)rootView.findViewById(R.id.rippleRoundedCornersRadiusSeekBar);
        rippleRoundedCornersRadiusTextView = (TextView)rootView.findViewById(R.id.rippleRoundedCornersRadiusTextView);

        rootView.findViewById(R.id.rippleAlphaFloatInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.rippleColorInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.rippleDiameterInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.rippleDurationInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.rippleDelayClickInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.rippleFadeDurationInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.rippleOverlayInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.ripplePersistentInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.rippleHighlightColorInfoButton).setOnClickListener(this);
        rootView.findViewById(R.id.rippleRoundedCornersRadiusInfoButton).setOnClickListener(this);

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

        rippleDurationMs = MaterialRippleLayout.DEFAULT_DURATION;
        rippleDurationTextView.setText(getString(R.string.ripple_duration) + ": " + rippleDurationMs + "ms");
        rippleDurationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rippleDurationMs = progress * RIPPLE_DURATION_MULTIPLIER;
                rippleDurationTextView.setText(getString(R.string.ripple_duration) + ": " + rippleDurationMs + "ms");
                mainActivity.startTabsActivityIntent.putExtra(RIPPLE_DURATION, rippleDurationMs);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        rippleAlphaFloat = MaterialRippleLayout.DEFAULT_ALPHA;
        rippleAlphaFloatTextView.setText(getString(R.string.ripple_alpha_float) + ": " + rippleAlphaFloat);
        rippleAlphaFloatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rippleAlphaFloat = (float) progress / rippleAlphaFloatSeekBar.getMax();
                rippleAlphaFloatTextView.setText(getString(R.string.ripple_alpha_float) + ": " + rippleAlphaFloat);
                mainActivity.startTabsActivityIntent.putExtra(RIPPLE_ALPHA_FLOAT, rippleAlphaFloat);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        rippleFadeDurationMs = MaterialRippleLayout.DEFAULT_FADE_DURATION;
        rippleFadeDurationTextView.setText(getString(R.string.ripple_fade_duration) + ": " + rippleFadeDurationMs + "ms");
        rippleFadeDurationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rippleFadeDurationMs = progress * RIPPLE_DURATION_MULTIPLIER;
                rippleFadeDurationTextView.setText(getString(R.string.ripple_fade_duration) + ": " + rippleFadeDurationMs + "ms");
                mainActivity.startTabsActivityIntent.putExtra(RIPPLE_FADE_DURATION, rippleFadeDurationMs);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        rippleRoundedCornersRadiusDp = MaterialRippleLayout.DEFAULT_ROUNDED_CORNERS_DP;
        rippleRoundedCornersRadiusTextView.setText(getString(R.string.ripple_rounded_corners_radius) + ": " + rippleRoundedCornersRadiusDp + "dp");
        rippleRoundedCornersRadiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rippleRoundedCornersRadiusDp = progress;
                rippleRoundedCornersRadiusTextView.setText(
                        getString(R.string.ripple_rounded_corners_radius) + ": " + rippleRoundedCornersRadiusDp + "dp");
                mainActivity.startTabsActivityIntent.putExtra(RIPPLE_ROUNDED_CORNERS_RADIUS, rippleRoundedCornersRadiusDp);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        rippleDiameterDp = MaterialRippleLayout.DEFAULT_DIAMETER_DP;
        rippleDiameterTextView.setText(getString(R.string.ripple_diameter) + ": " + rippleDiameterDp + "dp");
        rippleDiameterSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rippleDiameterDp = progress;
                rippleDiameterTextView.setText(getString(R.string.ripple_diameter) + ": " + rippleDiameterDp + "dp");
                mainActivity.startTabsActivityIntent.putExtra(RIPPLE_DIAMETER, rippleDiameterDp);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        rippleDurationSeekBar.setProgress(rippleDurationMs / RIPPLE_DURATION_MULTIPLIER);
        rippleAlphaFloatSeekBar.setProgress((int) (rippleAlphaFloat * rippleAlphaFloatSeekBar.getMax()));
        rippleFadeDurationSeekBar.setProgress(rippleFadeDurationMs / RIPPLE_DURATION_MULTIPLIER);
        rippleRoundedCornersRadiusSeekBar.setProgress(rippleRoundedCornersRadiusDp);
        rippleDiameterSeekBar.setProgress((int) rippleDiameterDp);

        /** RadioGroups **/

        // Ripple Color
        rippleColorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String key = RIPPLE_COLOR;
                if (checkedId == R.id.rippleColorButtonFireEngineRed) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.fire_engine_red);
                } else if (checkedId == R.id.rippleColorButtonGorse) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.gorse);
                } else if (checkedId == R.id.rippleColorButtonIrisBlue) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.iris_blue);
                } else if (checkedId == R.id.rippleColorButtonSafetyOrange) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.safety_orange);
                } else if (checkedId == R.id.rippleColorButtonWhite) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.white);
                } else if (checkedId == R.id.rippleColorButtonBlack) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.black);
                } else if (checkedId == R.id.rippleColorButtonMantis) {
                    mainActivity.startTabsActivityIntent.putExtra(key, R.color.mantis);
                }
            }
        });

        // Ripple Highlight Color
        rippleHighlightColorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String key = RIPPLE_HIGHLIGHT_COLOR;
                if (checkedId == R.id.rippleHighlightColorButtonFireEngineRed) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.fire_engine_red_75);
                } else if (checkedId == R.id.rippleHighlightColorButtonGorse) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.gorse_75);
                } else if (checkedId == R.id.rippleHighlightColorButtonIrisBlue) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.iris_blue_75);
                } else if (checkedId == R.id.rippleHighlightColorButtonSafetyOrange) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.safety_orange_75);
                } else if (checkedId == R.id.rippleHighlightColorButtonWhite) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.white_75);
                } else if (checkedId == R.id.rippleHighlightColorButtonBlack) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.black_75);
                } else if (checkedId == R.id.rippleHighlightColorButtonMantis) {
                        mainActivity.startTabsActivityIntent.putExtra(key, R.color.mantis_75);
                }
            }
        });

        rippleColorButtonWhite.setChecked(true);
        rippleHighlightColorButtonWhite.setChecked(true);

        /** Checkboxes **/

        rippleDelayClickCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mainActivity.startTabsActivityIntent.putExtra(RippleSettingsFragment.RIPPLE_DELAY_CLICK, isChecked);
            }
        });

        ripplePersistentCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mainActivity.startTabsActivityIntent.putExtra(RippleSettingsFragment.RIPPLE_PERSISTENT, isChecked);
            }
        });

        rippleOverlayCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mainActivity.startTabsActivityIntent.putExtra(RippleSettingsFragment.RIPPLE_OVERLAY, isChecked);
            }
        });

        rippleDelayClickCheckBox.setChecked(MaterialRippleLayout.DEFAULT_DELAY_CLICK);
        ripplePersistentCheckBox.setChecked(MaterialRippleLayout.DEFAULT_PERSISTENT);
        rippleOverlayCheckBox.setChecked(MaterialRippleLayout.DEFAULT_RIPPLE_OVERLAY);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rippleRoundedCornersRadiusInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_rounded_corners_radius)
                    .setMessage(R.string.ripple_rounded_corners_radius_details)
                    .create()
                    .show();
        } else if (v.getId() == R.id.rippleHighlightColorInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_highlight_color)
                    .setMessage(R.string.ripple_highlight_color_details)
                    .create()
                    .show();
        } else if (v.getId() == R.id.ripplePersistentInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_persistent).setMessage(R.string.ripple_persistent_details).create().show();
        } else if (v.getId() == R.id.ripplePersistentInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_persistent).setMessage(R.string.ripple_persistent_details).create().show();
        } else if (v.getId() == R.id.rippleOverlayInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_overlay).setMessage(R.string.ripple_overlay_details).create().show();
        } else if (v.getId() == R.id.rippleFadeDurationInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_fade_duration)
                    .setMessage(R.string.ripple_fade_duration_details)
                    .create()
                    .show();
        } else if (v.getId() == R.id.rippleDelayClickInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_delay_click).setMessage(R.string.ripple_delay_click_details).create().show();
        } else if (v.getId() == R.id.rippleDurationInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_duration).setMessage(R.string.ripple_duration_details).create().show();
        } else if (v.getId() == R.id.rippleDiameterInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_diameter).setMessage(R.string.ripple_diameter_details).create().show();
        } else if (v.getId() == R.id.rippleColorInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_color).setMessage(R.string.ripple_color_details).create().show();
        } else if (v.getId() == R.id.rippleAlphaFloatInfoButton) {
            new AlertDialog.Builder(getActivity()).setTitle(R.string.ripple_alpha_float).setMessage(R.string.ripple_alpha_float_details).create().show();
        }
    }
}
