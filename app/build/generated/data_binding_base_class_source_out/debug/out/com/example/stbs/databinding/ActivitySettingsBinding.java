// Generated by view binder compiler. Do not edit!
package com.example.stbs.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.stbs.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySettingsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button changePwdBtn;

  @NonNull
  public final Button logoutBtn;

  @NonNull
  public final ImageButton settingsBackBtn;

  @NonNull
  public final TextView welcomeUser;

  private ActivitySettingsBinding(@NonNull ConstraintLayout rootView, @NonNull Button changePwdBtn,
      @NonNull Button logoutBtn, @NonNull ImageButton settingsBackBtn,
      @NonNull TextView welcomeUser) {
    this.rootView = rootView;
    this.changePwdBtn = changePwdBtn;
    this.logoutBtn = logoutBtn;
    this.settingsBackBtn = settingsBackBtn;
    this.welcomeUser = welcomeUser;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.change_pwd_btn;
      Button changePwdBtn = rootView.findViewById(id);
      if (changePwdBtn == null) {
        break missingId;
      }

      id = R.id.logout_btn;
      Button logoutBtn = rootView.findViewById(id);
      if (logoutBtn == null) {
        break missingId;
      }

      id = R.id.settings_back_btn;
      ImageButton settingsBackBtn = rootView.findViewById(id);
      if (settingsBackBtn == null) {
        break missingId;
      }

      id = R.id.welcome_user;
      TextView welcomeUser = rootView.findViewById(id);
      if (welcomeUser == null) {
        break missingId;
      }

      return new ActivitySettingsBinding((ConstraintLayout) rootView, changePwdBtn, logoutBtn,
          settingsBackBtn, welcomeUser);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
